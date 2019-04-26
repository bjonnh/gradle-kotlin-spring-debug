plugins {
    //application
    id("org.springframework.boot")
}

/*application {
    mainClassName = "net.nprod.napralertmatcher.scripts.MainKt"
}*/

dependencies {
    api("org.springframework.boot:spring-boot")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.1.1")
    compile("ch.qos.logback:logback-classic:1.2.3")
    compile("org.jetbrains.exposed:exposed:0.11.2")
    compile("org.jetbrains.kotlin:kotlin-reflect")
    compile("org.apache.commons:commons-csv:1.6")
    compile("org.apache.lucene:lucene-suggest:7.7.0")
    compile("com.zaxxer:HikariCP:2.7.8")
    compile("com.h2database:h2:1.4.198")
    compile("org.postgresql:postgresql:42.2.5")

    compile("org.springframework.cloud:spring-cloud-starter-zookeeper-all:2.1.1.RELEASE") {
        exclude(module="spring-boot-starter-logging")
        exclude(group="org.apache.zookeeper", module="zookeeper")
    }

    // TODO uncomment these when you've created the submodule
//    compile(project(":connector"))
//    compile(project(":configurationmanager"))

    implementation(project(":api-library"))
}
