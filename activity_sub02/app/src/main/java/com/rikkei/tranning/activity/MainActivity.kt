package com.rikkei.tranning.activity

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore

class MainActivity : AppCompatActivity() {
    private  var posTime : Int =0;
    private  lateinit var media : MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        media = MediaPlayer.create(applicationContext, R.raw.jp)
        if ( savedInstanceState != null){
            posTime = savedInstanceState.getInt("posTime")
        }
    }

    override fun onStart() {
        super.onStart()


        media.start()
        media.seekTo(posTime)
//        if (extras != null){
//            posTime = extras.getInt("posTime")
//            media.start()
//            media.seekTo(posTime)
//        }else {
//            media.start()
//            media.seekTo(posTime)
//        }

    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        media.stop();
        posTime = media.currentPosition
        outState.putInt("posTime", posTime)


    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        posTime = savedInstanceState.getInt("posTime")

    }
}