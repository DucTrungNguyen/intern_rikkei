package com.rikkei.tranning.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_b.*
import kotlinx.android.synthetic.main.activity_c.*

class CActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c)
        btnGoActivityD.setOnClickListener {
            var intent = Intent(this, DActivity::class.java)
            startActivity(intent)
        }
        btnbackActivityACaculator.setOnClickListener {
            var intentA = Intent(this, MainActivity::class.java)
            intentA.putExtra("result", 12)
            setResult(Activity.RESULT_OK, intentA)
            finish()

        }
    }
}