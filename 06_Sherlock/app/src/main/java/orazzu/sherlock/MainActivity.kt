package orazzu.sherlock

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts


class MainActivity: AppCompatActivity() {
    private lateinit var answerTextView: TextView
    private lateinit var chooseButton: Button
    private val startForResult: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result?.data
                val answer: String? = data?.getStringExtra(THIEF)
                answerTextView.text = answer.toString()
            }

            else {
                answerTextView.text = ""
            }
        }


    companion object {
        const val THIEF = "orazzu.sherlock.THIEF"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        answerTextView = findViewById(R.id.answer_textView)
        chooseButton = findViewById(R.id.choose_button)

        chooseButton.setOnClickListener {
            val questionIntent = Intent(this@MainActivity, ChooseActivity::class.java)

            startForResult.launch(questionIntent)
        }
    }
}