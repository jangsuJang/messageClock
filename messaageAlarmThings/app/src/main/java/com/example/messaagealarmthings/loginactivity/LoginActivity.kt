package com.example.messaagealarmthings.loginactivity

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
//import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.messaagealarmthings.R
import kotlinx.android.synthetic.main.activity_login.*
import androidx.lifecycle.Observer
import com.example.messaagealarmthings.firebaserepository.FirebaseRepository

class LoginActivity :Activity() {

    var binding: LoginActivity? = null

    val TAG = "LoginActivityTag"
    var firebaseRepository = FirebaseRepository.instance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        login_btn.setOnClickListener {
            var email = login_email.text.toString()
            var password = login_email.text.toString()
            firebaseRepository.signin(email,password)
            Log.d(TAG, firebaseRepository.user.toString())
            Toast.makeText(this,firebaseRepository.user.toString(),Toast.LENGTH_SHORT).show()
        }

    }

//    fun login(email:String, password:String){
//        // if login was successful update user
//        if(firebaseRepository.signin(email,password)) {
//            Log.d(TAG, firebaseRepository.toString())
//        }
//    }

}