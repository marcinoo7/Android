package pl.pwr.andz1.i00000

import org.junit.Test
import org.junit.Assert.*

import pl.pwr.andz1.i00000.BMI.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class BMIUnitTest {
    @Test
    fun countBMI() {
        assertEquals("20.02",BMI.countBMI("70","187",true))
        assertEquals("1.41",BMI.countBMI("70","187",false))
        assertEquals("22.22",BMI.countBMI("50","150",true))
        assertEquals("37.18",BMI.countBMI("100","164",true))
    }
    @Test
    fun colorBMI(){
        assertEquals(R.color.underweightColor, BMI.color(15.0))
        assertEquals(R.color.goodWeightColor, BMI.color(22.0))
        assertEquals(R.color.obeseWeightColor, BMI.color(40.0))
        assertEquals(R.color.overweightColor, BMI.color(25.0))
    }
}