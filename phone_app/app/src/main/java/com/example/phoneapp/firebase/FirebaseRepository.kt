package com.example.phoneapp.firebase

import android.util.Log
import com.example.phoneapp.model.Alarm
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage

class FirebaseRepository {

    val TAG = "FirebaseRepository"
    var db = FirebaseFirestore.getInstance()
    var user = FirebaseAuth.getInstance().currentUser

    companion object{
        val instance = FirebaseRepository()
    }

    fun uploadAlarm( alarm : Alarm){
//        database.reference.child("alarms").push().setValue(alarm)
        db.collection("alarms").add(alarm).addOnSuccessListener { it->
            Log.d(TAG, "DocumentSnapshot written with ID: ${it.id}")
        }.addOnFailureListener { e->
            Log.d(TAG, "Error adding document", e)
        }
//        db.collection("cities").document("LA").set(city)

    }

//    db.collection("cities").document("LA")
//    .set(city)
//    .addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully written!") }
//    .addOnFailureListener { e -> Log.w(TAG, "Error writing document", e) }



}