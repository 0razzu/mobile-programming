package orazzu.catelections2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import orazzu.catelections2.fragment.CatInfoFragment


class MainActivity: AppCompatActivity(), OnSelectedButtonListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    override fun onButtonSelected(buttonIndex: Int) {
        val catInfoFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_cat_info) as CatInfoFragment?

        if (catInfoFragment != null && catInfoFragment.isVisible)
            catInfoFragment.setDescription(buttonIndex)
        else {
            val intent = Intent(this, SecondActivity::class.java)
                .putExtra("buttonIndex", buttonIndex)
            startActivity(intent)
        }
    }
}