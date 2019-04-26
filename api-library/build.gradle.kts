plugins {
    kotlin("jvm")
    id("io.spring.dependency-management")
    id("org.jetbrains.kotlin.plugin.spring")
    id("org.jetbrains.kotlin.plugin.jpa")
}

apply {
    plugin("io.spring.dependency-management")
}

repositories {
    mavenCentral()
    maven { setUrl("https://kotlin.bintray.com/kotlinx") }
}

dependencies {
    api("org.springframework.boot:spring-boot")
    compile("org.springframework.boot:spring-boot-starter-web") {
        exclude(module="spring-boot-starter-logging")
    }
    compile("org.springframework.boot:spring-boot-starter-data-jpa") {
        exclude(module="spring-boot-starter-logging")
    }
    compile("org.springframework.boot:spring-boot-starter-data-solr") {
        exclude(module="spring-boot-starter-logging")
    }

    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    testCompile("org.springframework.boot:spring-boot-starter-test")
}
