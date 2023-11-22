package com.example.notificationtimepickerdialog

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.ContextWrapper
import android.graphics.Color
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat

class NotificationHelper(base: Context?) : ContextWrapper(base) {

    private val channerID = "channerlID"
    private val channerNm = "channerlNm"  //"NotificationManager"클래스 관련 같다.(createChannel메소드에서 활용된다)

    init{
        //안드로이드 버전이 오레오(또는 그 이상)일 경우 채널을 생성한다.
        //[Q1]채널이 필요한 이유가 있는가? 필요하다면 기본클래스등의로 사전에 제공되어야 하지 않았을까?
        //[Q2]오레오 이전의 안드로이드는 채널이 없어도 되는 이유는?(큰 의미는 없지만 그냥 궁금)
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            //채널을 생성한다.(createChannel()함수는 본 코드(NotificationHelper.kt)의 하단에 작성되어 있다.)
            createChannel()
        }
    }

    //채널 생성
    @RequiresApi(Build.VERSION_CODES.O)
    private fun createChannel(){
        var channel = NotificationChannel(channerID, channerNm, NotificationManager.IMPORTANCE_DEFAULT)

        channel.enableLights(true)
        channel.enableVibration(true)
        channel.lightColor = Color.GREEN
        channel.lockscreenVisibility = Notification.VISIBILITY_PRIVATE

        getManager().createNotificationChannel(channel)
    }

    //NotificationManager 생성
    fun getManager(): NotificationManager{
        return getSystemService(NOTIFICATION_SERVICE) as NotificationManager
    }

    //notification 설정(고정된 텍스트(제목/알람내용입니다)만 출력된다.)
    /*
    fun getChannelNotification():NotificationCompat.Builder{
        return NotificationCompat.Builder(applicationContext, channerID)
            .setContentTitle("제목")
            .setContentText("알람내용입니다.")
            .setSmallIcon(R.drawable.ic_launcher_background)
    }
    */

    //notification 설정(알람시간이 출력된다.)
    //[알람클래스 수정] getChannelNotification()에 파라미터를 만들어준다(데이터를 받을 수 있도록 한다.)
    fun getChannelNotification(time:String?):NotificationCompat.Builder{
        return NotificationCompat.Builder(applicationContext, channerID)
            .setContentTitle(time)
            .setContentText("알람입니다.")
            .setSmallIcon(R.drawable.ic_launcher_background)
    }


}