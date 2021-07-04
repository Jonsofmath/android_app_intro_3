package com.example.myfirstapp

/* Import libraries */
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageButton
import java.util.*
import kotlin.concurrent.schedule

/* Main class definition */
class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun playGame(view: View){
        val intent = Intent(this, MainMenu::class.java).apply{
        }
        startActivity(intent)
    }

    fun highScore(view: View){
        val intent = Intent(this, HighScore::class.java)
        startActivity(intent)
    }
}
