package orazzu.hellokitty

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity: AppCompatActivity() {
    private lateinit var textEdit: EditText
    private lateinit var imageButton: ImageButton
    private lateinit var textView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textEdit = findViewById(R.id.editTextTextPersonName)
        imageButton = findViewById(R.id.imageButton)
        textView = findViewById(R.id.textView)

        imageButton.setOnClickListener {
            textView.text = "%s %s".format(
                getString(R.string.hello),
                if (textEdit.text.isBlank()) getString(R.string.default_cat_name) else textEdit.text
            )
        }
    }
}