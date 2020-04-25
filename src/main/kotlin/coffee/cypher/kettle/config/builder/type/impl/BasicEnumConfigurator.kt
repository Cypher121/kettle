package coffee.cypher.kettle.config.builder.type.impl

import coffee.cypher.kettle.config.builder.type.EnumConfigurator
import com.electronwill.nightconfig.core.EnumGetMethod

internal class BasicEnumConfigurator : EnumConfigurator {
    override var getMethod = EnumGetMethod.NAME_IGNORECASE
        private set

    override fun acceptOrdinals() {
        getMethod = when (getMethod) {
            EnumGetMethod.NAME_IGNORECASE -> EnumGetMethod.ORDINAL_OR_NAME_IGNORECASE
            EnumGetMethod.NAME -> EnumGetMethod.ORDINAL_OR_NAME
            else -> getMethod
        }
    }

    override fun rejectOrdinals() {
        getMethod = when (getMethod) {
            EnumGetMethod.ORDINAL_OR_NAME_IGNORECASE -> EnumGetMethod.NAME_IGNORECASE
            EnumGetMethod.ORDINAL_OR_NAME -> EnumGetMethod.NAME
            else -> getMethod
        }
    }

    override fun ignoreCase() {
        getMethod = when (getMethod) {
            EnumGetMethod.ORDINAL_OR_NAME -> EnumGetMethod.NAME_IGNORECASE
            EnumGetMethod.NAME -> EnumGetMethod.NAME_IGNORECASE
            else -> getMethod
        }
    }

    override fun requireCase() {
        getMethod = when (getMethod) {
            EnumGetMethod.NAME_IGNORECASE -> EnumGetMethod.NAME
            EnumGetMethod.ORDINAL_OR_NAME_IGNORECASE -> EnumGetMethod.ORDINAL_OR_NAME
            else -> getMethod
        }
    }
}
