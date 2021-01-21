package se.ntig.treecardon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val languages = resources.getStringArray(R.array.Languages)

        val spinner = findViewById<Spinner>(R.id.spinner1)
        if (spinner != null) {
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, languages)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                    AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                    Toast.makeText(this@MainActivity, getString(R.string.selected_item) + " " + " " + languages[position], Toast.LENGTH_SHORT).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {

                }

            }
        }
    }

    fun calculate(view: View) {
        var tree = editTextTree.text.toString()
        var circumference = editTextCircumference.text.toString().toInt()
        var diameter = (circumference / 3.14) / 100
        var height = editTextHeight.text.toString().toInt()
        var VS = 0.0

        when (tree) {
            "Ek", "ek" -> {
                var temp1 = (0.03522 * (diameter * diameter)) * height
                var temp2 = 0.08772 * diameter * height
                var temp3 = 0.04905 * (diameter * diameter)
                VS = ((temp1 + temp2) - temp3)
            }
            "Bok", "bok" -> {

            }
            "Ask", "ask" -> {

            }
        }

        editTextResult.setText(VS.toString())

    }

}