package orazzu.cathouse.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import orazzu.cathouse.data.HotelContract.GuestEntry


class HotelDbHelper(context: Context?):
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        private val LOG_TAG = HotelDbHelper::class.java.simpleName
        private const val DATABASE_NAME = "hotel.db"
        private const val DATABASE_VERSION = 1
    }


    override fun onCreate(db: SQLiteDatabase) {
        val createGuests = ("CREATE TABLE " + GuestEntry.TABLE_NAME + " ("
                + GuestEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + GuestEntry.NAME + " TEXT NOT NULL, "
                + GuestEntry.CITY + " TEXT NOT NULL, "
                + GuestEntry.GENDER + " INTEGER NOT NULL DEFAULT " + GuestEntry.GENDER_UNSET + ", "
                + GuestEntry.AGE + " INTEGER NOT NULL DEFAULT 0);")

        db.execSQL(createGuests)
    }


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        Log.i("SQLite", "Upgrading $GuestEntry.TABLE_NAME from v$oldVersion to v$newVersion")

        if (db != null) {
            db.execSQL("DROP TABLE IF IT EXISTS $GuestEntry.TABLE_NAME")
            onCreate(db)
        } else
            Log.e(
                "SQLite",
                "Failed to upgrade $GuestEntry.TABLE_NAME from v$oldVersion to v$newVersion"
            )
    }
}