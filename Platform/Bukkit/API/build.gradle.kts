plugins {
    id("java")
    id("maven-publish")
}

group = "io.gitlab.lone64.framework.bukkit.api"
version = "1.0.0"

dependencies {
    compileOnly("com.iridium", "IridiumColorAPI", "1.0.9")
    compileOnly("com.github.LoneDev6", "API-ItemsAdder", "3.6.1")
    compileOnly("com.googlecode.json-simple", "json-simple", "1.1")
}

tasks.jar {
    archiveFileName.set("mcframework-api-${version}-release.jar")
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "io.gitlab.lone64"
            artifactId = "mcframework-api"
            from(components["java"])
        }
    }

    repositories {
        maven("https://repo.repsy.io/mvn/lone64/releases/") {
            credentials {
                username = "${properties["MAVEN_USERNAME"]}"
                password = "${properties["MAVEN_PASSWORD"]}"
            }
        }
    }
}