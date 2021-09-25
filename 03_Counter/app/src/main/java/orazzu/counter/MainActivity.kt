package orazzu.counter

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity: AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var greetingButton: Button
    private lateinit var crowCounterButton: Button
    private lateinit var catCounterButton: Button
    private var crowCounter: Int = 0
    private var catCounter: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        greetingButton = findViewById(R.id.greetingButton)
        crowCounterButton = findViewById(R.id.crowCounterButton)
        catCounterButton = findViewById(R.id.catCounterButton)

        greetingButton.setOnClickListener {
            textView.text = getString(R.string.hello_kitty)
            it.setBackgroundColor(Color.BLUE)
        }

        crowCounterButton.setOnClickListener {
            textView.text = "Я насчитал ${++crowCounter} ворон"
        }

        catCounterButton.setOnClickListener {
            textView.text = "Я насчитал ${++catCounter} котов"
        }
    }
}