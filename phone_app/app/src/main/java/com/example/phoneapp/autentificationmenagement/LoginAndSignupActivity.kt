package com.example.phoneapp.autentificationmenagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager2.widget.ViewPager2
import com.example.phoneapp.R
import com.example.phoneapp.databinding.ActivityLoginAndSignupBinding
import java.util.Observer

class LoginAndSignupActivity : AppCompatActivity() {
    var mViewPager : ViewPager2? = null
    var currentPage = 0
    var binding: ActivityLoginAndSignupBinding? = null
    lateinit var viewModel: AuthViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_login_and_signup)
        //setting viewModel, liveDate and dataBinding
        binding= DataBindingUtil.setContentView(this,R.layout.activity_login_and_signup)
        binding!!.lifecycleOwner = this
        viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)
        binding!!.viewModel = viewModel


        //setting viewPager
        mViewPager = findViewById(R.id.Login_container)
        val adapter = LoginPageAdpater(this)
        mViewPager!!.adapter = adapter

        //뷰모델의 user가 변경되는것(로그인)을 관찰 그리고 로그인
//        viewModel.user.observe(this, Observer{ user->
//            user?.let{
//                FirestoreRepository.instance.user = viewModel.user.value
//                checkUserChild()
//            }
//        })

    }
}