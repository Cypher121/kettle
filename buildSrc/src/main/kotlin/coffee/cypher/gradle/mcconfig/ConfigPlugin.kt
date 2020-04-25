package coffee.cypher.gradle.mcconfig

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.AbstractCopyTask
import org.gradle.kotlin.dsl.getByName

class ConfigPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.extensions.add("configs",
            ConfigurationExtension(target)
        )

        with(target) {
            //enable json conversion
            tasks.getByName<AbstractCopyTask>("processResources") {
                //convert to toml
                filesMatching("**/META-INF/mods.json5") {
                    filter(JsonToTomlFilter::class.java)
                    path = path.replace("\\.json5$".toRegex(), ".toml")
                }

                //flatten lang files
                filesMatching("**/lang/*.json") {
                    filter(FlatteningJsonFilter::class.java)
                    path = path.replace("\\.json5$".toRegex(), ".json")
                }
            }
        }
    }
}