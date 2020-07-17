package com.rikkei.tranning.activity

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_a.*
import android.widget.MediaController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var pos : Int = 0;
    lateinit var mediaPlayer: MediaPlayer
    val videoAddress = "http://harikrushnabhosale.com/images/Demo.MP4"
    val videoUri = Uri.parse(videoAddress)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        mediaPlayer = MediaPlayer.create(activity, R.raw.sbs)

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt("pos", pos)


    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        if ( savedInstanceState != null){
            pos = savedInstanceState.getInt("pos")
        }

    }

    override fun onStart() {
        super.onStart()

        mediaPlayer.seekTo(pos)
        mediaPlayer.start()

//        val videoAddress = "https://raw.githubusercontent.com/o7planning/webexamples/master/_testdatas_/mov_bbb.mp4"
//        val videoUri = Uri.parse(videoAddress)
//        videoView.setVideoURI(videoUri)
//        videoView.seekTo(pos)
//        videoView.start()


//        val videoAddress = "https://raw.githubusercontent.com/o7planning/webexamples/master/_testdatas_/mov_bbb.mp4"
//        val videoUri = Uri.parse(videoAddress)
//        videoView.setVideoURI(videoUri)
//        val videoControl = MediaController(context)
//        videoControl.setAnchorView(videoView)
//        videoView.setMediaController(videoControl)
//        videoView.start()
//        videoView.seekTo(pos)

//        videoView.setVideoURI(videoUri)
//        val videoControl = MediaController(context)
//        videoControl.setAnchorView(videoView)
//        videoView.setMediaController(videoControl)
//        videoView.seekTo(pos)
//        videoView.start()
    }
    override fun onStop() {
        super.onStop()
        pos=  mediaPlayer.currentPosition
        mediaPlayer.stop()

//        pos = videoView.currentPosition
//        videoView.stopPlayback()
    }

    override fun onPause() {
        super.onPause()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}