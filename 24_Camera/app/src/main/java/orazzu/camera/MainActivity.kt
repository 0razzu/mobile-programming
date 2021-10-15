package orazzu.camera

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat.startActivityForResult

import android.os.Environment
import androidx.core.content.FileProvider
import java.io.File


class MainActivity: AppCompatActivity() {
    private lateinit var takePhotoButton: Button
    private lateinit var photoView: ImageView
    private lateinit var outputFileUri: Uri
    private val startForResult: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val photoBitmap = result.data?.getParcelableExtra<Bitmap>("data")
                if (photoBitmap != null)
                    photoView.setImageBitmap(photoBitmap)
                else
                    photoView.setImageURI(outputFileUri)
            } else {
                Toast.makeText(this@MainActivity, "Wrong result code", Toast.LENGTH_SHORT).show()
            }
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        takePhotoButton = findViewById(R.id.take_photo_button)
        photoView = findViewById(R.id.photo_view)

        takePhotoButton.setOnClickListener {
            outputFileUri = FileProvider.getUriForFile(
                this@MainActivity, "orazzu.camera.provider", File(
                    externalCacheDir,
                    "test.jpg"
                )
            )
            val takePhotoIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                .putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri)
            startForResult.launch(takePhotoIntent)
        }
    }
}