package com.rikkei.tranning.activity

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_sub.*

class SubActivity : AppCompatActivity() {
    private  val TAG = "SubActivity"
    private  lateinit var media : MediaPlayer;
    var posTimeA : Int = 0;
    var posTimeB : Int = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
        btnBackPage.setOnClickListener {
            goBackPage()
        }
        media = MediaPlayer.create(getApplicationContext(), R.raw.jp);
    }

    override fun onStart() {

        val extras = intent.extras
        if (extras != null) {
            posTimeA = extras.getInt("currentA")
            posTimeB = extras.getInt("currentB")
        }
        super.onStart()
        media.start()
        media.seekTo(posTimeB)
        Log.i(TAG, "Override onStart")
    }

    override fun onPause() {
        super.onPause()
        media.stop()
        Log.i(TAG,  "Override onPause")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "Override onResume")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "Override onDestroy")
    }

    private fun goBackPage() {
        posTimeB = media.currentPosition
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra("currentA", posTimeA )
            putExtra("currentB", posTimeB )
        }
        val a = media.currentPosition
        startActivity(intent)

    }
}