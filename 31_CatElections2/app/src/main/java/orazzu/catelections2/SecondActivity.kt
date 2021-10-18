package orazzu.catelections2

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import orazzu.catelections2.fragment.CatInfoFragment

class SecondActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish()
            return
        }
    }


    override fun onStart() {
        super.onStart()

        val buttonIndex = intent.getIntExtra("buttonIndex", -1)
        if (buttonIndex != -1) {
            val catInfoFragment =
                supportFragmentManager.findFragmentById(R.id.fragment_cat_info) as CatInfoFragment?
            catInfoFragment?.setDescription(buttonIndex)
        }
    }
}