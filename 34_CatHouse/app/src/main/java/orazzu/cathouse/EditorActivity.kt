package orazzu.cathouse

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity


class EditorActivity: AppCompatActivity() {
    private lateinit var nameEditText: EditText
    private lateinit var cityEditText: EditText
    private lateinit var genderSpinner: Spinner
    private lateinit var ageEditText: EditText
    private var gender: Int = 0


    private fun configureSpinner() {
        val genderSpinnerAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.gender_options, android.R.layout.simple_spinner_item
        )
        genderSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)

        genderSpinner.adapter = genderSpinnerAdapter
        genderSpinner.setSelection(3)
        genderSpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, id: Long) {
                val selection = parent?.getItemAtPosition(pos) as String

                if (!TextUtils.isEmpty(selection))
                    gender = when (selection) {
                        getString(R.string.gender_male) -> 1
                        getString(R.string.gender_female) -> 2
                        getString(R.string.gender_other) -> 3
                        else -> 0
                    }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                gender = 0
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editor)

        nameEditText = findViewById(R.id.name_edit_text)
        cityEditText = findViewById(R.id.city_edit_text)
        genderSpinner = findViewById(R.id.gender_spinner)
        ageEditText = findViewById(R.id.age_edit_text)

        configureSpinner()
    }
}