package orazzu.cathouse.data

import android.provider.BaseColumns


class HotelContract {
    object GuestEntry: BaseColumns {
        const val TABLE_NAME = "guests"

        const val _ID = BaseColumns._ID
        const val NAME = "name"
        const val CITY = "city"
        const val GENDER = "gender"
        const val AGE = "age"

        const val GENDER_MALE = 1
        const val GENDER_FEMALE = 2
        const val GENDER_OTHER = 3
        const val GENDER_UNSET = 0
    }
}