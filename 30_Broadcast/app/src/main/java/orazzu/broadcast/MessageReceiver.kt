package orazzu.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MessageReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        Toast.makeText(
            context,
            context.getString(R.string.found_message)
                .format(intent.getStringExtra("orazzu.broadcast.Message")),
            Toast.LENGTH_SHORT
        ).show()
    }
}