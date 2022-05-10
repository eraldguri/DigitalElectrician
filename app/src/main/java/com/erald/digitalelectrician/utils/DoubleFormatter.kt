package com.erald.digitalelectrician.utils

import android.annotation.SuppressLint
import androidx.core.util.Preconditions
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*
import kotlin.math.abs
import kotlin.math.pow
import kotlin.properties.Delegates

class DoubleFormatter(private var maxInteger_: Int, private var maxFraction_: Int) {
    private val EXP_DOWN = 1e-3
    private var EXP_UP by Delegates.notNull<Double>()
    private var nfBelow_: NumberFormat? = null
    private var nfNormal_: NumberFormat? = null
    private var nfAbove_: NumberFormat? = null

    enum class NumberFormatType { Below, Normal, Above }

    @SuppressLint("RestrictedApi")
    private fun setPrecision(maxInteger: Int, maxFraction: Int) {
        Preconditions.checkArgument(maxFraction >= 0)
        Preconditions.checkArgument(maxInteger in 1..16)

        if (maxFraction == maxFraction_ && maxInteger == maxInteger_) {
            return
        }

        maxFraction_ = maxFraction
        maxInteger_ = maxInteger
        EXP_UP = 10.0.pow(maxInteger.toDouble())
        nfBelow_ = createNumberFormat(NumberFormatType.Below)
    }

    private fun createNumberFormat(type: NumberFormatType): NumberFormat? {
        val sharpByPrecision = createSharp(maxFraction_)
        val numberFormat = NumberFormat.getInstance(Locale.US)

        // Apply bankers' rounding:  this is the rounding mode that
        // statistically minimizes cumulative error when applied
        // repeatedly over a sequence of calculations
        numberFormat.roundingMode = RoundingMode.HALF_EVEN

        if (numberFormat is DecimalFormat) {
            val decimalFormat = numberFormat as DecimalFormat
            val decimalFormatSymbols = decimalFormat.decimalFormatSymbols

            // Set Exponent symbol to minus 'e' instead of 'E'
            if (type == NumberFormatType.Above) {
                decimalFormatSymbols.exponentSeparator = "e+"
            } else {
                decimalFormatSymbols.exponentSeparator = "e"
            }

            decimalFormat.decimalFormatSymbols = decimalFormatSymbols

            // Use exponent format if v is outside of [EXP_DOWN,EXP_UP]
            if (type == NumberFormatType.Normal) {
                if (maxFraction_ == 0) {
                    decimalFormat.applyPattern("#,##0")
                } else {
                    decimalFormat.applyPattern("#,##0.$sharpByPrecision")
                }
            } else {
                if (maxFraction_ == 0) {
                    decimalFormat.applyPattern("0E0")
                } else {
                    decimalFormat.applyPattern("0." + sharpByPrecision + "E0")
                }
            }
        }
        return numberFormat
    }

    fun format(value: Double): String {
        if (value.isNaN()) {
            return "-";
        }
        if (value.equals(0)) {
            return "0";
        }

        val absoluteValue = abs(value)
        if (absoluteValue < EXP_DOWN) {
            return nfBelow_!!.format(value)
        }
        if (absoluteValue > EXP_UP) {
            return nfAbove_!!.format(value)
        }

        return nfNormal_!!.format(value)
    }

    fun formatHtml(value: Double): String {
        if (value.isNaN()) {
            return "-"
        }
        return htmlize(format(value))
    }

    /**
     * This is the base alogrithm: create a instance of NumberFormat for the value, then format it. It should
     * not be used to format a great numbers of value
     *
     * We will never use this methode, it is here only to understanding the Algo principal:
     *
     * format v to string. precision_ is numbers of digits after decimal.
     * if EXP_DOWN <= abs(v) <= EXP_UP, display the normal format: 124.45678
     * otherwise display scientist format with: 1.2345e+30
     *
     * pre-condition: precision >= 1
     */
    fun formatInefficient(value: Double): String {
        val sharpByPrecision = createSharp(maxFraction_)
        val absoluteValue = abs(value)
        val numberFormat = NumberFormat.getInstance(Locale.US)

        // Apply bankers' rounding:  this is the rounding mode that
        // statistically minimizes cumulative error when applied
        // repeatedly over a sequence of calculations
        numberFormat.roundingMode = RoundingMode.HALF_EVEN
        if (numberFormat is DecimalFormat) {
            val decimalFormat = numberFormat as DecimalFormat
            val decimalFormatSymbols = decimalFormat.decimalFormatSymbols

            // Set group separator to space instead of comma
            decimalFormatSymbols.groupingSeparator = ' '

            // Set Exponent symbol to minus 'e' instead of 'E'
            if (absoluteValue > EXP_UP) {
                decimalFormatSymbols.exponentSeparator = "e+"
            } else {
                decimalFormatSymbols.exponentSeparator = "e"
            }
            decimalFormat.decimalFormatSymbols = decimalFormatSymbols

            //use exponent format if v is out side of [EXP_DOWN,EXP_UP]
            if (absoluteValue < EXP_DOWN && absoluteValue > EXP_UP) {
                decimalFormat.applyPattern("0." + sharpByPrecision + "E0")
            } else {
                decimalFormat.applyPattern("#,##0.$sharpByPrecision")
            }
        }
        return numberFormat.format(value)
    }

    /**
     * Convert "3.1416e+12" to "<b>3</b>.1416e<b>+12</b>"
     * It is a html format of a number which highlight the integer and exponent part
     */
    private fun htmlize(_string: String): String {
        val stringBuilder = StringBuilder("<b>")
        var p1 = _string.indexOf('.')

        if (p1 > 0) {
            stringBuilder.append(_string.substring(0, p1))
            stringBuilder.append("<b>")
        } else {
            p1 = 0
        }

        val p2 = _string.lastIndexOf('e')
        if (p2 > 0) {
            stringBuilder.append(_string.substring(p1, p2))
            stringBuilder.append("<b>")
            stringBuilder.append(_string.substring(p2, _string.length))
            stringBuilder.append("</b>")
        } else {
            stringBuilder.append(_string.substring(p1, _string.length))
            if (p1 == 0) {
                stringBuilder.append("</b>")
            }
        }

        return stringBuilder.toString()
    }

    private fun createSharp(n: Int): String {
        val sb: StringBuilder = StringBuilder()
        for (i in 0 until n) {
            sb.append('#')
        }
        return sb.toString()
    }
}