package com.technical.mymathgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.content.Intent


class ResultActivity : AppCompatActivity() {

    lateinit var result : TextView
    lateinit var playAgain : Button
    lateinit var exit : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        result = findViewById(R.id.textViewResults)
        playAgain = findViewById(R.id.buttonAgain)
        exit = findViewById(R.id.buttonExit)

        val score = intent.getIntExtra("score",0)
        result.text = "Your score :" + score

        playAgain.setOnClickListener {
            val intent = Intent(this@ResultActivity,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        exit.setOnClickListener {

            //standard code to close an application
            val intent = Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_HOME)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }

    }
}