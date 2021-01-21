package com.example.phoneapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Alarm (

    var aid: String? = null,
    var uid: String? = null,

    var start_time: Date?  =  null,
    var end_time: Date? = null,

    var pre_sentence : String? = null,
    var post_sentence : String? = null
):Parcelable