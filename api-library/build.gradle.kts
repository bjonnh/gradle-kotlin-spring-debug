plugins {
    kotlin("jvm")
    kotlin("plugin.jpa")
    kotlin("plugin.spring")
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

    implementation(kotlin("reflect"))
    implementation(kotlin("stdlib-jdk8"))

    testCompile("org.springframework.boot:spring-boot-starter-test")
}
