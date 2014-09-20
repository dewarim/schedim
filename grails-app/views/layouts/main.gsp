<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title><g:layoutTitle default="Grails"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">

        <asset:link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon"/>
        <asset:stylesheet src="layout.css"/>
        <asset:stylesheet src="goblin.css"/>
        <asset:javascript src="jquery-2.1.1.js"/>
        <asset:javascript src="goblin.js"/>
        <asset:script type="text/javascript">

            function hideDiv(id) {
                $("#"+id).css('display','none');
            }
    
            function showDiv(id) {
                $("#"+id).css('display','block');
            }

            <g:if test="${pc}">
                /* This looks for updates to player_messages every 5 seconds. */
                function messageReload(){
                    $('#player_messages').load('${createLink(controller:"playerCharacter", action:"fetchMessages", params:[pc:pc.id]) }');
        }
            </g:if>

        </asset:script>
        
		<g:layoutHead/>
	</head>
	<body>
		<div id="grailsLogo" role="banner"><a href="http://grails.org"><img src="${resource(dir: 'images', file: 'grails_logo.png')}" alt="Grails"/></a></div>
		<g:layoutBody/>
		<div class="footer" role="contentinfo"></div>
		<div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>
	</body>
</html>
