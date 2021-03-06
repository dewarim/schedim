grails.servlet.version = "3.0"
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.8
grails.project.source.level = 1.8
grails.project.war.file = "target/${appName}.war"
grails.project.dependency.resolver = "maven"

// uncomment (and adjust settings) to fork the JVM to isolate classpaths
//grails.project.fork = [
//   run: [maxMemory:1024, minMemory:64, debug:false, maxPerm:256]
//]

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // specify dependency exclusions here; for example, uncomment this to disable ehcache:
        // excludes 'ehcache'
    }
    log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve
    legacyResolve false // whether to do a secondary resolve on plugin installation, not advised and here for backwards compatibility

    repositories {
        mavenLocal()
        grailsCentral()
        mavenCentral()
//        mavenRepo 'http://repo.spring.io/milestone'
    }
    
    dependencies {
        runtime 'postgresql:postgresql:9.1-901.jdbc4'
    }

    plugins {
        build ':tomcat:8.0.15'
        runtime ":hibernate:3.6.10.19"
        build':release:3.1.1', ':rest-client-builder:2.1.1', {
            export = false
        }
        compile ":asset-pipeline:2.3.9"

        compile ':goblin:0.5.2'
    }
}
