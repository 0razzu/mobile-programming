package orazzu.broadcasttimetick

import android.content.IntentFilter
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity: AppCompatActivity() {
    private val timeBroadcastReceiver = TimeBroadcastReceiver()
    private lateinit var registerButton: Button
    private lateinit var unregisterButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerButton = findViewById(R.id.register_button)
        unregisterButton = findViewById(R.id.unregister_button)

        registerButton.setOnClickListener {
            registerReceiver(timeBroadcastReceiver, IntentFilter("android.intent.action.TIME_TICK"))
            Toast.makeText(this@MainActivity, R.string.registered, Toast.LENGTH_SHORT).show()
        }

        unregisterButton.setOnClickListener {
            unregisterReceiver(timeBroadcastReceiver)
            Toast.makeText(this@MainActivity, R.string.unregistered, Toast.LENGTH_SHORT).show()
        }
    }
}