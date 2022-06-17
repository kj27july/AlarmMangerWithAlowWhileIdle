package net.alarm.whileidle.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import net.alarm.whileidle.R
import net.alarm.whileidle.scheduler.AlarmUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickSubmitBtn(view: View) {
       AlarmUnit().createAlarm(this)
    }
}