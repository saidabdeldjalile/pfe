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
        <#assign nb = 0>
	<#list pvs as pv>
                <#assign nb = nb + 1>
                <#if nb == 1 >
                    <div style="position: relative; min-height: 1000px; page-break-after: always; left: 50" >
                    <div style="position: absolute; left: 0;" >
                </#if>
                <#if nb == 6 >
                    <div style="position: absolute; left: 200px;" >
                </#if>
                <#if nb == 11 >
                    <div style="position: absolute; left: 400px;" >
                </#if>
		<div style="position:relative;padding-top: 20px;max-height: 210px; width:200px; min-height: 200px; border-right: 1px dotted black; border-bottom: 1px dotted black;">
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

                <#if nb == 5 >
                    </div>
                </#if>
                <#if nb == 10 >
                    </div>
                </#if>
                <#if nb == 15 >
                    </div>
                    </div>
                    <p style="page-break-after:always;margin: 0;"></p>
                    <#assign nb = 0>
                <#elseif pv?is_last >
                    </div>
                    </div>
                </#if>

	</#list>
</body>
</html>
