grails.servlet.version = "3.0" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.work.dir = "target/work"
grails.project.target.level = 1.7
grails.project.source.level = 1.7
grails.project.war.file = "target/${appName}.war"

grails.project.fork = [
  // configure settings for compilation JVM, note that if you alter the Groovy version forked compilation is required
  //  compile: [maxMemory: 256, minMemory: 64, debug: false, maxPerm: 256, daemon:true],

  // configure settings for the test-app JVM, uses the daemon by default
  test: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, daemon: true],
  // configure settings for the run-app JVM
  run: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve: false],
  // configure settings for the run-war JVM
  war: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve: false],
  // configure settings for the Console UI JVM
  console: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256]
]

grails.project.dependency.resolver = "maven" // or ivy
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
    inherits true // Whether to inherit repository definitions from plugins

    grailsPlugins()
    grailsHome()
    grailsCentral()

    mavenLocal()
    mavenCentral()

  }

  dependencies {
    compile("joda-time:joda-time-hibernate:1.3") {
      excludes "joda-time", "hibernate"
    }

    test "org.spockframework:spock-grails-support:0.7-groovy-2.0"
    test "org.gebish:geb-spock:0.9.0-RC-1"
  }

  plugins {
    build ":tomcat:7.0.41"

    // plugins for the compile step
    compile ":scaffolding:2.0.0.RC1"
    compile ':cache:1.1.1'

    compile ":spring-security-core:1.2.7.3"
    compile ":codenarc:0.19"
    compile ":joda-time:1.4"

    test ":geb:0.9.0"
    test(":spock:0.7") {
      exclude "spock-grails-support"
    }

    // plugins needed at runtime but not for compilation
    runtime ":hibernate:3.6.10.M5"
    runtime ":database-migration:1.3.5"
    runtime ":jquery:1.10.2"
    runtime ":resources:1.2"
    // Uncomment these (or add new ones) to enable additional resources capabilities
    //runtime ":zipped-resources:1.0.1"
    //runtime ":cached-resources:1.1"
    //runtime ":yui-minify-resources:0.1.5"
  }
}
