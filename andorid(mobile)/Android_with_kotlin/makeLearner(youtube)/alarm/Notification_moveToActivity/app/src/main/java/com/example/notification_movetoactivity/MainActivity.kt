package com.example.notification_movetoactivity

import android.app.NotificationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.Button
import android.widget.EditText
import androidx.core.app.NotificationCompat

class MainActivity : AppCompatActivity() {

    //Notification 객체 생성
    private lateinit var notificationHelper: NotificationHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val notificationManager : NotificationManager =
            getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        //알람창 닫기
        notificationManager.cancel(1)


        //객체 생성
        val titleEdit: EditText = findViewById(R.id.title_edit)
        val messageEdit: EditText = findViewById(R.id.message_edit)
        val notiBtn: Button = findViewById(R.id.noti_btn)

        //Notification 초기화
        notificationHelper = NotificationHelper(this)

        //알림 버튼 이벤트
        notiBtn.setOnClickListener {
            val title:String = titleEdit.text.toString()
            val message:String = messageEdit.text.toString()

            //알림 호출
            showNotification(title, message)
        }
        /*
        val notificationManager : NotificationManager =
            getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        //알람창 닫기
        notificationManager.cancel(1)
        */
    }

    //알림 호출
    private fun showNotification(title:String, message: String){
        val nb:NotificationCompat.Builder =
            notificationHelper.getChannelNotification(title,message)

        notificationHelper.getManager().notify(1,nb.build())
    }
}