package orazzu.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class SecondActivity: AppCompatActivity() {
    private lateinit var infoTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        infoTextView = findViewById(R.id.info_textView)

        var username = intent.getStringExtra("username")
        var gift = intent.getStringExtra("gift")
        var sender = intent.getStringExtra("sender")

        if (username.isNullOrBlank())
            username = getString(R.string.to_default)
        if (gift.isNullOrBlank())
            gift = getString(R.string.description_default)
        if (sender.isNullOrBlank())
            sender = getString(R.string.from_default)

        infoTextView.text = getString(R.string.info_textView_text).format(username, gift, sender)
    }
}