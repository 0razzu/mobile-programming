package orazzu.themesandstyles

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog


class MainActivity: AppCompatActivity() {
    private lateinit var aboutButton: Button
    private lateinit var alertDialogButton: Button
    private lateinit var firstActivityButton: Button
    private lateinit var secondActivityButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        aboutButton = findViewById(R.id.about_button)
        alertDialogButton = findViewById(R.id.alert_dialog_button)
        firstActivityButton = findViewById(R.id.first_activity_button)
        secondActivityButton = findViewById(R.id.second_activity_button)

        aboutButton.setOnClickListener {
            startActivity(Intent(this@MainActivity, AboutActivity::class.java))
        }
        alertDialogButton.setOnClickListener {
            val alertDialog = AlertDialog.Builder(this@MainActivity, R.style.AlertDialogCustom)
                .setTitle(R.string.feed_cat)
                .setPositiveButton(R.string.yes) { _: DialogInterface, _: Int -> }
                .setNegativeButton(R.string.no) { _: DialogInterface, _: Int -> }
                .create()
            alertDialog.show()
        }
        firstActivityButton.setOnClickListener {
            startActivity(Intent(this@MainActivity, FirstActivity::class.java))
        }
        secondActivityButton.setOnClickListener {
            startActivity(Intent(this@MainActivity, SecondActivity::class.java))
        }
    }
}