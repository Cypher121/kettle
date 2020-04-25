package coffee.cypher.gradle.mcconfig

import com.moandjiezana.toml.TomlWriter
import java.io.FilterReader
import java.io.Reader

class JsonToTomlFilter(input: Reader) : FilterReader(
    with(JsonUtil) {
        TomlWriter().write(input.asJson().asStandardType()).reader()
    }
)

class FlatteningJsonFilter(input: Reader) : FilterReader(
    with(JsonUtil) {
        input.asJson().flatten().toJson(false, true, 0).reader()
    }
)

class Json5ToJsonFilter(input: Reader) : FilterReader(
    with(JsonUtil) {
        input.asJson().toJson(false, true, 0).reader()
    }
)