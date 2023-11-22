package com.example.dday

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.TimeUtils
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import java.time.Month
import java.util.Calendar
import java.util.GregorianCalendar
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton = findViewById<Button>(R.id.startBtn)
        val endButton = findViewById<Button>(R.id.endBtn)

        //var startDate=""
        //var endDate=""

        val calendar_start = Calendar.getInstance()
        val calendar_end = Calendar.getInstance()

        startButton.setOnClickListener {
            val today = GregorianCalendar()
            val year = today.get(Calendar.YEAR)
            val month = today.get(Calendar.MONTH)
            val day = today.get(Calendar.DATE)

            val dlg = DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener{
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                    //startDate  = year.toString() + (month+1).toString() + dayOfMonth.toString()
                    //Log.d("dayOfStart : ", startDate)

                    calendar_start.set(year, month+1, dayOfMonth )
                }
            },year,month,day)
            dlg.show()
        }

        endButton.setOnClickListener {
            val today = GregorianCalendar()
            val year = today.get(Calendar.YEAR)
            val month = today.get(Calendar.MONTH)
            val day = today.get(Calendar.DATE)

            val dlg = DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener{
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                    //endDate = year.toString() + (month+1).toString() + dayOfMonth.toString()
                    //Log.d("dayOfEnd : ",endDate)

                    calendar_end.set(year, month+1, dayOfMonth )

                    val finalDate = TimeUnit.MILLISECONDS.toDays(calendar_end.timeInMillis - calendar_start.timeInMillis)

                    val textArea = findViewById<TextView>(R.id.finalDate)

                    //textArea.setText( (endDate.toInt() - startDate.toInt() + 1).toString() )
                    textArea.setText( finalDate.toString() )
                }
            },year,month,day)
            dlg.show()
        }
    }
}