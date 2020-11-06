package pl.pwr.andz1.i00000

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import pl.pwr.andz1.i00000.databinding.ActivityMainBinding
import pl.pwr.andz1.i00000.BMI.*


class MainActivity : AppCompatActivity() {


    lateinit var binding: ActivityMainBinding
    var europeanScale : Boolean = true
    var bmiHistoryList = ArrayList<BMI_instance>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("bmi_result", bmiTV.text.toString())
        outState.putInt("bmi_color", bmiTV.currentTextColor)

        //TODO oprogramowac zapamietywanie stanu ui (tam gdzie potrzeba)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        bmiTV.text = savedInstanceState.getString("bmi_result")
        bmiTV.setTextColor(savedInstanceState.getInt("bmi_color"))

        //TODO odt. stanu
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        binding.apply {
            return when (item.itemId) {
                R.id.kgCm -> {
                    massTV.text = getString(R.string.mass_kg)
                    heightTV.text = getString(R.string.height_cm)
                    europeanScale = true
                    true
                }
                R.id.lbIn -> {
                    massTV.text = getString(R.string.mass_lb)
                    heightTV.text = getString(R.string.height_in)
                    europeanScale = false
                    true
                }

                R.id.history ->{
                    openHistory()
                    true
                }

                else -> super.onOptionsItemSelected(item)
            }
        }
    }

    fun count(view: View) {
        binding.apply {
            //TODO oprogramowac liczenie bmi i sprawdzanie danych wejsciowych

            if (heightET.text.isBlank()) {
                heightET.error = getString(R.string.height_is_empty)
            }
            if (massET.text.isBlank()) {
                massET.error = getString(R.string.mass_is_empty)
            }
            if (massET.text.isNotBlank() and heightET.text.isNotBlank()) {
                val bmi = BMI.countBMI(massET.text.toString(),heightET.text.toString(),europeanScale)
                bmiTV.text = bmi
                val color = BMI.color(bmi.toDouble())
                bmiTV.setTextColor(resources.getColor(color, resources.newTheme()))
                addNewInstanceBMI()
            }
        }
    }

    private fun addNewInstanceBMI(){
        if(bmiHistoryList.size == 10){
            bmiHistoryList.removeAt(0);
        }
        var system = getString(R.string.kgCm)
        if(!europeanScale) system = getString(R.string.lbIn)
        bmiHistoryList.add(
            BMI_instance(
                "BMI: " + bmiTV.text.toString(),
                "Mass: " + massET.text.toString(),
                "Height: " + heightET.text.toString(),
                "Used system: " + system
            )
        )
    }


    fun openBMI(view: View){
        val intent: Intent = Intent(this, Bmi_activity::class.java)
        intent.putExtra("bmi", bmiTV.text)
        startActivityForResult(intent, 1)
    }

    fun openHistory(){
        val intent: Intent = Intent(this, History_activity::class.java)
        intent.putExtra("history_data", bmiHistoryList)
        startActivityForResult(intent, 1)
    }
}