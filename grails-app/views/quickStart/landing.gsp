<!DOCTYPE HTML>
<html>
<head>

    <meta name="layout" content="main"/>
    <asset:stylesheet src="login.css"/>

    <title><g:message code="portal.landing.title"/></title>
 
</head>

<body class="landing_body main">

<div class="navigation">
   
</div>


<div class="colmask ">

    <div class="landing_col2">
        <h1 class="landing_title"><g:message code="portal.landing.title"/></h1>
        <g:if test="${flash.message}">
            <div class="message" style="margin-left:25%;margin-right:25%;margin-bottom: 2em;">${flash.message}</div>
        </g:if>
        <img class="goblin" style="float:left; padding:2ex;" src="http://images.schedim.de/LittleGoblinSmall.png"
             border="0" alt="Image of a friendly little goblin by Richard Morris (YAFGC)">

        <noscript>
            <div class="font-size:large;font-color:red;"><g:message code="please_use_javascript"/></div>
        </noscript>

        <div class="landing_login">
            <sec:ifLoggedIn>
                <p>
                    <g:message code="logged.in.as"/>:
                    <sec:loggedInUserInfo field="username"/>
                </p>
                <sec:ifAnyGranted roles="ROLE_ADMIN">
                    <g:link action="index" controller="admin">
                        <g:message code="link.to.admin"/>
                    </g:link>
                    <br>
                </sec:ifAnyGranted>
                <sec:ifNotGranted roles="ROLE_ADMIN">
                    <g:link action="start" controller="portal">
                        <g:message code="link.to.characters"/>
                    </g:link>
                </sec:ifNotGranted>

            </sec:ifLoggedIn>
            <sec:ifNotLoggedIn>
                <g:render template="/shared/login" plugin="goblin" model="[postUrl: postUrl]"/>
            </sec:ifNotLoggedIn>

        </div>

        <div class="clear">
            <p>Welcome to Schedim, a fantasy game based upon the Little Goblin framework.
            This game is currently under development. This test server will be reset with each update.
            </p>
            
            <p>You are invited to test the current functionality by using the "anon" login with password "anon".
            If you want to report any bugs or if you miss a specific feature, please file a
                <a href="https://github.com/dewarim/schedim/issues/">bug report</a> or
            or a
                <a href="https://github.com/dewarim/schedim/issues/">feature request</a> on GitHub.com
            </p>

            <p>
                You can also start at once without manual registration or login by using the new <g:link 
                    controller="quickStart" action="start">QuickStart</g:link> feature.
            </p>
            
            <p>You can also just send a mail ( ingo_wiarda@dewarim.de ) or tweet me: <a
                    href="http://twitter.com/#!dewarim">twitter.com/#!/dewarim</a></p>
        </div>

        <div class="documentation_info">
            <p>Documentation for Little Goblin can be found at <a href="http://littlegoblin.de">LittleGoblin.de</a>.</p>
        </div>

        <div class="version_info">
            <pre>
                0.0.2 Allow automatic account creation 
                0.0.1 First version.
            </pre>

            <div class="">
                <a href="${assetPath(src: 'txt/status.txt')}" target="_blank"><g:message code="link.to.status.old"/></a>
            </div>

            <div class="langSelect">
                <br>
                <g:form name="langSelectForm" controller="portal" action="landing">
                    <label for="langSelectField"><g:message code="language.select"/></label>
                    <select id="langSelectField" name="lang" onchange="document.langSelectForm.submit();">
                        <option value="en"><g:message code="language.english"/></option>
                        <option value="fr"><g:message code="language.french"/></option>
                        <!-- <option value="de"></option> -->
                    </select>
                    <noscript><g:submitButton name="changeLang" value="${message(code: 'language.change')}"/></noscript>
                </g:form>
            </div>

        </div>

    </div>

    <div class="col3">
      

    </div>
</div>

</body>
</html>