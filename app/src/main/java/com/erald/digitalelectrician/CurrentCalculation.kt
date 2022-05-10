package com.erald.digitalelectrician

class CurrentCalculation {

    companion object {

        var current: Double? = null
        var unitResult: Double? = null
        var convertedVoltage: Double? = null
        var convertedResistance: Double? = null

        fun calculateCurrentFromVoltageAndResistance(voltage: Double, resistance: Double) {
            current = voltage / resistance
        }

        fun calculateCurrentFromPowerAndVoltage(power: Double, voltage: Double) {
            current = power / voltage
        }

        fun voltageConverter(value: Double) {
            convertedVoltage = value
        }

        fun resistanceConverter(value: Double) {
            convertedResistance = value
        }
    }

}