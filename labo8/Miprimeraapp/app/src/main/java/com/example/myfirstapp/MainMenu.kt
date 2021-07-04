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
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import java.util.*
import kotlin.concurrent.schedule
import android.widget.TextView

class MainMenu : AppCompatActivity() {
    /* Media player variables */
    private var mMediaPlayer0: MediaPlayer? = null
    private var mMediaPlayer1: MediaPlayer? = null
    private var mMediaPlayer2: MediaPlayer? = null
    private var mMediaPlayer3: MediaPlayer? = null
    private var mMediaPlayer4: MediaPlayer? = null
    private var mMediaPlayer5: MediaPlayer? = null
    /* Image button variables */
    private lateinit var button0 : ImageButton
    private lateinit var button1 : ImageButton
    private lateinit var button2 : ImageButton
    private lateinit var button3 : ImageButton
    private lateinit var button4 : ImageButton
    private lateinit var button5 : ImageButton
    private lateinit var score_display : TextView
    private lateinit var user_button : EditText
    private lateinit var doneButton : Button

    /* Other private variables */
    private var buttonPressed = 0   // 0 if imageButton0 pressed, 1 if imageButton1 pressed, etc
    private val num = arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)   // stores the number of the button that it's pressed
    // e.g. num[1] = 2 means that at second iteration,
    // button three was pressed
    private var counter = 0 // iterator of num array
    private var flag = 0    // function activation flag used in playSound functions
    private var iter_sequence: Int = 0  // sequence increment
    var score = 0   // actual score

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
    }

    /* Media player functions associated to each of six buttons
    *  The functions reproduces an audio when button is pressed
    *  and change it's color. */

    fun playSound0(view: View) {
        button0 = findViewById(R.id.imageButton0)

        if (mMediaPlayer0 == null) {
            mMediaPlayer0 = MediaPlayer.create(this, R.raw.alarm)
            mMediaPlayer0!!.start()

            button0.setBackgroundResource(R.color.green)
            val handler = Handler(Looper.getMainLooper())
            handler.postDelayed({
                button0.setBackgroundResource(R.color.default0)
            }, 800)
        } else
            mMediaPlayer0!!.start()
        button0.setBackgroundResource(R.color.green)
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            button0.setBackgroundResource(R.color.default0)
        }, 800)
        buttonPressed = 0   // stores the info of the button pressed
        if(flag == 1) {
            compare(view)
        }
    }

    fun playSound1(view: View) {
        button1 = findViewById(R.id.imageButton1)
        if (mMediaPlayer1 == null) {
            mMediaPlayer1 = MediaPlayer.create(this, R.raw.bird)
            mMediaPlayer1!!.start()
            button1.setBackgroundResource(R.color.green)
            val handler = Handler(Looper.getMainLooper())
            handler.postDelayed({
                button1.setBackgroundResource(R.color.default1)
            }, 900)

        } else
            mMediaPlayer1!!.start()
        button1.setBackgroundResource(R.color.green)
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            button1.setBackgroundResource(R.color.default1)
        }, 900)
        buttonPressed = 1   // stores the info of the button pressed
        if(flag == 1) {
            compare(view)
        }
    }

    fun playSound2(view: View) {
        button2 = findViewById(R.id.imageButton2)
        if (mMediaPlayer2 == null) {
            mMediaPlayer2 = MediaPlayer.create(this, R.raw.bleep)
            mMediaPlayer2!!.start()
            button2.setBackgroundResource(R.color.green)
            val handler = Handler(Looper.getMainLooper())
            handler.postDelayed({
                button2.setBackgroundResource(R.color.default2)
            }, 800)

        } else
            mMediaPlayer2!!.start()
        button2.setBackgroundResource(R.color.green)
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            button2.setBackgroundResource(R.color.default2)
        }, 800)
        buttonPressed = 2   // stores the info of the button pressed
        if(flag == 1) {
            compare(view)
        }
    }

    fun playSound3(view: View) {
        button3 = findViewById(R.id.imageButton3)
        if (mMediaPlayer3 == null) {
            mMediaPlayer3 = MediaPlayer.create(this, R.raw.drum)
            mMediaPlayer3!!.start()
            button3.setBackgroundResource(R.color.green)
            val handler = Handler(Looper.getMainLooper())
            handler.postDelayed({
                button3.setBackgroundResource(R.color.default3)
            }, 700)

        } else
            mMediaPlayer3!!.start()
        button3.setBackgroundResource(R.color.green)
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            button3.setBackgroundResource(R.color.default3)
        }, 700)
        buttonPressed = 3   // stores the info of the button pressed
        if(flag == 1) {
            compare(view)
        }
    }

    fun playSound4(view: View) {
        button4 = findViewById(R.id.imageButton4)
        if (mMediaPlayer4 == null) {
            mMediaPlayer4 = MediaPlayer.create(this, R.raw.forest_bird)
            mMediaPlayer4!!.start()
            button4.setBackgroundResource(R.color.green)
            val handler = Handler(Looper.getMainLooper())
            handler.postDelayed({
                button4.setBackgroundResource(R.color.default4)
            }, 800)

        } else
            mMediaPlayer4!!.start()
        button4.setBackgroundResource(R.color.green)
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            button4.setBackgroundResource(R.color.default4)
        }, 800)
        buttonPressed = 4   // stores the info of the button pressed
        if(flag == 1) {
            compare(view)
        }
    }

    fun playSound5(view: View) {
        button5 = findViewById(R.id.imageButton5)
        if (mMediaPlayer5 == null) {
            mMediaPlayer5 = MediaPlayer.create(this, R.raw.transition)
            mMediaPlayer5!!.start()
            button5.setBackgroundResource(R.color.green)
            val handler = Handler(Looper.getMainLooper())
            handler.postDelayed({
                button5.setBackgroundResource(R.color.default5)
            }, 1000)

        } else
            mMediaPlayer5!!.start()
        button5.setBackgroundResource(R.color.green)
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            button5.setBackgroundResource(R.color.default5)
        }, 1000)
        buttonPressed = 5   // stores the info of the button pressed
        if(flag == 1) {
            compare(view)
        }
    }

    /* Function that disable all of the six media player buttons */
    private fun deactivate(view: View){
        button0 = findViewById(R.id.imageButton0)
        button1 = findViewById(R.id.imageButton1)
        button2 = findViewById(R.id.imageButton2)
        button3 = findViewById(R.id.imageButton3)
        button4 = findViewById(R.id.imageButton4)
        button5 = findViewById(R.id.imageButton5)

        button0.isEnabled = false
        button0.isClickable = false
        button1.isEnabled = false
        button1.isClickable = false
        button2.isEnabled = false
        button2.isClickable = false
        button3.isEnabled = false
        button3.isClickable = false
        button4.isEnabled = false
        button5.isClickable = false
        button5.isEnabled = false
        button5.isClickable = false

    }

    /* Function that enable all of the six media player buttons */
    private fun activate(view: View){
        button0 = findViewById(R.id.imageButton0)
        button1 = findViewById(R.id.imageButton1)
        button2 = findViewById(R.id.imageButton2)
        button3 = findViewById(R.id.imageButton3)
        button4 = findViewById(R.id.imageButton4)
        button5 = findViewById(R.id.imageButton5)

        button0.isEnabled = true
        button0.isClickable = true
        button1.isEnabled = true
        button1.isClickable = true
        button2.isEnabled = true
        button2.isClickable = true
        button3.isEnabled = true
        button3.isClickable = true
        button4.isEnabled = true
        button5.isClickable = true
        button5.isEnabled = true
        button5.isClickable = true

    }

    /* Function associated to Start button
    *  Plays four random buttons and stores the info of which button was pressed on num array
    *  e.g.: num = (2, 1, 0, 5) means that:
    *           button three were first random pressed
    *           button two were second random pressed
    *           button one were third random pressed
    *           button six were fourth random  */

    fun randomPlay(view: View){
        flag = 0
        deactivate(view)    // deactivate functions while random play
        var delay: Long = 1000
        for (i in 0..iter_sequence) {
            Timer("SettingUp", false).schedule(delay) {
                // choose random button.
                val random = (0..5).random()
                if (random == 0) {
                    playSound0(view)
                    num.set(i, 0)
                } else if (random == 1) {
                    playSound1(view)
                    num.set(i, 1)
                } else if (random == 2) {
                    playSound2(view)
                    num.set(i, 2)
                } else if (random == 3) {
                    playSound3(view)
                    num.set(i, 3)
                } else if (random == 4) {
                    playSound4(view)
                    num.set(i, 4)
                } else {
                    playSound5(view)
                    num.set(i, 5)
                }
            }
            delay = delay + 2000
        }
        /* After a delay since random play, buttons get reactivated and flag sets to one, meaning
        *  that compare function in playSound functions will work if they are pressed */
        Timer("SettingUp", false).schedule(delay) {
            activate(view)
            flag = 1
        }
    }

    /* Function that compares num array with the info of the button pressed
    *  After a button is pressed we have the info of who was pressed in buttonPressed variable,
    * then, if flag is one, compare function will work and will take one num array entry, specified
    * by counter variable and compare it's value with buttonPressed value to determine if they are
    *  equal or different */

    private fun compare(view: View) {
        val mySnackbar = Snackbar.make(view, "Va por buen camino.", 1500)
        val mySnackbar0 = Snackbar.make(view, "Falló la secuencia. Por favor, repetir.", 1500)
        val mySnackbar1 = Snackbar.make(view, "¡ÉXITOOO!", 1500)

        if (num[counter] == buttonPressed && counter == iter_sequence) {
            /* Sequence was succesfully repeated :) */
            mySnackbar1.show()  // show success message to user.
            counter = 0
            flag = 0
            iter_sequence = iter_sequence + 1   // one more random play button
            score = score + 1                   // actualize actual score

            /* display actual score */
            score_display = findViewById(R.id.high_score_title)
            score_display.setText("Puntaje: " + score)

        } else if (num[counter] == buttonPressed && counter != iter_sequence) {
            /* Sequence in progress */
            mySnackbar.show()   // show progress message
            counter = counter + 1   // when other button is pressed, we'll need to compare the next
            // num array entry.
        } else {
            /* Sequence failed :( */
            mySnackbar0.show()
            counter = 0
            flag = 0
            iter_sequence = 0
            visibleButton(view)
            invisibleButtonSound(view)
        }
    }

    /* Visible buttons function */
    fun visibleButton(view: View){
        user_button = findViewById(R.id.username)
        doneButton = findViewById(R.id.doneButton)

        user_button.setVisibility(View.VISIBLE);
        doneButton.setVisibility(View.VISIBLE);
    }

    /* Invisible buttons function */
    fun invisibleButton(view: View){
        user_button = findViewById(R.id.username)
        doneButton = findViewById(R.id.doneButton)

        user_button.setVisibility(View.GONE);
        doneButton.setVisibility(View.GONE);
    }

    /* Invisible sound buttons function */
    fun invisibleButtonSound(view: View){
        button0 = findViewById(R.id.imageButton0)
        button1 = findViewById(R.id.imageButton1)
        button2 = findViewById(R.id.imageButton2)
        button3 = findViewById(R.id.imageButton3)
        button4 = findViewById(R.id.imageButton4)
        button5 = findViewById(R.id.imageButton5)

        button0.setVisibility(View.GONE);
        button1.setVisibility(View.GONE);
        button2.setVisibility(View.GONE);
        button3.setVisibility(View.GONE);
        button4.setVisibility(View.GONE);
        button5.setVisibility(View.GONE);
    }

    /* Visible sound buttons function */
    fun visibleButtonSound(view: View){
        button0 = findViewById(R.id.imageButton0)
        button1 = findViewById(R.id.imageButton1)
        button2 = findViewById(R.id.imageButton2)
        button3 = findViewById(R.id.imageButton3)
        button4 = findViewById(R.id.imageButton4)
        button5 = findViewById(R.id.imageButton5)

        button0.setVisibility(View.VISIBLE);
        button1.setVisibility(View.VISIBLE);
        button2.setVisibility(View.VISIBLE);
        button3.setVisibility(View.VISIBLE);
        button4.setVisibility(View.VISIBLE);
        button5.setVisibility(View.VISIBLE);
    }

    /* Saves user scores and sends info to High Score Activity */
    fun sendScore(view: View) {
        invisibleButton(view)
        visibleButtonSound(view)
        val editText = findViewById<EditText>(R.id.username)
        val userString = editText.text.toString()

        val intent = Intent(this, HighScore::class.java).apply {
            putExtra("user", userString)
            putExtra("score", score)
        }
        startActivity(intent)
    }
}


