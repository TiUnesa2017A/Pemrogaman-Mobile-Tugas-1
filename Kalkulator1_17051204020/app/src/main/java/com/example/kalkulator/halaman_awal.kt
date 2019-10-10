package com.example.kalkulator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class halaman_awal : AppCompatActivity(){
    private lateinit var button: Button
    private lateinit var button1: Button
    private lateinit var button2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.halaman_awal)
        button = findViewById(R.id.com)
        button1 = findViewById(R.id.scien)
        button2 = findViewById(R.id.biner)
        button.setOnClickListener {
            startActivity(Intent(this, common::class.java))
        }
        button1.setOnClickListener {
            startActivity(Intent(this, science::class.java))
        }
        button2.setOnClickListener {
            startActivity(Intent(this, biner::class.java))
        }
    }
}