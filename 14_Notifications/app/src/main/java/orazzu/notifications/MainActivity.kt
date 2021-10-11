package orazzu.notifications

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat


class MainActivity: AppCompatActivity() {
    private lateinit var notificationButton: Button
    private lateinit var notificationButtonButtons: Button
    private lateinit var notificationButtonLongText: Button
    private lateinit var notificationButtonBigPic: Button


    companion object {
        var NOTIFICATION_ID = 0
        const val CAT_CHANNEL_ID = "catChannel"
        const val PARCEL_CHANNEL_ID = "parcelChannel"
    }


    private fun configureNotificationChannel(
        id: String,
        name: String,
        description: String,
        importance: Int
    ) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(id, name, importance)
            channel.description = description
            channel.enableLights(true)
            channel.lightColor =
                if (importance == NotificationManager.IMPORTANCE_HIGH) Color.RED else Color.GREEN
            channel.enableVibration(true)

            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }


    private fun configureNotificationButton() {
        val intent = Intent(this, MainActivity::class.java)
            .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)
        val builder = NotificationCompat.Builder(this, CAT_CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_action_cat)
            .setContentTitle(getString(R.string.reminder))
            .setContentText(getString(R.string.time_to_feed))
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .setLargeIcon(
                BitmapFactory.decodeResource(
                    resources,
                    R.drawable.is_this_an_empty_bowl
                )
            )
            .setDefaults(Notification.DEFAULT_ALL)

        notificationButton.setOnClickListener {
            NotificationManagerCompat.from(this).notify(NOTIFICATION_ID++, builder.build())
        }
    }


    private fun configureNotificationButtonButtons() {
        val intent = Intent(this, SecondActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)
        val builder = NotificationCompat.Builder(this, PARCEL_CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_action_cat)
            .setContentTitle(getString(R.string.parcel))
            .setContentText(getString(R.string.parcel_msg))
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setLargeIcon(
                BitmapFactory.decodeResource(
                    resources,
                    R.drawable.cat_in_the_box
                )
            )
            .setDefaults(Notification.DEFAULT_ALL)
            .addAction(R.drawable.ic_lock_open_24, getString(R.string.open), pendingIntent)
            .addAction(R.drawable.ic_refresh_24, getString(R.string.decline), pendingIntent)
            .addAction(R.drawable.ic_action_cat, getString(R.string.other), pendingIntent)

        notificationButtonButtons.setOnClickListener {
            NotificationManagerCompat.from(this).notify(NOTIFICATION_ID++, builder.build())
        }
    }


    private fun configureNotificationButtonLongText() {
        val intent = Intent(this, MainActivity::class.java)
            .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

        notificationButtonLongText.setOnClickListener {
            val builder = NotificationCompat.Builder(this, CAT_CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_action_cat)
                .setContentTitle(getString(R.string.reminder))
                .setContentText(getString(R.string.time_to_feed))
                .setStyle(
                    NotificationCompat.BigTextStyle().bigText(getString(R.string.time_to_feed_long))
                )
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pendingIntent)
                .setLargeIcon(
                    BitmapFactory.decodeResource(
                        resources,
                        R.drawable.is_this_an_empty_bowl
                    )
                )
                .setDefaults(Notification.DEFAULT_ALL)

            NotificationManagerCompat.from(this@MainActivity)
                .notify(NOTIFICATION_ID++, builder.build())
        }
    }


    private fun configureNotificationButtonBigPic() {
        val intent = Intent(this, MainActivity::class.java)
            .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)
        val builder = NotificationCompat.Builder(this, CAT_CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_action_cat)
            .setContentTitle(getString(R.string.reminder))
            .setContentText(getString(R.string.time_to_feed))
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .setLargeIcon(
                BitmapFactory.decodeResource(
                    resources,
                    R.drawable.is_this_an_empty_bowl
                )
            )
            .setStyle(
                NotificationCompat.BigPictureStyle().bigPicture(
                    BitmapFactory.decodeResource(
                        resources,
                        R.drawable.is_this_an_empty_bowl
                    )
                )
            )
            .setDefaults(Notification.DEFAULT_ALL)

        notificationButtonBigPic.setOnClickListener {
            NotificationManagerCompat.from(this).notify(NOTIFICATION_ID++, builder.build())
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notificationButton = findViewById(R.id.notification_button)
        notificationButtonButtons = findViewById(R.id.notification_button_buttons)
        notificationButtonLongText = findViewById(R.id.notification_button_long_text)
        notificationButtonBigPic = findViewById(R.id.notification_button_big_pic)

        configureNotificationChannel(
            CAT_CHANNEL_ID,
            getString(R.string.important_channel_name),
            getString(R.string.important_channel_descr),
            NotificationManager.IMPORTANCE_HIGH
        )
        configureNotificationChannel(
            PARCEL_CHANNEL_ID,
            getString(R.string.parcel_channel_name),
            getString(R.string.parcel_channel_descr),
            NotificationManager.IMPORTANCE_DEFAULT
        )

        configureNotificationButton()
        configureNotificationButtonButtons()
        configureNotificationButtonLongText()
        configureNotificationButtonBigPic()
    }
}