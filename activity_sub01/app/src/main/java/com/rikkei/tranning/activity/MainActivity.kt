package com.rikkei.tranning.activity

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private  val TAG = "MainActivity"
    private  lateinit var media : MediaPlayer;
    private var   isFirstPlay : Boolean = true;
    var posTimeA : Int = 0;
    var posTimeB : Int = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnNextPage.setOnClickListener {
            goToNextPage()
        }
        media = MediaPlayer.create(getApplicationContext(), R.raw.sbs);
    }

    override fun onStart() {

        super.onStart()
        val extras = intent.extras
        if (extras != null) {
            posTimeA = extras.getInt("currentA")
            posTimeB = extras.getInt("currentB")
        }
        media.start()
        media.seekTo(posTimeA)
        Log.i(TAG, "Override onStart")


    }

    override fun onResume() {
        super.onResume()


        Log.i(TAG, "Override onResume")

    }

    override fun onPause() {
        super.onPause()
        media.stop()
        Log.i(TAG, "Override, onPause")
    }




    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "Override onDestroy")
    }

    private fun  goToNextPage(){
        posTimeA = media.currentPosition
        val intent = Intent(this, SubActivity::class.java).apply {
            putExtra("currentA", posTimeA )
            putExtra("currentB", posTimeB )
        }
        startActivity(intent)

    }
}