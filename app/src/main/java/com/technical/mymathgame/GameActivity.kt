package com.technical.mymathgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.Locale
import kotlin.random.Random
import android.content.Intent

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
    var userLife = 3


    lateinit var timer : CountDownTimer
    private val startTimerInMillis : Long = 20000
    var timeLeftInMillis : Long = startTimerInMillis
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_page)

       supportActionBar?.title = "Addition"

        textScore = findViewById(R.id.textViewScore)
        textLife = findViewById(R.id.textViewLife)
        textTime = findViewById(R.id.textViewTime)
        textQuestion = findViewById(R.id.textViewQuestion)
        textAnswer = findViewById(R.id.editTextAnswer)
        buttonOk = findViewById(R.id.buttonOk)
        buttonNext = findViewById(R.id.buttonNext)

        gameContinue()


        buttonOk.setOnClickListener {

            val input = textAnswer.text.toString()

            if(input == "")
            {
                Toast.makeText(applicationContext,"Please write an answer or click the next button", Toast.LENGTH_SHORT).show()
            }
            else
            {
                pauseTimer()
                val userAnswer = input.toInt()
                if(userAnswer == correctAnswer)
                {
                    userScore += 10
                    textQuestion.text = "Congratulations,your answer is correct"
                    textScore.text = userScore.toString()
                }
                else{


                     userLife--
                    textQuestion.text = "Sorry, yor answer is wrong"
                    textLife.text = userLife.toString()
                }
            }

        }
        buttonNext.setOnClickListener {


            pauseTimer()
            resetTimer()


           textAnswer.setText("")

            if(userLife == 0)
            {
                Toast.makeText(applicationContext,"Game over",Toast.LENGTH_LONG).show()
                val intent = Intent(this@GameActivity,ResultActivity::class.java)
                intent.putExtra("score",userScore)
                startActivity(intent)

                finish()
            }
            else
            {
                gameContinue()
            }
        }



    }

      private fun gameContinue() {
        val number1 = Random.nextInt(0,100)
        val number2 = Random.nextInt(0,100)

        textQuestion.text = "$number1 + $number2"

        correctAnswer = number1 + number2

          startTimer()


    }

    private fun startTimer()
    {
        timer = object: CountDownTimer(timeLeftInMillis,1000)

        {
            override fun onTick(millsUnitFinished: Long) {
                timeLeftInMillis = millsUnitFinished
                updateText()

            }

            override fun onFinish() {

                pauseTimer()
                resetTimer()
                updateText()

                userLife--
                textLife.text = userLife.toString()
                textQuestion.text = "Sorry,time is up!"


            }

        }.start()
    }
    private fun updateText()
    {
             val remainingTime : Int = (timeLeftInMillis / 1000).toInt()
        textTime.text = String.format(Locale.getDefault(),"%2d",remainingTime)
    }
    private fun pauseTimer()
    {
            timer.cancel()
    }
    private fun resetTimer()
    {
        timeLeftInMillis =  startTimerInMillis
        updateText()
    }

}