import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

//import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    val kotlinVersion = "1.3.30"
    id("nebula.kotlin") version kotlinVersion // sets up kotlin and kotlin versions
    kotlin("plugin.spring") version kotlinVersion
    kotlin("plugin.jpa") version kotlinVersion

    id("org.springframework.boot") version "2.2.0.M2"
    id("kotlinx-serialization") version ("1.3.30")
    //id("org.jetbrains.dokka") version "0.9.18"
}

var ktorVersion = "1.1.1"
var kotlinVersion = "1.3.30"
var arrowVersion = "0.9.0-SNAPSHOT"
val springBootVersion = "2.2.0.M2"

allprojects {
    group = "net.nprod"

    // add the plugins to all subprojects
    apply {
        plugin("org.jetbrains.kotlin.jvm")
        plugin("org.jetbrains.kotlin.plugin.jpa")
        plugin("org.jetbrains.kotlin.plugin.spring")
    }
    
    repositories {
        jcenter()
        maven { setUrl("https://repo.spring.io/snapshot") }
        maven { setUrl("https://repo.spring.io/milestone") }

        maven { setUrl("https://dl.bintray.com/bjonnh/RDF4K") }
        maven { setUrl("https://oss.jfrog.org/artifactory/oss-snapshot-local/") }

        maven { setUrl("https://kotlin.bintray.com/kotlinx") }
    }
    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
        kotlinOptions.freeCompilerArgs = listOf("-Xjsr305=strict")
    }
    dependencies {
        implementation(platform("org.springframework.boot:spring-boot-dependencies:${springBootVersion}")) // add spring BOM to all projects
    }
}

/*
tasks {
    val dokka by getting(DokkaTask::class) {
        outputFormat = "html"
        outputDirectory = "$buildDir/output"
        sourceDirs = files(subprojects.map { p -> File(p.projectDir, "/src/main/kotlin") })
    }
}
*/
