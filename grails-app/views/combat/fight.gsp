<!DOCTYPE HTML>
<html>
<head>
    <meta name="layout" content="main"/>

</head>

<body class="main">

<content tag="nav"></content>

<h1><g:message code="fight.fight.title" args="[pc.name, message(code: mob.name)]"/></h1>

<div id="message" class="message">
    <g:if test="${flash.message}">${flash.message}</g:if>
</div>

<div class="fight_opponent">
    <g:render template="fight_mob" model="[mob: mob]"/>
</div>

<div class="nav">
    <g:link controller="combat" action="fight"><g:message code="fight.link.fight"/></g:link>
</div>

</body>
</html>