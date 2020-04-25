package coffee.cypher.gradle.mcconfig

import blue.endless.jankson.*
import java.io.Reader

object JsonUtil {
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