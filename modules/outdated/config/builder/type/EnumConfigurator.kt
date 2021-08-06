package coffee.cypher.kettle.config.builder.type

import com.electronwill.nightconfig.core.EnumGetMethod

interface EnumConfigurator {
    val getMethod: EnumGetMethod
    fun acceptOrdinals()
    fun rejectOrdinals()
    fun ignoreCase()
    fun requireCase()
}