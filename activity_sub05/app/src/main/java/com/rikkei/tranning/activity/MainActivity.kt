package com.rikkei.tranning.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    override fun onStart() {
        super.onStart()

        if ( supportFragmentManager.backStackEntryCount == 0){
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_main, AFragment.newInstance("A", "Hello"))
                .addToBackStack(null)
                .commit()
        }

    }

}