package pl.pwr.andz1.i00000

import java.io.Serializable

class BMI_instance (
    val bmi_value: String,
    val height: String,
    val mass: String,
    val system: String
):Serializable
{
    override fun toString(): String {
        return "BmiData(bmi='$bmi_value', mass='$mass', height='$height', date='$system')"
    }
}