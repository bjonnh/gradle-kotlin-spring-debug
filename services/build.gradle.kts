plugins {
    kotlin("jvm")
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

repositories {
    mavenCentral()
    maven { setUrl("https://kotlin.bintray.com/kotlinx") }
}

dependencies {
    api("org.springframework.boot:spring-boot")
    compile("org.jetbrains.kotlinx:kotlinx-serialization-runtime:0.10.0")
    compile("org.springframework.boot:spring-boot-starter-web") {
        exclude(module="spring-boot-starter-logging")
    }
    compile("org.springframework.boot:spring-boot-starter-data-jpa") {
            exclude(module="spring-boot-starter-logging")
    }
    compile("org.springframework.boot:spring-boot-starter-data-solr") {
        exclude(module="spring-boot-starter-logging")
    }

    compile("org.postgresql:postgresql:42.2.5")
    compile("org.reactivestreams:reactive-streams:1.0.2")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("io.springfox:springfox-swagger2:2.9.2")

    testCompile("org.springframework.boot:spring-boot-starter-test")

    compile("org.springframework.plugin:spring-plugin-core:1.2.0.RELEASE")
}
