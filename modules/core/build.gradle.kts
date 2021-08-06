import org.jetbrains.dokka.gradle.DokkaTask
import java.net.URL

plugins {
    id("kettle.conventions")
}


// Publishing
//
//publishing {
//    publications {
//        create<MavenPublication>("maven") {
//            groupId = group.toString()
//            artifactId = project.name
//            version = version.toString()
//
//            artifact(tasks.named("remapJar"))
//            artifact(javadocJar)
//            artifact(sourcesJar)
//
//            pom {
//                name.set("Kettle")
//                description.set("Kotlin mod utilities for Fabric")
//                url.set("https://www.curseforge.com/minecraft/mc-mods/kettle/")
//
//                scm {
//                    connection.set("scm:git:git://github.com/Cypher121/kettle.git")
//                    developerConnection.set("scm:git:ssh://github.com/Cypher121/kettle.git")
//                    url.set("https://github.com/Cypher121/kettle/")
//                }
//
//                licenses {
//                    license {
//                        name.set("The MIT License")
//                        url.set("https://opensource.org/licenses/MIT")
//                    }
//                }
//
//                developers {
//                    developer {
//                        id.set("cypher121")
//                        name.set("Cypher121")
//                    }
//                }
//            }
//        }
//    }
//
//    repositories {
//        maven {
//            url = uri("https://oss.sonatype.org/service/local/staging/deploy/maven2")
//
//            credentials {
//                val ossUsername: String by project
//                val ossPassword: String by project
//
//                username = ossUsername
//                password = ossPassword
//            }
//        }
//        mavenLocal()
//    }
//}
//
//signing {
//    sign(publishing.publications)
//}