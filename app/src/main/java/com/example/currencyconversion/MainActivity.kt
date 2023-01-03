 import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.currencyconversion.R

class MainActivity : AppCompatActivity(), OnItemSelectedListener {
    // create array of Strings
    // and store name of countries
    var countries = arrayOf<String?>("EUR", "GBP", "USD", "AED", "CAD", "IRR")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Take the instance of Spinner and
        // apply OnItemSelectedListener on it which
        // tells which item of spinner is clicked
        val spin = findViewById<Spinner>(R.id.spinner)
        spin.onItemSelectedListener = this

        // Create the instance of ArrayAdapter
        // having the list of countries
        val ad = ArrayAdapter(this, android.R.layout.simple_spinner_item, countries)

        // set simple layout resource file
        // for each item of spinner
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Set the ArrayAdapter (ad) data on the
        // Spinner which binds data to spinner
        spin.adapter = ad
    }

    override fun onItemSelected(parent: AdapterView<*>?,
                                view: View, position: Int,
                                id: Long) {
        // make toast of name of course
        // which is selected in spinner
        Toast.makeText(applicationContext,
            countries[position],
            Toast.LENGTH_LONG)
            .show()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {}
}
