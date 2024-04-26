package com.example.movieapp

import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class movie_details_home_1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_movie_details_home1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val videoView = findViewById<VideoView>(R.id.video_view_home_1)
        val packageName = "android.resource://" + getPackageName() + "/" + R.raw.the_conjuring
        val uri = Uri.parse(packageName)
        videoView.setVideoURI(uri)

        val mediaController = MediaController(this)
        videoView.setMediaController(mediaController)

        videoView.setOnPreparedListener { mediaPlayer ->
            mediaPlayer.isLooping = true // Optional: to loop the video
            mediaPlayer.start() // Start playing the video
        }

//        val videoView = findViewById<VideoView>(R.id.videoView_home_1)
//        val mediaController : MediaController
//        mediaController = MediaController(this)
//        videoView.setMediaController(mediaController)
//        videoView.setVideoPath("https://youtu.be/VFsmuRPClr4?si=aDG2opcnHQYnaLAp")
//        videoView.start()
//        videoView.setMediaController(mediaController)
    }
}