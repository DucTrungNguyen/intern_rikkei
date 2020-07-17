package com.rikkei.tranning.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_b.*
import kotlinx.android.synthetic.main.activity_d.*

class DActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_d)
        btnGoActivityE.setOnClickListener {
            var intent = Intent(this, EActivity::class.java)
            startActivity(intent)
        }
    }
}