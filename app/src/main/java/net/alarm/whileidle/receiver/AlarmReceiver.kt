package net.alarm.whileidle.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class AlarmReceiver : BroadcastReceiver() {
    private val TAG = "CustomAlarm"

    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d(TAG, "onReceive:AlarmReceiver at: ${System.currentTimeMillis()}")
    }
}