package com.example.myfirstapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

private val scoresList = arrayOf(0, 0, 0, 0, 0)
private val usersList = arrayOf("","","","","")
private var equalFlag = 0

class HighScore : AppCompatActivity() {
    private lateinit var userDisplay0 : TextView
    private lateinit var userDisplay1 : TextView
    private lateinit var userDisplay2 : TextView
    private lateinit var userDisplay3 : TextView
    private lateinit var userDisplay4 : TextView

    private lateinit var scoreDisplay : TextView
    private lateinit var scoreDisplay0 : TextView
    private lateinit var scoreDisplay1 : TextView
    private lateinit var scoreDisplay2 : TextView
    private lateinit var scoreDisplay3 : TextView
    private lateinit var scoreDisplay4 : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_high_score)

        // Get the Intent that started this activity and extract the string and Int
        var userString = intent.getStringExtra("user")
        var score: Int = intent.getIntExtra("score", 0)

        // users and scores arrays actualize (if needed)
        if(score > scoresList[0]){
            if(userString != null) {
                usersList[0] = userString
            }
            scoresList[0] = score
            for (i in 0..3){
                if(scoresList[i] > scoresList[i+1]){
                    scoresList[i] = scoresList[i+1].also { scoresList[i+1] = scoresList[i] }
                    usersList[i] = usersList[i+1].also { usersList[i+1] = usersList[i] }
                }
            }
        }

        // display scores and users values on screen
        userDisplay0 = findViewById(R.id.high_user_0)
        userDisplay1 = findViewById(R.id.high_user_1)
        userDisplay2 = findViewById(R.id.high_user_2)
        userDisplay3 = findViewById(R.id.high_user_3)
        userDisplay4 = findViewById(R.id.high_user_4)

        userDisplay0.setText(usersList[4])
        userDisplay1.setText(usersList[3])
        userDisplay2.setText(usersList[2])
        userDisplay3.setText(usersList[1])
        userDisplay4.setText(usersList[0])

        scoreDisplay0 = findViewById(R.id.score_0)
        scoreDisplay1 = findViewById(R.id.score_1)
        scoreDisplay2 = findViewById(R.id.score_2)
        scoreDisplay3 = findViewById(R.id.score_3)
        scoreDisplay4 = findViewById(R.id.score_4)

        scoreDisplay0.setText(""+scoresList[4])
        scoreDisplay1.setText(""+scoresList[3])
        scoreDisplay2.setText(""+scoresList[2])
        scoreDisplay3.setText(""+scoresList[1])
        scoreDisplay4.setText(""+scoresList[0])
    }
}
