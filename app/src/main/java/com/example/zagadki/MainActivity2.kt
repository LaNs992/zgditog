package com.example.zagadki

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        stat1=findViewById(R.id.tetxStat4)
        stat2=findViewById(R.id.tetxStat6)
        stat1.text=intent.getStringExtra("tr")
        stat2.text=intent.getStringExtra("fl")
    }


    lateinit var stat1: TextView
    lateinit var stat2:TextView
    fun Poka(view: View){
       System.exit(0)
    }
}

