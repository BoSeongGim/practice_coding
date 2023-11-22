package com.example.notificationtimepickerdialog

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat

class AlertReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

        var notificationHelper : NotificationHelper = NotificationHelper(context)

        //넘어온 데이터 변숟에 담기(3강에서 추가된 부분)
        var time = intent?.extras?.getString("time")

        //var nb : NotificationCompat.Builder = notificationHelper.getChannelNotification()
        var nb : NotificationCompat.Builder = notificationHelper.getChannelNotification(time)

        //알림 호출
        notificationHelper.getManager().notify(1,nb.build())
    }

}