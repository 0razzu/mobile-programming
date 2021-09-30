package orazzu.lights

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat


class MainActivity: AppCompatActivity() {
    private lateinit var rootLayout: ConstraintLayout
    private lateinit var redButton: Button
    private lateinit var yellowButton: Button
    private lateinit var greenButton: Button
    private lateinit var currentColorTextView: TextView


    private fun colorButtonOnClick(stringId: Int, colorId: Int) {
        currentColorTextView.text = getString(stringId)
        rootLayout.setBackgroundColor(ContextCompat.getColor(this, colorId))
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rootLayout = findViewById(R.id.root_layout)
        redButton = findViewById(R.id.red_button)
        yellowButton = findViewById(R.id.yellow_button)
        greenButton = findViewById(R.id.green_button)
        currentColorTextView = findViewById(R.id.current_color_textView)

        redButton.setOnClickListener {
            colorButtonOnClick(R.string.red, R.color.red)
        }

        yellowButton.setOnClickListener {
            colorButtonOnClick(R.string.yellow, R.color.yellow)
        }

        greenButton.setOnClickListener {
            colorButtonOnClick(R.string.green, R.color.green)
        }
    }
}