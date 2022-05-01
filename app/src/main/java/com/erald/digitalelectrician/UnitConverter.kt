package com.erald.digitalelectrician

class UnitConverter {

    companion object {

        fun voltageUnitConverter(editTextVoltage: Float?, selectedItem: String): Float? {
            var valueConverted: Float? = null
            when (selectedItem) {
                "pV" -> {
                    valueConverted = editTextVoltage?.div(1000000000000)
                }
                "nV" -> {
                    valueConverted = editTextVoltage?.div(1000000000)
                }
                "μV" -> {
                    valueConverted = editTextVoltage?.div(1000000)
                }
                "mV" -> {
                    valueConverted = editTextVoltage?.div(1000)
                }
                "V" -> {
                    valueConverted = editTextVoltage?.div(1)
                }
                "kV" -> {
                    valueConverted = editTextVoltage?.times(1000)
                }
                "MV" -> {
                    valueConverted = editTextVoltage?.times(1000000)
                }
                "GV" -> {
                    valueConverted = editTextVoltage?.times(1000000000)
                }
            }
            return valueConverted
        }

    }

}