package com.example.kalkulator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

open class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(titleBar)

        //number
        satu.setOnClickListener {
            if(output.text.isNotEmpty()) {
                input.text = ""
                expression("1", true)
            } else {
            expression("1", true)}}
        dua.setOnClickListener {
            if(output.text.isNotEmpty()) {
                input.text = ""
                expression("2", true)
            } else {
                expression("2", true)}}
        tiga.setOnClickListener {
            if(output.text.isNotEmpty()) {
                input.text = ""
                expression("3", true)
            } else {
                expression("3", true)}}
        empat.setOnClickListener {
            if(output.text.isNotEmpty()) {
            input.text = ""
            expression("4", true)
        } else {
            expression("4", true)}}
        lima.setOnClickListener {
            if(output.text.isNotEmpty()) {
            input.text = ""
            expression("5", true)
        } else {
            expression("5", true)}}
        enam.setOnClickListener {
            if(output.text.isNotEmpty()) {
                input.text = ""
                expression("6", true)
            } else {
                expression("6", true)}}
        tujuh.setOnClickListener {
            if(output.text.isNotEmpty()) {
            input.text = ""
            expression("7", true)
        } else {
            expression("7", true)}}
        delapan.setOnClickListener {
            if(output.text.isNotEmpty()) {
            input.text = ""
            expression("8", true)
        } else {
            expression("8", true)}}
        sembilan.setOnClickListener {
            if(output.text.isNotEmpty()) {
                input.text = ""
                expression("9", true)
            } else {
                expression("9", true)}}
        nol.setOnClickListener {
            if(output.text.isNotEmpty()) {
            input.text = ""
            expression("0", true)
        } else {
            expression("0", true)}}

        //non number
        koma.setOnClickListener { expression(".", true)}
        tambah.setOnClickListener { expression("+", true)}
        kurang.setOnClickListener { expression("-", true)}
        kali.setOnClickListener { expression("*", true)}
        bagi.setOnClickListener { expression("/", true)}
        kosong.setOnClickListener {
            input.text = ""
            output.text = ""
        }
        hapus.setOnClickListener {
            val string = input.text.toString()
            if(string.isNotEmpty()) {
                input.text = string.substring(0, string.length - 1)
            }
            output.text = ""
        }
        samaDengan.setOnClickListener {
            try {
                val expression = ExpressionBuilder(input.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if(result == longResult.toDouble()) {
                    output.text = input.getText().toString()
                    input.text = longResult.toString()
                } else {
                    output.text = input.getText().toString()
                    input.text = result.toString()
                }
            } catch(ex:Exception) {
                Log.d("Exception", "message : " + ex.message)
            }
        }
    }

    fun expression(string: String, canClear: Boolean) {
        if(canClear) {
            output.text = ""
            input.append(string)
        } else {
            input.append(output.text)
            input.append(string)
            output.text = ""
        }
    }
}