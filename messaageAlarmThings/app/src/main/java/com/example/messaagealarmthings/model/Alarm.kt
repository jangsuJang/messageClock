package com.example.messaagealarmthings.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.time.LocalTime


@Parcelize
data class Alarm (

    var aid: String? = null,
    var uid: String? = null,

    var alarm_date: String? = null,
    var start_time: LocalTime?  =  null,
    var end_time: LocalTime? = null,

    var pre_sentence : String? = null,
    var post_sentence : String? = null
): Parcelable
