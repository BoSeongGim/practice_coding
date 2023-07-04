package com.example.notification_movetoactivity

import android.app.NotificationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class YesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yes)

        val notificationManager : NotificationManager =
            getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        //알람창 닫기
        notificationManager.cancel(1)

    }
}