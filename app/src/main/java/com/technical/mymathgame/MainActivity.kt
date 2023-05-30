package com.technical.mymathgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent

lateinit var addition : Button
lateinit var subtraction : Button
lateinit var multiplication : Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addition = findViewById(R.id.buttonAdd)
        subtraction = findViewById(R.id.buttonSub)
        multiplication = findViewById(R.id.buttonMulti)


        addition.setOnClickListener {
           val intent = Intent(this@MainActivity,GameActivity::class.java)
            startActivity(intent)
        }
    }
}