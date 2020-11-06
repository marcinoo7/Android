package pl.pwr.andz1.i00000

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_bmi.*



class Bmi_activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi)
        val message = intent.getStringExtra("bmi")
        stateText.text = message
        if (message != null) {
            showResult(message.toDouble())
        }
    }

    private fun showResult(bmi: Double) {
        when (bmi) {

            in 0.0..16.0 -> {
                stateImage.setImageResource(R.drawable.starvation)
                description.text = getString(R.string.description_starvation1)
            }
            in 16.0..17.0 -> {
                stateImage.setImageResource(R.drawable.starvation2)
                description.text = getString(R.string.description_starvation2)
            }
            in 17.0..18.5 -> {
                stateImage.setImageResource(R.drawable.underweight)
                description.text = getString(R.string.description_underweight)
            }
            in 18.5..25.0 -> {
                stateImage.setImageResource(R.drawable.normal)
                description.text = getString(R.string.description_normal)
            }
            in 25.0..30.0 -> {
                stateImage.setImageResource(R.drawable.overweight)
                description.text = getString(R.string.description_overweight)
            }
            in 30.0..35.0 -> {
                stateImage.setImageResource(R.drawable.obese1)
                description.text = getString(R.string.description_obese1)
            }
            in 35.0..40.0 -> {
                stateImage.setImageResource(R.drawable.obese2)
                description.text = getString(R.string.description_obese2)
            }
            else -> {
                stateImage.setImageResource(R.drawable.obese3)
                description.text = getString(R.string.description_obese3)
            }
        }
    }
}


