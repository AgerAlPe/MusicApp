package com.example.musicapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // This var would get the name from the database so that it can be passed to the image
        val editName: TextView = findViewById<TextView>(R.id.albumNameView)
        val editArtist: TextView = findViewById<TextView>(R.id.artistNameView)

        var pressed: Boolean = false
        val play : ImageView = findViewById<ImageView>(R.id.imageViewPlay)
        val pause : ImageView = findViewById<ImageView>(R.id.imageViewPause)

        play.setOnClickListener {
            pause.visibility = View.VISIBLE
            play.visibility = View.INVISIBLE
            pressed = true
        }

        pause.setOnClickListener {
            pause.visibility = View.INVISIBLE
            play.visibility = View.VISIBLE
            pressed = false
        }
    }
}