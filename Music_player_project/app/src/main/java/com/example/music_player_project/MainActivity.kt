package com.example.music_player_project

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.os.postDelayed
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    private val handler = Handler()
    private var startTime = 0.0
    private var finalTime = 0.0
    private var forwardTime = 10000
    private var backwardTime = 10000
    private var oneTimeOnly = 0

    // Declare mediaPlayer as a member variable
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var timeTxt: TextView
    private lateinit var seekBar: SeekBar
    @SuppressLint("DiscouragedApi", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // declaring app compat button because we can change the color of this button so we are using this button
        val btn1: AppCompatButton = findViewById(R.id.btn1)
        val btn2: AppCompatButton = findViewById(R.id.btn2)
        val btn3: AppCompatButton = findViewById(R.id.btn3)
        val btn4: AppCompatButton = findViewById(R.id.btn4)

        // declaring textView
        var titleTxt: TextView = findViewById(R.id.textView2)
        timeTxt = findViewById(R.id.textview3)

        // declaring seek bar
        seekBar = findViewById(R.id.seek_bar)

        // initialize mediaPlayer
        mediaPlayer = MediaPlayer.create(this, R.raw.softy)
        seekBar.isClickable = false

        // start button
        btn3.setOnClickListener {
            mediaPlayer.start()
            finalTime = mediaPlayer.duration.toDouble()
            startTime = mediaPlayer.currentPosition.toDouble()
            if (oneTimeOnly == 0) {
                seekBar.max = finalTime.toInt()
                oneTimeOnly = 1
            }
            timeTxt.text = startTime.toString()
            seekBar.progress = startTime.toInt()

            handler.postDelayed(updateSongTime, 100)
        }
        //setting the music title
        val resourceId = resources.getIdentifier("softy", "raw", packageName)
        titleTxt.text = getString(resourceId)
        // pause button
        btn4.setOnClickListener {
            mediaPlayer.pause()
        }
        //Forward Button
        btn2.setOnClickListener(){
            val temp = startTime
            if ((temp + forwardTime)<=finalTime){
                startTime += forwardTime
                mediaPlayer.seekTo(startTime.toInt())
            }else{
                Toast.makeText(this,"Can't jump forward",Toast.LENGTH_LONG).show()
            }
        }
        //Backward Button
        btn1.setOnClickListener(){
            val temp = startTime.toInt()
            if ((temp - backwardTime)>=0){
                startTime -= backwardTime
                mediaPlayer.seekTo(startTime.toInt())
            }else{
                Toast.makeText(this,"Can't jump backward",Toast.LENGTH_LONG).show()
            }
        }
    }

    private val updateSongTime: Runnable = object : Runnable {
        @SuppressLint("SetTextI18n")
        override fun run() {
            startTime = mediaPlayer.currentPosition.toDouble()
            timeTxt.text = "" + String.format("%d min , %d sec",TimeUnit.MILLISECONDS.toMinutes(startTime.toLong())
                               ,TimeUnit.MILLISECONDS.toSeconds(startTime.toLong()
                              - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(startTime.toLong()))))
            seekBar.progress = startTime.toInt()
            handler.postDelayed(this,100)
        }
    }
}
