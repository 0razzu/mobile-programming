package orazzu.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity: AppCompatActivity() {
    private lateinit var aboutButton: Button
    private lateinit var firstActivityButton: Button
    private lateinit var secondActivityButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        aboutButton = findViewById(R.id.about_button)
        firstActivityButton = findViewById(R.id.first_activity_button)
        secondActivityButton = findViewById(R.id.second_activity_button)

        aboutButton.setOnClickListener {
            startActivity(Intent(this@MainActivity, AboutActivity::class.java))
        }
        firstActivityButton.setOnClickListener {
            startActivity(Intent(this@MainActivity, FirstActivity::class.java))
        }
        secondActivityButton.setOnClickListener {
            startActivity(Intent(this@MainActivity, SecondActivity::class.java))
        }
    }
}