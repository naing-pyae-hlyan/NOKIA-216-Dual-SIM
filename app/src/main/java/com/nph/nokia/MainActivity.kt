package com.nph.nokia

import android.content.Intent
import android.os.BatteryManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.keypad_layout.*
import kotlinx.android.synthetic.main.screen_layout.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    val one: String = "1"
    val two: String = "2"
    val three: String = "3"
    val four: String = "4"
    val five: String = "5"
    val six: String = "6"
    val seven: String = "7"
    val eight: String = "8"
    val nine: String = "9"
    val zero: String = "0"
    val star: String = "*"
    val hash: String = "#"
    lateinit var clearPhone: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        batteryPercentage()
        currentDataTime()
        keypadClickListener()
    }

    fun keypadClickListener() {
        btn_one.setOnClickListener { v -> txt_ph_no.append(one) }
        btn_two.setOnClickListener { v -> txt_ph_no.append(two) }
        btn_three.setOnClickListener { v -> txt_ph_no.append(three) }
        btn_four.setOnClickListener { v -> txt_ph_no.append(four) }
        btn_five.setOnClickListener { v -> txt_ph_no.append(five) }
        btn_six.setOnClickListener { v -> txt_ph_no.append(six) }
        btn_seven.setOnClickListener { v -> txt_ph_no.append(seven) }
        btn_eight.setOnClickListener { v -> txt_ph_no.append(eight) }
        btn_nine.setOnClickListener { v -> txt_ph_no.append(nine) }
        btn_zero.setOnClickListener { v -> txt_ph_no.append(zero) }


        btn_reject.setOnClickListener { v ->
            val ph = txt_ph_no.text.toString()
            if (!ph.equals("")) {
                clearPhone = ph.substring(0, ph.length - 1)

                txt_ph_no.text = clearPhone
            }
        }
    }

    fun batteryPercentage() {
        val batteryStatus: Intent? = android.content.IntentFilter(Intent.ACTION_BATTERY_CHANGED)
            .let { ifilter ->
                this.registerReceiver(null, ifilter)
            }
        val batteryPct: Float? = batteryStatus?.let { intent ->
            val level: Int = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
            val scale: Int = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
            level * 100 / scale.toFloat()
        }
        txt_battery_percent.text = batteryPct!!.toInt().toString() + "%"
    }

    fun currentDataTime() {
        val calendar = Calendar.getInstance()
        val am_pm = calendar.get(Calendar.AM_PM)

        val currentDate = SimpleDateFormat("MMMM, dd", Locale.getDefault()).format(Date())
        val currentTime = SimpleDateFormat("hh:mm", Locale.getDefault()).format(Date())

        txt_date.text = currentDate

        if (am_pm == Calendar.AM)
            txt_time.text = "$currentTime AM"
        else
            txt_time.text = "$currentTime PM"
    }
    //String currentTime = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());

}
