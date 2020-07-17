package com.rikkei.tranning.activity

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import android.provider.MediaStore
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private val CAMERA_VIDEO_REQUEST = 1337
    private val CACULATOR : Int = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnOpenCamera.setOnClickListener {
            openCameraApp()
        }
        btnToActivityB.setOnClickListener {
            var intent = Intent(this, BActivity::class.java)
            startActivity(intent)
        }
        btnCaculator.setOnClickListener {
            var intent = Intent(this, BActivity::class.java)
            startActivityForResult(intent,CACULATOR)
        }



        when {
            intent?.action == Intent.ACTION_SEND -> {
                if (intent.type?.startsWith("video/") == true){
                    handleSendVideo(intent)

                }else
                if ("text/plain" == intent.type) {
                    handleSendText(intent) // Handle text being sent
                } else if (intent.type?.startsWith("image/") == true) {
                    handleSendImage(intent) // Handle single image being sent
                }
            }
            intent?.action == Intent.ACTION_SEND_MULTIPLE
                    && intent.type?.startsWith("image/") == true -> {
                handleSendMultipleImages(intent) // Handle multiple images being sent
            }
            else -> {
                // Handle other intents, such as being started from the home screen
            }
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if ( requestCode == CACULATOR && resultCode == Activity.RESULT_OK){
            if (data != null) {
                var a =  data.getIntExtra("result", 0).toString()
                txtResult.text = a
            }
        }
    }


    private fun handleSendText(intent: Intent) {
        intent.getStringExtra(Intent.EXTRA_TEXT)?.let {
            // Update UI to reflect text being shared
        }
    }

    private fun handleSendImage(intent: Intent) {
        (intent.getParcelableExtra<Parcelable>(Intent.EXTRA_STREAM) as? Uri)?.let {
            imageView.setImageURI(it)

        }
    }
    private fun handleSendVideo(intent: Intent) {
        (intent.getParcelableExtra<Parcelable>(Intent.EXTRA_STREAM) as? Uri)?.let {
            videoView.visibility = View.VISIBLE
            videoView.setVideoURI(it)
            videoView.requestFocus();
//            videoView.setMediaController( MediaController(this))
            videoView.start()

        }
    }

//    private fun imageFrom(uri: Uri): ByteArray {
//        val stream = contentResolver.openInputStream(uri)
//        val bitmap = BitmapFactory.decodeStream(stream)
//        stream.close()
//        val baos = ByteArrayOutputStream()
//        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
//        val image = baos.toByteArray()
//        return image
//    }

    private fun handleSendMultipleImages(intent: Intent) {
        intent.getParcelableArrayListExtra<Parcelable>(Intent.EXTRA_STREAM)?.let {
            // Update UI to reflect multiple images being shared
        }
    }


    private fun openCameraApp(){
        val takePictureIntent = Intent(MediaStore.ACTION_VIDEO_CAPTURE)
        takePictureIntent.putExtra("android.intent.extra.durationLimit", 10);
        startActivityForResult(takePictureIntent, CAMERA_VIDEO_REQUEST)
    }
}