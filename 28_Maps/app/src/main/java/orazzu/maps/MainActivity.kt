package orazzu.maps

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class MainActivity: AppCompatActivity() {
    private lateinit var enterLocationEditText: EditText
    private lateinit var openMapsButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        enterLocationEditText = findViewById(R.id.enter_location_edit_text)
        openMapsButton = findViewById(R.id.open_maps_button)

        openMapsButton.setOnClickListener {
            val geoUriString = "geo:0,0?q=" + enterLocationEditText.text
            val mapIntent = Intent(Intent.ACTION_VIEW, Uri.parse(geoUriString))
            try {
                startActivity(mapIntent)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(this, getString(R.string.open_maps_error), Toast.LENGTH_SHORT).show()
            }
        }
    }
}