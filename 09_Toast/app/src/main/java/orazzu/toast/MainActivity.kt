package orazzu.toast

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi


class MainActivity: AppCompatActivity() {
    private lateinit var imageView: ImageView
    private lateinit var toastButton: Button


    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.imageView)
        toastButton = findViewById(R.id.toast_button)

        imageView.imageAlpha = 0

        toastButton.setOnClickListener {
            val toast = Toast.makeText(
                applicationContext,
                getString(R.string.feed_cat_notification),
                Toast.LENGTH_SHORT
            )
            toast.addCallback(
                object: Toast.Callback() {
                    override fun onToastHidden() {
                        imageView.imageAlpha = 255
                    }
                })

            toast.show()
        }
    }
}