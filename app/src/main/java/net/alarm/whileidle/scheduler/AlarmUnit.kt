package net.alarm.whileidle.scheduler

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import net.alarm.whileidle.receiver.AlarmReceiver
import java.util.concurrent.TimeUnit

class AlarmUnit {
    private val TAG = "CustomAlarm"

    fun createAlarm(context: Context) {
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intentArray = arrayListOf<PendingIntent>()
        var flag = PendingIntent.FLAG_UPDATE_CURRENT
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            flag = PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        var i = 1
        while (i < 6) {
            val intent = Intent(context, AlarmReceiver()::class.java)
            val pendingIntent = PendingIntent.getBroadcast(context, i, intent, flag)
            val time = System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(i.toLong() * 5)
            Log.d(TAG, "createAlarm:${time} ")
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                alarmManager.setExactAndAllowWhileIdle(
                    AlarmManager.RTC_WAKEUP, time, pendingIntent
                )
            } else alarmManager.setExact(AlarmManager.RTC_WAKEUP, time, pendingIntent)
            intentArray.add(pendingIntent)
            i++
        }
    }
}