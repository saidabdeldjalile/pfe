<html>
<head>

    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@500&display=swap" rel="stylesheet">

    <style type="text/css">
        * {
          box-sizing: border-box;
          font-family: 'Roboto', sans-serif;
        }
        html,body,div,p {
            margin: 0;
            padding: 0;
        }
        .column {
            float: left;
        }

        .left {
          width: 13%;
        }

        .right {
          width: 87%;
        }

        .row:after {
          content: "";
          display: table;
          clear: both;
        }

        .text-bold {
           font-weight: bold;
        }

        .print-vert {
            height: 140px;
        }

    </style>
</head>
<body>
	<#list pvs as pv>
		<div style="position:relative;padding-top: 20px;max-height: 210px; width:200px; min-height: 200px;">
                        <div class="row" style="padding: 0 10px; font-size: 16px; text-align: center; font-weight: bold; vertical-align: middle; margin-bottom: 5px;">
                            <div class="column left text-bold">
                                <p class="" style="writing-mode: vertical-rl; font-size: 12px; ">
                                    S/N:
                                </p>
                            </div>
                            <span style="vertical-align: middle;">
                                AIR ALGERIE
                            </span>
                            <img src="resources/logo.jpg" style="height: 24; vertical-align: middle; margin-left: 5px;">
                        </div>

                        <div class="row" style="padding: 0 10px; font-size: 12px;">
                            <div class="column left text-bold" style="">
                                <p class="print-vert" style="writing-mode: vertical-rl; font-size: 12px; ">
                                    <#if (pv.numser)??>${pv.numser}</#if>
                                </p>
                            </div>

                            <div class="column right">
                                <div class="row text-bold" >
                                    <p>
                                        <#if (pv.designation)??>${pv.designation}</#if>
                                    </p>
                                    <p style="margin-top: 3px;">
                                        <#if (pv.unite.uniteId)??>${pv.unite.uniteId}</#if>  
                                        &nbsp;  
                                        <#if (pv.codeNom)??>${pv.codeNom}</#if>
                                    </p>
                                </div>
                                <div class="row" style="position: absolute; right: 0px; bottom: 0;">
                                    <img src="resources/${pv.codeNom?replace(' ', '')}.png" >
                                </div>
                            </div>
                        </div>
                        
		</div>
		<p style="page-break-after:always;margin: 0;"></p>
	</#list>
</body>
</html>
