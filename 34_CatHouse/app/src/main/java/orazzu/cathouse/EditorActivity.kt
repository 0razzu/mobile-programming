package orazzu.cathouse

import android.content.ContentValues
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import orazzu.cathouse.data.HotelContract
import orazzu.cathouse.data.HotelContract.GuestEntry
import orazzu.cathouse.data.HotelDbHelper


class EditorActivity: AppCompatActivity() {
    private lateinit var dbHelper: HotelDbHelper

    private lateinit var nameEditText: EditText
    private lateinit var cityEditText: EditText
    private lateinit var genderSpinner: Spinner
    private lateinit var ageEditText: EditText
    private lateinit var saveButton: Button

    private var gender: Int = HotelContract.GuestEntry.GENDER_UNSET


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
                        getString(R.string.gender_male) -> HotelContract.GuestEntry.GENDER_MALE
                        getString(R.string.gender_female) -> HotelContract.GuestEntry.GENDER_FEMALE
                        getString(R.string.gender_other) -> HotelContract.GuestEntry.GENDER_OTHER
                        else -> HotelContract.GuestEntry.GENDER_UNSET
                    }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                gender = HotelContract.GuestEntry.GENDER_UNSET
            }
        }
    }


    private fun insertGuest() {
        val name = nameEditText.text.toString().trim()
        val city = cityEditText.text.toString().trim()
        val age = ageEditText.text.toString().trim().toInt()
        val db = dbHelper.writableDatabase

        val values = ContentValues()
        values.put(GuestEntry.NAME, name)
        values.put(GuestEntry.CITY, city)
        values.put(GuestEntry.GENDER, gender)
        values.put(GuestEntry.AGE, age)

        val newRowId = db.insert(GuestEntry.TABLE_NAME, null, values)

        if (newRowId == -1L)
            Toast.makeText(this, R.string.registration_error, Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(
                this,
                getString(R.string.registered).format(newRowId),
                Toast.LENGTH_SHORT
            ).show()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editor)

        nameEditText = findViewById(R.id.name_edit_text)
        cityEditText = findViewById(R.id.city_edit_text)
        genderSpinner = findViewById(R.id.gender_spinner)
        ageEditText = findViewById(R.id.age_edit_text)
        saveButton = findViewById(R.id.save_button)

        dbHelper = HotelDbHelper(this)
        configureSpinner()
        saveButton.setOnClickListener {
            insertGuest()
        }
    }
}