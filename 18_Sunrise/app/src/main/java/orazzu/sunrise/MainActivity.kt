package orazzu.sunrise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView


class MainActivity: AppCompatActivity() {
    private lateinit var sun: ImageView
    private lateinit var clock: ImageView
    private lateinit var hourHand: ImageView
    private lateinit var sunRiseAnimation: Animation
    private lateinit var clockTurnAnimation: Animation
    private lateinit var hourHandTurnAnimation: Animation


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sun = findViewById(R.id.sun)
        clock = findViewById(R.id.clock)
        hourHand = findViewById(R.id.hour_hand)
        sunRiseAnimation = AnimationUtils.loadAnimation(this, R.anim.sun_rise)
        clockTurnAnimation = AnimationUtils.loadAnimation(this, R.anim.clock_turn)
        hourHandTurnAnimation = AnimationUtils.loadAnimation(this, R.anim.hour_hand_turn)

        sun.startAnimation(sunRiseAnimation)
        clock.startAnimation(clockTurnAnimation)
        hourHand.startAnimation(hourHandTurnAnimation)
    }
}