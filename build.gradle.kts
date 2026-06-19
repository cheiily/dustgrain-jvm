plugins {
    kotlin("jvm") version "2.3.21"
    id("java")

    id("com.vanniktech.maven.publish") version "0.36.0"
    id("io.freefair.lombok") version "9.5.0"
}

kotlin {
    jvmToolchain(24)
}

group = "one.cheily"
var coreVersion = "3.2.0"
version = coreVersion + "-0.1"

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation(kotlin("test"))

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.11.0")
    implementation("one.cheily:dustgrain-core:${coreVersion}")
    implementation("org.slf4j:slf4j-api:2.0.18")
}

tasks.test {
    useJUnitPlatform()
}

mavenPublishing {
    publishToMavenCentral()
    signAllPublications()
    coordinates(
        groupId = group.toString(),
        artifactId = "dustgrain-jvm",
        version = version.toString()
    )

    pom {
        name = "dustgrain-jvm"
        description = "A jvm integration module for dustgrain-core."
        inceptionYear = "2024"
        url = "github.com/cheiily/dustgrain-jvm"

        licenses {
            license {
                name = "MIT License"
                url = "https://opensource.org/license/mit/"
            }
        }

        developers {
            developer {
                id = "cheily"
                name = "cheily"
                email = "software@cheily.one"
                organization = "unaffiliated"
                organizationUrl = "https://cheily.one"
            }
        }

        scm {
            url = "https://github.com/cheily/dustgrain-jvm"
            connection = "scm:git:git://github.com/cheily/dustgrain-jvm.git"
            developerConnection = "scm:git:ssh://github.com/cheily/dustgrain-jvm.git"
        }
    }
}
