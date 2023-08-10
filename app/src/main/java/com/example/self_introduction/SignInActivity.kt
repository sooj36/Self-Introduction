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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val editText_id = findViewById<EditText>(R.id.editText_id)
        val textView_id = findViewById<TextView>(R.id.TextView_id)

        val editText_password = findViewById<EditText>(R.id.editText_password)
        val textView_password = findViewById<TextView>(R.id.TextView_password)

        val loginbutton = findViewById<Button>(R.id.loginbutton)

        editText_id.addTextChangedListener (object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                TODO("Not yet implemented")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                TODO("Not yet implemented")
            }

            override fun afterTextChanged(s: Editable?) {
                TODO("Not yet implemented")
            }


        })

        fun updateLoginButton() {
            val input_id = editText_id.text.toString()
            val input_password = editText_password.text.toString()

            if (input_id.isNotEmpty() && input_password.isNotEmpty()) {
                loginbutton.isEnabled = true
                loginbutton.setBackgroundColor(Color.BLUE)
                Toast.makeText(this, "로그인 성공 !", Toast.LENGTH_SHORT).show()


            }
            else {
//                loginbutton.isEnabled = false
                loginbutton.setBackgroundColor(Color.GRAY)
                Toast.makeText(this, "아이디와 비밀번호를 확인하세요", Toast.LENGTH_SHORT).show()

            }
        }

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
}