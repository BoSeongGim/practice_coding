package com.example.notificationtimepickerdialog

import android.app.AlarmManager
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TimePicker
import androidx.databinding.DataBindingUtil
import com.example.notificationtimepickerdialog.databinding.ActivityMainBinding
import java.text.DateFormat
import java.util.Calendar

class MainActivity : AppCompatActivity(), TimePickerDialog.OnTimeSetListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //binding 초기화
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //알람 설정
        binding.timeBtn.setOnClickListener {

            var timePicker = TimePickerFragment()
            //시계 호출
            timePicker.show(supportFragmentManager, "Ti")
        }

        //알람 취소
        binding.alarmCancelBtn.setOnClickListener{
            //알람 취소 함수(기본제공아님. 본 코드의 아래에 직접작성)
            cancelAlarm()
        }
    }

    //시간정하면 호출되는 함수
    override fun onTimeSet(p0: TimePicker?, hourOfDay: Int, minute: Int) {

        var c = Calendar.getInstance()

        //시간 설정
        c.set(Calendar.HOUR_OF_DAY, hourOfDay) //시
        c.set(Calendar.MINUTE, minute)         //분
        c.set(Calendar.SECOND, 0)              //초

        //화면에 시간을 출력
        updateTimeText(c)

        //알람 설정
        startAlarm(c)

    }

    private fun updateTimeText(c: Calendar) {
        var curTime = DateFormat.getTimeInstance(DateFormat.SHORT).format(c.time)

        binding.timeText.append("알람 시간 : ")
        binding.timeText.append(curTime)
    }

    private fun startAlarm(c: Calendar) {
        //알람매니저 선언
        var alarmManager : AlarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        var intent = Intent(this, AlertReceiver:: class.java)
        var pendingIntent = PendingIntent.getBroadcast(this, 1, intent, PendingIntent.FLAG_MUTABLE)

        //데이터 담기(3강에서 추가된 부분)
        var curTime = DateFormat.getTimeInstance(DateFormat.SHORT).format(c.time)
        intent.putExtra("time",curTime) //intent에 사용자가 선택한 알람시간을 전달합니다.

        //설정 시간이 현재시간 이후라면 설정
        if(c.before(Calendar.getInstance())) {
            c.add(Calendar.DATE, 1)
        }

        alarmManager.setExact(AlarmManager.RTC_WAKEUP, c.timeInMillis, pendingIntent)
    }

    private fun cancelAlarm(){
        //알람매니저 선언
        var alarmManager : AlarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        var intent = Intent(this, AlertReceiver::class.java)
        var pendingIntent = PendingIntent.getBroadcast(this, 1, intent, PendingIntent.FLAG_MUTABLE)
        
        alarmManager.cancel(pendingIntent)
        binding.timeText.text = "알람 취소"
    }
}