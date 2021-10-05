package orazzu.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText


class FirstActivity: AppCompatActivity() {
    private lateinit var toText: EditText
    private lateinit var descriptionText: EditText
    private lateinit var fromText: EditText
    private lateinit var sendButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        toText = findViewById(R.id.to_text)
        descriptionText = findViewById(R.id.description_text)
        fromText = findViewById(R.id.from_text)
        sendButton = findViewById(R.id.send_button)

        sendButton.setOnClickListener {
            val intent = Intent(this@FirstActivity, SecondActivity::class.java)
                .putExtra("username", toText.text.toString())
                .putExtra("gift", descriptionText.text.toString())
                .putExtra("sender", fromText.text.toString())
            startActivity(intent)
        }
    }
}