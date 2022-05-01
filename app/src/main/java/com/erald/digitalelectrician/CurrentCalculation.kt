package com.erald.digitalelectrician

class CurrentCalculation {

    companion object {

        var current: Float? = null
        var unitResult: Float? = null
        var conv: Float? = null

        fun calculateCurrentFromVoltageAndResistance(voltage: Float, resistance: Float) {
            current = voltage / resistance
        }

        fun calculateCurrentFromPowerAndVoltage(power: Float, voltage: Float) {
            current = power / voltage
        }

        fun voltageConverter(value: Float) {
            conv = value
        }
    }

}