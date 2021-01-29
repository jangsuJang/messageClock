//package com.example.messaagealarmthings.loginactivity
//
//import android.util.Log
//import android.widget.Toast
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import com.example.messaagealarmthings.firebaserepository.FirebaseRepository
//import com.google.firebase.auth.FirebaseUser
//
//class loginViewModel() : ViewModel() {
//    val TAG = "LoginViewModelTag"
//    var user =  MutableLiveData<FirebaseUser?>()
//    var firebaseRepository =FirebaseRepository.instance
//
//    fun login(email:String, password:String){
//        // if login was successful update user
//        if(firebaseRepository.signin(email,password)) user.value = this.firebaseRepository.user
//        Log.d(TAG,user.toString())
//
//    }
//
//}