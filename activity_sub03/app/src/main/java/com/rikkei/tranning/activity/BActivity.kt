package com.rikkei.tranning.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_b.*
import kotlinx.android.synthetic.main.activity_main.*

class BActivity : AppCompatActivity() {
    private val CACULATOR : Int = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)
        btnGoActivityC.setOnClickListener {
            var intent = Intent(this, CActivity::class.java)
            startActivity(intent)
        }
        btnGoActivityCCaculator.setOnClickListener {
            var intentC = Intent (this,CActivity::class.java )
            intentC.flags = Intent.FLAG_ACTIVITY_FORWARD_RESULT
            startActivity(intentC )
            finish()
//            intentC.flags = Intent.
        }
    }
}