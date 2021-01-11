package com.example.phoneapp.autentificationmenagement

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest

class AuthViewModel() :ViewModel() {

    private val auth : FirebaseAuth by lazy {
        FirebaseAuth.getInstance()
    }
    var user =  MutableLiveData<FirebaseUser?>()
    var errorCode = MutableLiveData<String?>()
    val TAG = "AuthViewModel"


    fun login (email:String?,password: String?){
        auth.signInWithEmailAndPassword(email!!,password!!)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    if (task.result?.user != null) {
                        user.value = task.result?.user
                    }
                } else {
                    Log.w(TAG, "loginUserWithEmail:failure", task.exception)
                }
            }

    }

    fun signup (username:String?, email:String?, password:String?){
        auth.createUserWithEmailAndPassword(email!!, password!!)
            .addOnCompleteListener{ task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "createUserWithEmail:success")
                    val user = auth.currentUser
//                    updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
//                    Toast.makeText(this,"Authentication failed", Toast.LENGTH_SHORT).show()
//                    updateUI(null)
                }

                // ...
            }

//        auth.createUserWithEmailAndPassword(email!!,password!!)
//            .addOnCompleteListener { task->
//                if(task.isSuccessful){
//                    var tUser = task.result!!.user
//                    if(tUser != null){
//                        val profileUpdates = UserProfileChangeRequest.Builder()
//                            .setDisplayName(username)
//                            .build()
//                        tUser.updateProfile(profileUpdates)
//                            .addOnCompleteListener { task ->
//                                if (task.isSuccessful) {
//                                    user.value = tUser
//                                }
//                            }
//                    }
//                }else{
//
//                    val e =
//                        task.exception as FirebaseAuthException?
//
//                    errorCode.value = e!!.errorCode
//                }
//            }

    }

    fun isEmailValid(email: String?): Boolean {
        if (email != null) {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        } else {
            return false
        }
    }

    fun isPasswordValid(password: String?): Boolean {
        return password?.length!! > 5;
    }

}