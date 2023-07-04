package com.example.notification_movetoactivity

import android.app.NotificationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class NoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_no)

        val notificationManager: NotificationManager =
            getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        //알림창 닫기
        notificationManager.cancel(1)
    }
}