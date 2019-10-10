package com.example.kalkulator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //number
        satu.setOnClickListener {
            if(output.text.isNotEmpty()) {
                input.text = ""
                expression("1", true)
            } else {
            expression("1", true)}}
        dua.setOnClickListener { expression("2", true)}
        tiga.setOnClickListener { expression("3", true)}
        empat.setOnClickListener { expression("4", true)}
        lima.setOnClickListener { expression("5", true)}
        enam.setOnClickListener { expression("6", true)}
        tujuh.setOnClickListener { expression("7", true)}
        delapan.setOnClickListener { expression("8", true)}
        sembilan.setOnClickListener { expression("9", true)}
        nol.setOnClickListener { expression("0", true)}

        //non number
        koma.setOnClickListener { expression(".", true)}
        tambah.setOnClickListener { expression("+", true)}
        kurang.setOnClickListener { expression("-", true)}
        kali.setOnClickListener { expression("*", true)}
        bagi.setOnClickListener { expression("/", true)}
        bukaKurung.setOnClickListener { expression("(", true)}
        tutupKurung.setOnClickListener { expression(")", true)}
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