package com.example.phoneapp.autentificationmenagement

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.phoneapp.R
import kotlinx.android.synthetic.main.fragmenet_signup.*
import kotlinx.android.synthetic.main.fragmenet_signup.signupBtn
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    var loginAndSignupActivity : LoginAndSignupActivity? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view =  inflater.inflate(R.layout.fragment_login, container, false)
        return view


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        loginAndSignupActivity = (activity as LoginAndSignupActivity)

        loginBtn.setOnClickListener {
            loginBtn.isCheckable=false

            var email :  String? = loginUsername.text.toString()
            var password: String? = loginPassword.text.toString()

            var validValue : Boolean = checkEmailAndPassword(email,password)

            if(validValue){
                loginAndSignupActivity!!.viewModel.login(email,password)
            }
            else{
                loginBtn.isCheckable=true
            }

//            var validValue: Boolean  = checkSignupValue(username,email,password,passwordConfirm)
//            if(!validValue){
//                signupBtn.isClickable = true
//            }
//            else{
//                loginAndSignupActivity!!.viewModel.signup(username,email,password)
//            }

        }

    }

    private fun checkEmailAndPassword(email:String?, password: String?) : Boolean{

        if (!loginAndSignupActivity!!.viewModel.isPasswordValid(password)) {
            loginPassword!!.error = "6자리 이상의 비밀번호를 입력해 주세요."
            return false
        }

        if (TextUtils.isEmpty(email)) {
            loginUsername!!.error = "이메일 주소를 입력해주세요"
            return false
        } else if (!loginAndSignupActivity!!.viewModel.isEmailValid(email)) {
            loginUsername!!.error = "잘못된 이메일 형식입니다."
            return false
        }

        return true
    }

}
