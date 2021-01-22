package com.example.phoneapp.firebase

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage

class FirebaseRepository {

    val Tag = "FirebaseRepository"
    var db = FirebaseFirestore.getInstance()
    var user = FirebaseAuth.getInstance().currentUser

    companion object{
        val instance = FirebaseRepository()
    }

}