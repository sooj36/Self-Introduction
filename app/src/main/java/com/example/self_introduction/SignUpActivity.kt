package com.example.self_introduction

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {

    private val name_et: EditText by lazy { findViewById(R.id.name_et) }
    private val id_et : EditText by lazy { findViewById(R.id.id_et) }
    private val pw_et : EditText by lazy { findViewById(R.id.pw_et) }

    private val signup_button : EditText by lazy { findViewById(R.id.signup_button) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val nameInputComplete = false
        val idInputComplete = false
        val pwInputComplete = false

        name_et.addTextChangedListener(object : TextWatcher) {
        }

        signup_button.setOnClickListener {
            updateSignUpButton()
        }

        val btn3 = findViewById<Button>(R.id.signup_button) //회원가입 버튼 실행
        btn3.setOnClickListener {
            val intent = Intent ("this", SignUpActivity::class.java)
            startActivity(intent)
        }


        }
    fun updateSignUpButton() {
        val InputName = name_et.text.toString()
        val InputId = id_et.text.toString()
        val InputPw = pw_et.text.toString()

        if (InputName.isNotEmpty() && InputId.isNotEmpty() && InputPw.isNotEmpty()) {
            signup_button.isEnabled = true
            signup_button.setBackgroundColor(Color.BLUE)
            Toast.makeText("this", "회원가입 성공 !", Toast.LENGTH_LONG).show()
        }
        else {
            signup_button.isEnabled = false
            signup_button.setBackgroundColor(Color.GRAY)
            Toast.makeText("this", "입력되지 않은 정보가 있습니다", Toast.LENGTH_LONG).show()
        }
    }
    }