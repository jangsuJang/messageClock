package com.example.phoneapp.firebase

import com.example.phoneapp.model.Alarm
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage

class FirebaseRepository {

    val Tag = "FirebaseRepository"
//    var db = FirebaseFirestore.getInstance()
    var database = FirebaseDatabase.getInstance()
    var user = FirebaseAuth.getInstance().currentUser

    companion object{
        val instance = FirebaseRepository()
    }

    fun uploadAlarm( alarm : Alarm){
        database.reference.child("alarms").push().setValue(alarm)
    }



}