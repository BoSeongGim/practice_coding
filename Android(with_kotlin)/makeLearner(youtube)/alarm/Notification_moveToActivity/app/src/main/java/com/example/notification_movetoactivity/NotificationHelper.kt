package com.example.notification_movetoactivity

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat

class NotificationHelper(base: Context?) : ContextWrapper(base) {

    //채널 변수 만들기
    private val channerID:String = "channerlID"
    private val channerNm:String = "channerlName"  //"NotificationManager"클래스 관련 같다.(createChannel메소드에서 활용된다)
    private val context:Context? = base

    init{
        //안드로이드 버전이 오레오(또는 그 이상)일 경우 채널을 생성한다.
        //[Q1]채널이 필요한 이유가 있는가? 필요하다면 기본클래스등의로 사전에 제공되어야 하지 않았을까?
        //[Q2]오레오 이전의 안드로이드는 채널이 없어도 되는 이유는?(큰 의미는 없지만 그냥 궁금)
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            //채널을 생성한다.(createChannel()함수는 본 코드(NotificationHelper.kt)의 하단에 작성되어 있다.)
            createChannel()
        }
    }

    //채널 생성 함수
    @RequiresApi(Build.VERSION_CODES.O)
    private fun createChannel(){

        //객체 생성
        var channel:NotificationChannel
            = NotificationChannel(channerID, channerNm, NotificationManager.IMPORTANCE_DEFAULT)

        //설정
        channel.enableLights(true)       //빛
        channel.enableVibration(true)  //진동
        channel.lightColor = Color.RED
        channel.lockscreenVisibility = Notification.VISIBILITY_PRIVATE

        //생성
        getManager().createNotificationChannel(channel)
    }

    //NotificationManager 생성
    fun getManager(): NotificationManager{
        return getSystemService(NOTIFICATION_SERVICE) as NotificationManager
    }

    //notification 설정
    fun getChannelNotification(title:String, message:String):NotificationCompat.Builder{

        //액션에 들어갈 액티비티 설정
        //MainActivity 설정
        val mainIntent : Intent = Intent(context, MainActivity::class.java)
        mainIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

        val mainPendingIntent : PendingIntent =
            PendingIntent.getActivity(
                context,
                0,
                mainIntent,
                PendingIntent.FLAG_ONE_SHOT or PendingIntent.FLAG_MUTABLE
            )

        //YesActivity 설정
        val yesIntent : Intent = Intent(context, YesActivity::class.java)
        yesIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

        val yesPendingIntent : PendingIntent =
            PendingIntent.getActivity(
                context,
                0,
                yesIntent,
//                PendingIntent.FLAG_ONE_SHOT or PendingIntent.FLAG_IMMUTABLE
                        PendingIntent.FLAG_ONE_SHOT or PendingIntent.FLAG_MUTABLE
            )

        //NoActivity 설정
        val noIntent : Intent = Intent(context, NoActivity::class.java)
        noIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

        val noPendingIntent : PendingIntent =
            PendingIntent.getActivity(
                context,
                0,
                noIntent,
//                PendingIntent.FLAG_ONE_SHOT or PendingIntent.FLAG_IMMUTABLE
                        PendingIntent.FLAG_ONE_SHOT or PendingIntent.FLAG_MUTABLE
            )

        return NotificationCompat.Builder(applicationContext, channerID)
            .setContentTitle(title) //제목
            .setContentText(message) //알람내용
            .setSmallIcon(R.drawable.ic_launcher_background) //아이콘
            .setContentIntent(mainPendingIntent) //기본설정
            .addAction(R.drawable.ic_launcher_background, "Yes", yesPendingIntent)
            .addAction(R.drawable.ic_launcher_background, "No", noPendingIntent)
    }

}