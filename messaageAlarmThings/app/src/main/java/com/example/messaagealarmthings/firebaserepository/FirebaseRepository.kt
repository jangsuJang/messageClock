package com.example.messaagealarmthings.firebaserepository

import android.util.Log
import com.example.messaagealarmthings.model.Alarm
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class FirebaseRepository {

    val Tag = "FirebaseRepository"
    //    var db = FirebaseFirestore.getInstance()
    var database = FirebaseDatabase.getInstance()
    var user = FirebaseAuth.getInstance().currentUser

    var auth = FirebaseAuth.getInstance()

    companion object{
        val instance = FirebaseRepository()
    }

    fun uploadAlarm( alarm : Alarm){
        database.reference.child("alarms").push().setValue(alarm)
    }

    fun signin(email:String?, password:String?):Boolean{
        var isSuccess =false
        if(email != null && password != null) {
            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                if (it.isSuccessful) {
                    isSuccess = true
                    user = it.result?.user
                    Log.d(Tag,user.toString())

                } else {
                    Log.d(Tag,it.exception.toString())
                    isSuccess = false
                }
            }

            return isSuccess
        }
        else{
            Log.d(Tag,"input is null")
            return false
        }
    }

}