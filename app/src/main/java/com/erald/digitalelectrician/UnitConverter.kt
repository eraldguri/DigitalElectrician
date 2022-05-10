package com.erald.digitalelectrician

class UnitConverter {

    companion object {

        fun voltageUnitConverter(editTextVoltage: Double?, selectedItem: String): Double? {
            var valueConverted: Double? = null
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

        fun currentUnitConverter(editTextVoltage: Double?, selectedItem: String): Double? {
            var valueConverted: Double? = null
            when (selectedItem) {
                "pA" -> {
                    valueConverted = editTextVoltage?.div(1000000000000)
                }
                "nA" -> {
                    valueConverted = editTextVoltage?.div(1000000000)
                }
                "μA" -> {
                    valueConverted = editTextVoltage?.div(1000000)
                }
                "mA" -> {
                    valueConverted = editTextVoltage?.div(1000)
                }
                "A" -> {
                    valueConverted = editTextVoltage?.div(1)
                }
                "kA" -> {
                    valueConverted = editTextVoltage?.times(1000)
                }
                "MA" -> {
                    valueConverted = editTextVoltage?.times(1000000)
                }
                "GA" -> {
                    valueConverted = editTextVoltage?.times(1000000000)
                }
            }
            return valueConverted
        }

        fun resistanceUnitConverter(editTextVoltage: Double?, selectedItem: String): Double? {
            var valueConverted: Double? = null
            when (selectedItem) {
                "pΩ" -> {
                    valueConverted = editTextVoltage?.div(1000000000000)
                }
                "nΩ" -> {
                    valueConverted = editTextVoltage?.div(1000000000)
                }
                "μΩ" -> {
                    valueConverted = editTextVoltage?.div(1000000)
                }
                "mΩ" -> {
                    valueConverted = editTextVoltage?.div(1000)
                }
                "Ω" -> {
                    valueConverted = editTextVoltage?.div(1)
                }
                "kΩ" -> {
                    valueConverted = editTextVoltage?.times(1000)
                }
                "MΩ" -> {
                    valueConverted = editTextVoltage?.times(1000000)
                }
                "GΩ" -> {
                    valueConverted = editTextVoltage?.times(1000000000)
                }
            }
            return valueConverted
        }

    }

}