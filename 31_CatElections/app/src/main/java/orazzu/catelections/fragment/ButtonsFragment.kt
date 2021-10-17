package orazzu.catelections.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import orazzu.catelections.OnSelectedButtonListener
import orazzu.catelections.R


class ButtonsFragment: Fragment(), View.OnClickListener {
    private lateinit var ryzhikButton: Button
    private lateinit var barsikButton: Button
    private lateinit var murzikButton: Button


    private fun idToIndex(id: Int): Int {
        var index = -1

        when (id) {
            R.id.ryzhik_button -> index = 0
            R.id.barsik_button -> index = 1
            R.id.murzik_button -> index = 2
        }

        return index
    }


    override fun onClick(view: View?) {
        if (view != null) {
            val listener = activity as OnSelectedButtonListener?

            listener?.onButtonSelected(idToIndex(view.id))
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_buttons, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ryzhikButton = view.findViewById(R.id.ryzhik_button)
        barsikButton = view.findViewById(R.id.barsik_button)
        murzikButton = view.findViewById(R.id.murzik_button)

        ryzhikButton.setOnClickListener(this)
        barsikButton.setOnClickListener(this)
        murzikButton.setOnClickListener(this)
    }
}