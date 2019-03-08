import blue.endless.jankson.*
import com.moandjiezana.toml.TomlWriter
import java.io.FilterReader
import java.io.Reader

buildscript {
    repositories {
        jcenter()
    }

    dependencies {
        classpath("com.moandjiezana.toml:toml4j:0.7.2")
        classpath("blue.endless:jankson:1.1.0")
    }
}

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

class JsonToTomlFilter(input: Reader) : FilterReader(
        with(Util) {
            TomlWriter().write(input.asJson().asStandardType()).reader()
        }
)

class FlatteningJsonFilter(input: Reader) : FilterReader(
        with(Util) {
            input.asJson().flatten().toJson(false, true, 0).reader()
        }
)

class Json5ToJsonFilter(input: Reader) : FilterReader(
        with(Util) {
            input.asJson().toJson(false, true, 0).reader()
        }
)

object Util {
    private val jankson: Jankson = Jankson.builder().build()

    fun Reader.asJson() = jankson.load(this.readText())

    fun JsonElement.flatten(): JsonElement = if (this is JsonObject) {
        val newObj = JsonObject()

        this.flatMap { (k, v) ->
            val newValue = v.flatten()

            if (newValue is JsonObject)
                newValue.entries.map { (key, value) ->
                    "$k.$key" to value
                }
            else
                listOf(k to newValue)
        }.forEach { (k, v) ->
            newObj.put(k, v, null)
        }

        newObj
    } else {
        this
    }

    fun JsonElement.asStandardType(): Any? = when (this) {
        is JsonObject -> this.mapValues { (_, v) -> v.asStandardType() }
        is JsonArray -> this.map { it.asStandardType() }
        is JsonPrimitive -> this.value
        is JsonNull -> null

        else -> throw IllegalArgumentException("Unknown JSON element: $this")
    }
}