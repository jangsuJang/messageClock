package com.example.phoneapp.autentificationmenagement

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.phoneapp.R
import kotlinx.android.synthetic.main.fragmenet_signup.*

class SignupFragment : Fragment() {

    var loginAndSignupActivity : LoginAndSignupActivity? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view =  inflater.inflate(R.layout.fragmenet_signup, container, false)
        return view

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        loginAndSignupActivity = (activity as LoginAndSignupActivity)

        signupBtn.setOnClickListener {
            signupBtn.isCheckable=false
            var username :String? = signupUsername.text.toString()
            var email : String? = signupEmail.text.toString()
            var password: String? = signupPassword.text.toString()
            var passwordConfirm : String? = signupPasswordConfirm.text.toString()

            var validValue: Boolean  = checkSignupValue(username,email,password,passwordConfirm)
            if(!validValue){
                signupBtn.isClickable = true
            }
            else{
                loginAndSignupActivity!!.viewModel.signup(username,email,password)
            }

        }

    }

    private fun checkSignupValue(userName:String?, email:String?,password : String?, passwordCheck : String?) :Boolean{
        if(TextUtils.isEmpty(userName)){
            signupUsername.error = "사용자명을 입력해주세요"
            return false
        }
        if(!loginAndSignupActivity!!.viewModel.isPasswordValid(password) || TextUtils.isEmpty(password)){
            signupPassword.error = "6자리 이상의 비밀번호를 입력해 주세요."
            return false
        }
        if(passwordCheck != password){
            signupPassword.error="비밀번호와 비밀번호 확인이 일치하지 않습니다"
            return false
        }
        if (TextUtils.isEmpty(email)) {
            signupEmail!!.error = "이메일 주소를 입력해주세요"
            return false
        } else if (!loginAndSignupActivity!!.viewModel.isEmailValid(email)) {
            signupEmail!!.error = "잘못된 이메일 형식입니다."
            return false
        }
        return true
    }

}
