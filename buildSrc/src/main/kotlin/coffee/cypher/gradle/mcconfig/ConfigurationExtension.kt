package coffee.cypher.gradle.mcconfig

import org.gradle.api.Project
import org.gradle.api.java.archives.Manifest
import org.gradle.api.publish.maven.MavenPom

class ConfigurationExtension(val project: Project) {
    fun apply(pom: MavenPom) {
        Configurations.configurePom(pom, project)
    }

    fun apply(manifest: Manifest) {
        Configurations.configureManifest(manifest, project)
    }
}