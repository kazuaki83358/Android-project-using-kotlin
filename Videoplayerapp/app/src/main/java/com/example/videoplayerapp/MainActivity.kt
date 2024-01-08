package com.example.videoplayerapp

import android.annotation.SuppressLint
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val videoView : VideoView = findViewById(R.id.video_view1)
        //setting the path for video
        videoView.setVideoPath(
            "android.resource://"
            +packageName+"/"
            +R.raw.video_player
        )
        val mediaController = MediaController(this)

        mediaController.setAnchorView(videoView)
        mediaController.setMediaPlayer(videoView)
        videoView.setMediaController(mediaController)

    }
}