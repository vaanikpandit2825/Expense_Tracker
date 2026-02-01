package com.example.expensetracker

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val tvLogin = findViewById<TextView>(R.id.tvLogin)

        tvLogin.setOnClickListener {
            finish()
        }
    }
}
