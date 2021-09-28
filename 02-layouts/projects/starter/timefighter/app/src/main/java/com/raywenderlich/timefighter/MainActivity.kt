package com.raywenderlich.timefighter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
internal lateinit  var  gameScoreTextView: TextView
internal lateinit var  timeLeftTextView: TextView
internal  lateinit var tapMeButton: Button
internal lateinit var  testButton: Button
internal  lateinit var triedTextView: TextView

var score2 = 0

var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        testButton = findViewById(R.id.TestButton2)
        triedTextView = findViewById(R.id.tried)
        gameScoreTextView = findViewById(R.id.game_score_text_view)
        timeLeftTextView = findViewById(R.id.time_left_text_view)
        tapMeButton = findViewById(R.id.tap_me_button)
      tapMeButton.setOnClickListener {v-> incrementScore()}
        testButton.setOnClickListener {V ->  incrementScore2() }


    }
 private  fun incrementScore2(){
     score2++
     var newScore2 = "Tried: " + Integer.toString(score2)
     triedTextView.text = newScore2

 }
    private fun incrementScore() {
score++
        var newScore = "Your Score: " + Integer.toString(score)
        gameScoreTextView.text = newScore

    }

    private fun resetGame() {
        //reset game logic
    }

    private fun startGame() {
        //start game logic
    }

    private fun endGame() {
        //end game logic
    }
}