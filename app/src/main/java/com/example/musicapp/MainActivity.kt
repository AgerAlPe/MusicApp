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

    private var pressed: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // This var would get the name from the database so that it can be passed to the image
        val editName: TextView = findViewById<TextView>(R.id.albumNameView)
        val editArtist: TextView = findViewById<TextView>(R.id.artistNameView)

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
    override fun onResume() {
        super.onResume()
        Log.d("Debug", "onResume")
        val play : ImageView = findViewById<ImageView>(R.id.imageViewPlay)
        val pause : ImageView = findViewById<ImageView>(R.id.imageViewPause)
        if (pressed) {
            pause.visibility = View.VISIBLE
            play.visibility = View.INVISIBLE
        }else {
            pause.visibility = View.INVISIBLE
            play.visibility = View.VISIBLE
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d("Debug","onSaveInstanceState")
        // Save the user's current game state.
        outState?.run {
            putBoolean("result", pressed)

        }
        // Always call the superclass so it can save the view hierarchy.
        super.onSaveInstanceState(outState)
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        // Always call the superclass so it can restore the view hierarchy.
        super.onRestoreInstanceState(savedInstanceState)
        // Restore state members from saved instance.
        savedInstanceState?.run {
            pressed = savedInstanceState.getBoolean("result")
            val play : ImageView = findViewById<ImageView>(R.id.imageViewPlay)
            val pause : ImageView = findViewById<ImageView>(R.id.imageViewPause)
            if(pressed) {
                pause.visibility = View.VISIBLE
                play.visibility = View.INVISIBLE
            }else {
                pause.visibility = View.INVISIBLE
                play.visibility = View.VISIBLE
            }
        }
    }

}