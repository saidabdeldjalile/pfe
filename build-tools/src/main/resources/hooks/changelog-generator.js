#!/usr/bin/env node

const https = require('https');
const fs = require('fs')

const constants = require('../gitlab_config');

const version = process.argv[2];

const rootPath = process.argv[3];
const file = rootPath + '/changelog.md';

const baseUrl = constants.environment.url;
const api_route = constants.environment.api_route;
const projectId = constants.environment.project_id;
const privatToken = constants.environment.user.token;
const milestone = "&sort=asc&scope=all&milestone=" + version;

const labels = [
	{
		'name' : 'Nouvelles fonctionnalités',
		'label' : [
			'Type: Feature'
		]
	}, {
		'name' : 'Améliorations',
		'label' : [
			'Type: Enhancement',
		]
	}, {
		'name' : 'Améliorations',
		'label' : [
			'Type: Cleaning'
		]
	}, 
	{
		'name' : 'Bugs',
		'label' : [
			'Type: Bug'
		]
	}
];

var issuesUrl = baseUrl + api_route + projectId + "/issues/" + "?private_token=" + privatToken + milestone;

async function getIssues() {
	promises = [];
	try {
		// filter by labels
		for (let label of labels) {
			let queryString = '&labels=';
			const promise = processRequest(issuesUrl + queryString + (label.label));
			promises.push(promise);
		}
		  
		let tmpChangelog = await Promise.all(promises);

		// merge issues with same label title
		changelogEntries = mergeIssues(tmpChangelog);

		// parse changelog
		let changelogText = templating();
		changelogText += parseChangelog(changelogEntries);
		
		// Write file
		writeToFile(changelogText);

		
		
	} catch (err) {
		console.log(err);
	}
}

function processRequest(url) {
	var changelog = [];
	return new Promise(function(resolve, reject) {
		var req = https.get(url, (res) => {
		    let body = "";

		    res.on("data", (chunk) => {
		        body += chunk;
		    });

		    res.on("end", () => {
		        try {
		            let json = JSON.parse(body);
		            
		            json.forEach(obj => {
		            	changelog.push({
		            		id: obj['iid']
		            		, url: obj['web_url']
		            		, title: obj['title']
		            	})
				    });
		        } catch (error) {
		            console.error(error.message);
		            reject(error);
		        };
		        resolve(changelog);
		    });

		}).on("error", (error) => {
		    console.error(error.message);
		    reject(error);
		});

		req.end();
	});
};

function mergeIssues(tmp) {
	let i = 0
	var entries = [];

	for (label of labels) {
		let isPresent = entries.find(value => {return value.title === label.name})
		if (isPresent){
			isPresent.issue = Object.values(isPresent.issue.concat(tmp[i]).reduce((r,o) => {
		        r[o.id] = o;
		        return r;
		    }, {}));
		} else {
			entries.push({title: label.name, issue: tmp[i]})
		}
		i++;
	}

	return entries;
}

function templating() {
	// add date of the day
	const date = formatDate(Date.now());

	// parse changelog
	let result = `# ${version} - (${date}) \n\n`;

	return result;
}
function parseChangelog(entries) {
	let result = "";

	for (entry of entries) {

		if ((entry.issue).length) {
			result += `## ${entry.title} \n\n`;

			Object.entries(entry.issue).forEach(([k, v]) => {
				result += `- ${v.title} [(#${v.id})](${v.url})\n`;
			})
			
			result += `\n`;
		}

	}

	result += `\n`;

	return result;
}

function writeToFile(text) {
	//read existing contents into data
	let data = "";

	try {
		data = fs.readFileSync(file);
	} catch (error) {
		// if file not exist, create it !
		console.log('changelog file created.')
	}
	var fd = fs.openSync(file, 'w+');
	var buffer = Buffer.from(text);

 	// write new data
	fs.writeSync(fd, buffer, 0, buffer.length, 0);
	// append old data
	if (data) {
		fs.writeSync(fd, data, 0, data.length, buffer.length);
	}

	fs.close(fd, function() {
        console.log('changelog successfully updated.');
    });
}

function formatDate(date) {
    var d = new Date(date),
        month = '' + (d.getMonth() + 1),
        day = '' + d.getDate(),
        year = d.getFullYear();

    if (month.length < 2) 
        month = '0' + month;
    if (day.length < 2) 
        day = '0' + day;

    return [day, month, year].join('-');
}

getIssues();

