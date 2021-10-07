package orazzu.orientation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.widget.Button
import android.widget.TextView


class MainActivity: AppCompatActivity() {
    private lateinit var catCounterTextView: TextView
    private lateinit var crowCounterTextView: TextView
    private lateinit var catCounterButton: Button
    private lateinit var crowCounterButton: Button
    private var catCounter = 0
    private var crowCounter = 0
    private val KEY_COUNT = "COUNT"


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt(KEY_COUNT, crowCounter)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        catCounterTextView = findViewById(R.id.counter1_textView)
        crowCounterTextView = findViewById(R.id.counter2_textView)
        catCounterButton = findViewById(R.id.button1)
        crowCounterButton = findViewById(R.id.button2)

        catCounterTextView.text = getString(R.string.cats).format(catCounter)
        if (savedInstanceState != null)
            crowCounter = savedInstanceState.getInt(KEY_COUNT, 0)
        crowCounterTextView.text = getString(R.string.crows).format(crowCounter)

        catCounterButton.setOnClickListener {
            catCounterTextView.text = getString(R.string.cats).format(++catCounter)
        }

        crowCounterButton.setOnClickListener {
            crowCounterTextView.text = getString(R.string.crows).format(++crowCounter)
        }
    }
}