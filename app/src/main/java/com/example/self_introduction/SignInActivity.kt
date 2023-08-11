package com.example.self_introduction

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class SignInActivity : AppCompatActivity() {
    private val editText_id : EditText by lazy { findViewById(R.id.editText_id) }
    private val editText_password : EditText by lazy { findViewById(R.id.editText_password) }
    private val loginbutton : Button by lazy { findViewById(R.id.loginbutton) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val textView_id = findViewById<TextView>(R.id.TextView_id)
        val textView_password = findViewById<TextView>(R.id.TextView_password)


        var idInputComplete = false
        var pwInputComplete = false

        editText_id.addTextChangedListener (object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s != null) {
                    idInputComplete = s.length > 1
                }
                if (idInputComplete && pwInputComplete) {
                    updateLoginButton()
                }
            }
            override fun afterTextChanged(s: Editable?) {

            }
            }
    )


            editText_password.addTextChangedListener (object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    if (s != null) {
                        pwInputComplete = s.length > 1
                    }
                    if (idInputComplete && pwInputComplete) {
                        updateLoginButton()
                    }

                }
                override fun afterTextChanged(s: Editable?) {

                }
            })



            loginbutton.setOnClickListener {
                updateLoginButton()
            }



        val btn2 = findViewById<Button>(R.id.loginbutton) //로그인 실행
        btn2.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        val btn = findViewById<Button>(R.id.signupbutton) // 회원가입 실행
        btn.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)

        }
    }
    fun updateLoginButton() {
        val input_id = editText_id.text.toString()
        val input_password = editText_password.text.toString()

        if (input_id.isNotEmpty() && input_password.isNotEmpty()) {
            loginbutton.isEnabled = true
            loginbutton.setBackgroundColor(Color.BLUE)
            Toast.makeText(this, "로그인 성공 !", Toast.LENGTH_SHORT).show()


        }
        else {
            loginbutton.isEnabled = false
            loginbutton.setBackgroundColor(Color.GRAY)
            Toast.makeText(this, "아이디와 비밀번호를 확인하세요", Toast.LENGTH_SHORT).show()

        }
    }
}