package com.technical.mymathgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class GameActivity : AppCompatActivity() {

    lateinit var textScore : TextView
    lateinit var textLife : TextView
    lateinit var textTime : TextView

    lateinit var textQuestion : TextView
    lateinit var textAnswer : TextView

    lateinit var buttonOk : Button
    lateinit var buttonNext : Button

    var correctAnswer = 0
    var userScore = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_page)

        textScore = findViewById(R.id.textViewScore)
        textLife = findViewById(R.id.textViewLife)
        textTime = findViewById(R.id.textViewTime)
        textQuestion = findViewById(R.id.textViewQuestion)
        textAnswer = findViewById(R.id.editTextAnswer)
        buttonOk = findViewById(R.id.buttonOk)
        buttonNext = findViewById(R.id.buttonNext)

        buttonOk.setOnClickListener {

            val input = textAnswer.text.toString()

            if(input == "")
            {
                Toast.makeText(applicationContext,"Please write an answer or click the next butto",
                Toast.LENGTH_LONG).show()
            }
            else
            {
                val userAnswer = input.toInt()
                if(userAnswer == correctAnswer)
                {
                    userScore += 10
                }
                else{

                }
            }

        }
        buttonNext.setOnClickListener {

        }

        fun gameContinue()
        {
              val number1 = Random.nextInt(0,100)
            val number2 = Random.nextInt(0,100)

            textQuestion.text = "$number1 + $number2"

            correctAnswer = number1 + number2
        }
    }
}