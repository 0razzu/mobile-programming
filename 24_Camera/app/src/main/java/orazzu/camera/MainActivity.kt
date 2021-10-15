package orazzu.camera

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import java.io.File
import java.time.Instant


class MainActivity: AppCompatActivity() {
    private lateinit var takePhotoButton: Button
    private lateinit var photoView: ImageView
    private lateinit var outputFileUri: Uri
    private val takePhotoLauncher: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val photoBitmap = result.data?.getParcelableExtra<Bitmap>("data")
                if (photoBitmap != null)
                    photoView.setImageBitmap(photoBitmap)
                else {
                    photoView.setImageURI(outputFileUri)
                    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O)
                        photoView.rotation = 90F
                }
            } else {
                Toast.makeText(
                    this@MainActivity,
                    getString(R.string.take_photo_error),
                    Toast.LENGTH_SHORT
                ).show()
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
                    getExternalFilesDir(Environment.DIRECTORY_DCIM),
                    (if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                        Instant.now().toString() else "test") + ".jpg"
                )
            )

            try {
                val takePhotoIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                    .putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri)
                takePhotoLauncher.launch(takePhotoIntent)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(
                    this@MainActivity,
                    getString(R.string.take_photo_error),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}