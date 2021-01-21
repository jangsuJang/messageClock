package com.example.phoneapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Alarm (

    var aid: String? = null,
    var start_time: String?  =  null,
    var end_time: String? = null,

    var pre_sentence : String? = null,
    var post_sentence : String? = null
):Parcelable