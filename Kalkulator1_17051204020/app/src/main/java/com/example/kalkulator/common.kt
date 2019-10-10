package com.example.kalkulator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.common.*
import net.objecthunter.exp4j.ExpressionBuilder

open class common : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.common)

        //numbers
        one.setOnClickListener { appendOnExpresstion("1",true) }
        two.setOnClickListener { appendOnExpresstion("2",true) }
        three.setOnClickListener { appendOnExpresstion("3",true) }
        four.setOnClickListener { appendOnExpresstion("4",true) }
        five.setOnClickListener { appendOnExpresstion("5",true) }
        six.setOnClickListener { appendOnExpresstion("6",true) }
        seven.setOnClickListener { appendOnExpresstion("7",true) }
        eight.setOnClickListener { appendOnExpresstion("8",true) }
        nine.setOnClickListener { appendOnExpresstion("9",true) }
        nol.setOnClickListener { appendOnExpresstion("0",true) }
        dot.setOnClickListener { Operator(".",true) }

        //operator
        plus.setOnClickListener { Operator("+", false)}
        minus.setOnClickListener { Operator("-", false)}
        kali.setOnClickListener { Operator("*", false)}
        bagi.setOnClickListener { Operator("/", false)}
        open.setOnClickListener { Operator("(", false)}
        close.setOnClickListener { Operator(")", false)}

        clear.setOnClickListener {
            dispFirst.text = ""
            dispSecond.text = ""
        }

        back.setOnClickListener {
            val string = dispFirst.text.toString()
            if(string.isNotEmpty()){
                dispFirst.text = string.substring(0,string.length-1)
            }
            dispSecond.text = ""
        }

        equal.setOnClickListener {
            try {
                val expression = ExpressionBuilder(dispFirst.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if(result == longResult.toDouble())
                    dispSecond.text = longResult.toString()
                else
                    dispSecond.text = result.toString()

            }catch (e:Exception){
                Log.d("Exception"," message : " + e.message )
            }
        }
    }

    fun appendOnExpresstion(string: String, canClear: Boolean) {

        if(dispSecond.text.isNotEmpty()){
            dispFirst.text = ""
        }

        if (canClear) {
            dispSecond.text = ""
            dispFirst.append(string)
        } else {
            dispFirst.append(dispSecond.text)
            dispFirst.append(string)
            dispSecond.text = ""
        }
    }

    fun Operator(string: String, cekKoma: Boolean){
        if(dispFirst.text.toString().isNotEmpty()){
            val ckStr = dispFirst.text.toString().substring(dispFirst.text.toString().length-1)
            if(cekKoma){
                if(ckStr=="+"||ckStr=="-"||ckStr=="*"||ckStr=="/"){
                    appendOnExpresstion(string, true)
                }
                else if (ckStr!="."){
                    appendOnExpresstion(string, true)
                }
            }
            else{
                if(ckStr=="+"||ckStr=="-"||ckStr=="*"||ckStr=="/"){
                    dispFirst.text = dispFirst.text.toString().substring(0,dispFirst.text.toString().length-1)
                    appendOnExpresstion(string, true)
                }
                else if (ckStr!="."){
                    appendOnExpresstion(string, true)
                }
                else{
                    appendOnExpresstion(string, true)
                }
            }
        }
        else{
            if(cekKoma){
                appendOnExpresstion("0"+string, true)
            }
            else{
                appendOnExpresstion(string, true)
            }
        }
    }
}