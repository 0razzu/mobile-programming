package orazzu.catelections.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import orazzu.catelections.R


class CatInfoFragment: Fragment() {
    private lateinit var catDescr: TextView
    private lateinit var catPic: ImageView
    private lateinit var catDescriptions: Array<String>


    fun setDescription(buttonIndex: Int) {
        catDescr.text = catDescriptions[buttonIndex]

        when (buttonIndex) {
            0 -> catPic.setImageResource(R.drawable.ryzhik)
            1 -> catPic.setImageResource(R.drawable.barsik)
            2 -> catPic.setImageResource(R.drawable.murzik)
            else -> {
            }
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cat_info, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        catDescr = view.findViewById(R.id.cat_descr)
        catPic = view.findViewById(R.id.cat_pic)
        catDescriptions = resources.getStringArray(R.array.cats)
    }
}