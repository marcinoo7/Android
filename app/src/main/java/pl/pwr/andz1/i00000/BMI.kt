package pl.pwr.andz1.i00000

import android.graphics.Color
import kotlin.math.round
import android.os.Bundle
import androidx.core.graphics.toColor

class BMI {
    companion object {
        val precision = 2

        fun countBMI(mass: String, height: String, europeanScale : Boolean): String {
            return countBMIPriv(mass.toDouble(),height.toDouble(),europeanScale).toString()
        }

        fun color(value : Double):Int {
            val color = when (value) {
                in 0.0..18.49 -> R.color.underweightColor
                in 18.5..24.99 -> R.color.goodWeightColor
                in 25.0..29.99 -> R.color.overweightColor
                else -> R.color.obeseWeightColor
            }
            return color
        }

        private fun countBMIPriv(mass: Double, height: Double, europeanScale: Boolean): Double {
            return when (europeanScale){
                true -> format(mass/height/height*10000,precision)
                false -> format(mass/height/height*703,precision)
            }
        }

        private fun format(number : Double, precision : Int) : Double {
            return round(number * Math.pow(10.0, precision.toDouble())) /
                    Math.pow(10.0, precision.toDouble()
            )
        }


    }
}