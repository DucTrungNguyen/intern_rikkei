package com.rikkei.tranning.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLinear.setOnClickListener {
            val intentLinear = Intent(this, LinearActivity::class.java)
            startActivity(intentLinear)

        }
        btnGrid.setOnClickListener {
            val intentGrid = Intent(this, GridActivity::class.java)
            startActivity(intentGrid)

        }
        btnStaggered.setOnClickListener {
            val intentStaggered = Intent(this, StaggeredActivity::class.java)
            startActivity(intentStaggered)

        }
    }
}