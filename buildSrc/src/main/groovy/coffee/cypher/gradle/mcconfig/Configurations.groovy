package coffee.cypher.gradle.mcconfig

class Configurations {
    static def configurePom(pom, project) {
        def defaultPom = {
            licenses {
                it.license {
                    it.name = 'The MIT License'
                    url = 'https://opensource.org/licenses/MIT'
                }
            }
            developers {
                it.developer {
                    it.id = 'cypher121'
                    name = 'Cypher121'
                    email = 'ds98s3a@gmail.com'
                }
            }

            if (configurations.hasProperty('provided')) {
                withXml {
                    configurations.provided.allDependencies.each { dep ->
                        if (asNode().dependencies.isEmpty()) {
                            asNode().appendNode('dependencies')
                        }

                        asNode().dependencies[0].appendNode('dependency').with {
                            it.appendNode('groupId', dep.group)
                            it.appendNode('artifactId', dep.name)
                            it.appendNode('version', dep.version)
                            it.appendNode('scope', 'provided')
                        }
                    }
                }
            }
        }

        defaultPom.rehydrate(pom, project, project)()
    }

    static def configureManifest(manifest, project) {
        def defaultManifest = {
            attributes(
                    [
                            "Specification-Title"     : project.name,
                            "Specification-Vendor"    : "Cypher121",
                            "Specification-Version"   : version,
                            "Implementation-Title"    : project.name,
                            "Implementation-Version"  : version,
                            "Implementation-Vendor"   : "Cypher121",
                            "Implementation-Timestamp": new Date().format("yyyy-MM-dd'T'HH:mm:ssZ")
                    ]
            )
        }

        defaultManifest.rehydrate(manifest, project, project)()
    }
}
