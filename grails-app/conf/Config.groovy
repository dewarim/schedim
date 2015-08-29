// locations to search for config files that get merged into the main config;
// config files can be ConfigSlurper scripts, Java properties files, or classes
// in the classpath in ConfigSlurper format

// grails.config.locations = [ "classpath:${appName}-config.properties",
//                             "classpath:${appName}-config.groovy",
//                             "file:${userHome}/.grails/${appName}-config.properties",
//                             "file:${userHome}/.grails/${appName}-config.groovy"]

// if (System.properties["${appName}.config.location"]) {
//    grails.config.locations << "file:" + System.properties["${appName}.config.location"]
// }

grails.project.groupId = appName // change this to alter the default package name and Maven publishing destination
grails.mime.file.extensions = true // enables the parsing of file extensions from URLs into the request format
grails.mime.use.accept.header = false
grails.mime.types = [
    all:           '*/*',
    atom:          'application/atom+xml',
    css:           'text/css',
    csv:           'text/csv',
    form:          'application/x-www-form-urlencoded',
    html:          ['text/html','application/xhtml+xml'],
    js:            'text/javascript',
    json:          ['application/json', 'text/json'],
    multipartForm: 'multipart/form-data',
    rss:           'application/rss+xml',
    text:          'text/plain',
    xml:           ['text/xml', 'application/xml']
]

// URL Mapping Cache Max Size, defaults to 5000
//grails.urlmapping.cache.maxsize = 1000

// What URL patterns should be processed by the resources plugin
grails.resources.adhoc.patterns = ['/images/*', '/css/*', '/js/*', '/plugins/*']

// The default codec used to encode data with ${}
grails.views.default.codec = "html" // none, html, base64
grails.views.gsp.encoding = "UTF-8"
grails.converters.encoding = "UTF-8"
// enable Sitemesh preprocessing of GSP pages
grails.views.gsp.sitemesh.preprocess = true
// scaffolding templates configuration
grails.scaffolding.templates.domainSuffix = 'Instance'

// Set to false to use the new Grails 1.2 JSONBuilder in the render method
grails.json.legacy.builder = false
// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true
// packages to include in Spring bean scanning
grails.spring.bean.packages = []
// whether to disable processing of multi part requests
grails.web.disable.multipart=false

// request parameters to mask when logging exceptions
grails.exceptionresolver.params.exclude = ['password']

// configure auto-caching of queries by default (if false you can cache individual queries with 'cache: true')
grails.hibernate.cache.queries = false

environments {
    development {
        grails.logging.jul.usebridge = true
    }
    production {
        grails.logging.jul.usebridge = false
        // TODO: grails.serverURL = "http://www.changeme.com"
    }
}

// log4j configuration
log4j = {

    error 'org.springframework.core.io.support.PathMatchingResourcePatternResolver',
            'org.codehaus.groovy.grails.plugins.DefaultGrailsPlugin',
            'org.codehaus.groovy.grails.commons',
            'org.codehaus.groovy.grails.validation',
            'org.grails.plugin.resource',
            'org.apache.catalina',
            'org.apache.coyote',
            'org.apache.tomcat',
            'org.codehaus.groovy.grails.web.pages.GroovyPageResourceLoader',
            'org.codehaus.groovy.grails',
            'org.apache.naming',
            'grails.app.taglib.org.grails.plugin.resource.ResourceTagLib',
            'org.apache.commons',
            'grails.plugin.fixtures.builder.processor.FixtureBeanPostProcessor'


    warn 'grails.app.services.de.dewarim.goblin.SkillService',
            'grails.app.services.de.dewarim.goblin.ProductionService',
            'grails.app.services.de.dewarim.goblin.MeleeService'
    warn   'grails.plugin.springsecurity.web.authentication',
            'grails.plugin.springsecurity.web.filter'

    debug 'grails.app.controller',
            'grails.app.domain.de.dewarim.goblin',
            'grails.app.domain.de.dewarim.goblin.Creature',
            'grails.app.bootstrap',
            'de.dewarim.goblin.admin',
            'de.dewarim.schedim'

    root {
        debug 'stdout'
    }

}

grails.plugin.springsecurity.userLookup.userDomainClassName = 'de.dewarim.goblin.UserAccount'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'de.dewarim.goblin.UserRole'
grails.plugin.springsecurity.authority.className = 'de.dewarim.goblin.Role'
grails.plugin.springsecurity.userLookup.passwordPropertyName = 'passwd'
grails.plugin.springsecurity.authority.nameField = 'name'
grails.plugin.springsecurity.successHandler.defaultTargetUrl = '/portal/start'
grails.plugin.springsecurity.password.algorithm = 'bcrypt'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
        '/assets/**':               ['permitAll'],
        '/':                        ['permitAll'],
//        '/portal/landing':          ['permitAll'],
]
grails.plugin.springsecurity.interceptUrlMap = [
        '/**': ["IS_AUTHENTICATED_ANONYMOUSLY"]
]
grails.plugin.springsecurity.providerNames = [
        'daoAuthenticationProvider',
//        'anonymousAuthenticationProvider',
        'rememberMeAuthenticationProvider']

apf.filterProcessesUrl='/j_spring_security_check”'

// Uncomment and edit the following lines to start using Grails encoding & escaping improvements

/* remove this line 
// GSP settings
grails {
    views {
        gsp {
            encoding = 'UTF-8'
            htmlcodec = 'xml' // use xml escaping instead of HTML4 escaping
            codecs {
                expression = 'html' // escapes values inside null
                scriptlet = 'none' // escapes output from scriptlets in GSPs
                taglib = 'none' // escapes output from taglibs
                staticparts = 'none' // escapes output from static template parts
            }
        }
        // escapes all not-encoded output at final stage of outputting
        filteringCodecForContentType {
            //'text/html' = 'html'
        }
    }
}
remove this line */
