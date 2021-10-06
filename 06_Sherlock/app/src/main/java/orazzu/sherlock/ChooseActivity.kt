package orazzu.sherlock

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioGroup
import orazzu.sherlock.MainActivity.Companion.THIEF


class ChooseActivity: AppCompatActivity() {
    private lateinit var radioGroup: RadioGroup


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose)

        radioGroup = findViewById(R.id.radio)

        radioGroup.setOnCheckedChangeListener { _, optionId ->
            val answerIntent = Intent()

            when (optionId) {
                R.id.radio_crow -> answerIntent.putExtra(THIEF, getString(R.string.radio_crow))
                R.id.radio_dog -> answerIntent.putExtra(THIEF, getString(R.string.radio_dog))
                R.id.radio_cat -> answerIntent.putExtra(THIEF, getString(R.string.radio_cat))
            }

            setResult(RESULT_OK, answerIntent)
            finish()
        }
    }
}