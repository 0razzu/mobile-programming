package orazzu.catelections

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import orazzu.catelections.fragment.CatInfoFragment


class MainActivity: AppCompatActivity(), OnSelectedButtonListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    override fun onButtonSelected(buttonIndex: Int) {
        val fragmentManager = supportFragmentManager

        val catInfoFragment =
            fragmentManager.findFragmentById(R.id.fragment_cat_info) as CatInfoFragment?
        catInfoFragment?.setDescription(buttonIndex)
    }
}