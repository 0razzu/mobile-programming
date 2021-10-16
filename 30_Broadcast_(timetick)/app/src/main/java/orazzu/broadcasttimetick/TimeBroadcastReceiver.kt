package orazzu.broadcasttimetick

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import java.text.Format
import java.text.SimpleDateFormat
import java.util.*


class TimeBroadcastReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val formatter: Format = SimpleDateFormat(context?.getString(R.string.time_format))
        Toast.makeText(
            context,
            context?.getString(R.string.current_time)?.format(formatter.format(Date())),
            Toast.LENGTH_SHORT
        ).show()
    }
}