package com.example.phoneapp.setalarm

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import com.afollestad.date.dayOfMonth
import com.afollestad.date.month
import com.afollestad.date.year
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.datetime.datePicker
import com.afollestad.materialdialogs.datetime.timePicker
import com.example.phoneapp.R
import com.github.thunder413.datetimeutils.DateTimeUtils
import com.google.android.material.dialog.MaterialDialogs
import kotlinx.android.synthetic.main.activity_set_alarm.*
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.*

class SetAlarmActivity : AppCompatActivity() {

    var localDate = LocalDate.now()
    var localStartTime = LocalTime.now()
    var localEndTime = LocalTime.now()



    override fun onCreate(savedInstanceState: Bundle?) {
//        localDate = LocalDate.now()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_alarm)


        //알람 날짜 설정
        alarm_date.setOnClickListener {
            val cal = Calendar.getInstance()
            MaterialDialog(this).show {
                datePicker(currentDate = cal){ dialog, datetime ->
                    localDate = LocalDate.of(datetime.year, datetime.month+1,datetime.dayOfMonth)
                    setButtonDateAndTime()
                }
            }
        }

        //시작 시간 설정
        start_time.setOnClickListener {
            val cal = Calendar.getInstance()
            MaterialDialog(this).show{
                timePicker(currentTime = cal){ dialog, datetime->
                    localStartTime= LocalTime.of(datetime.time.hours,datetime.time.minutes)
                    setButtonDateAndTime()
                }
            }
        }

        //종료 시간 설정
        end_time.setOnClickListener {
            val cal = Calendar.getInstance()
            MaterialDialog(this).show{
                timePicker(currentTime = cal){ dialog, datetime->
                    localEndTime= LocalTime.of(datetime.time.hours,datetime.time.minutes)
                    setButtonDateAndTime()
                }
            }
        }

//        upload_btn.setOnClickListener {
//
//        }



    }

    private fun setButtonDateAndTime() {
        val dateFormat = DateTimeFormatter.ofPattern("yyyy년 M월 dd일")
        val timeFormat = DateTimeFormatter.ofPattern("HH시 mm분")
        alarm_date.text = localDate.format(dateFormat)
        start_time.text = localStartTime.format(timeFormat)
        sample_time.text = start_time.text

    }

}