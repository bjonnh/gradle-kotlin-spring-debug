plugins {
    kotlin("jvm")
    application
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    id("org.jetbrains.kotlin.plugin.spring")
    id("org.jetbrains.kotlin.plugin.jpa")
}

apply {
    plugin("io.spring.dependency-management")
}

dependencyManagement {
    imports { mavenBom("org.springframework.boot:spring-boot-dependencies:2.2.0.M2") }
}

application {
    mainClassName = "net.nprod.napralertmatcher.scripts.MainKt"
}

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

    compile(project(":services"))  {
        exclude("ch.qos.logback")
        exclude("org.slf4j")
    }
}
