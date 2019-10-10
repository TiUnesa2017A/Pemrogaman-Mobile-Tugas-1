package com.example.kalkulator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.lang.Math
import kotlinx.android.synthetic.main.biner.*

open class biner : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.biner)

        nol.setOnClickListener{convert(0)}
        one.setOnClickListener{convert(1)}
        two.setOnClickListener{convert(2)}
        three.setOnClickListener{convert(3)}
        four.setOnClickListener{convert(4)}
        five.setOnClickListener{convert(5)}
        six.setOnClickListener{convert(6)}
        seven.setOnClickListener{convert(7)}
        eight.setOnClickListener{convert(8)}
        nine.setOnClickListener{convert(9)}
        clear.setOnClickListener {
            dispFirst.text = ""
            dispBin.text = ""
            dispOkt.text = ""
            dispHex.text = ""
        }

        back.setOnClickListener {
            val string = dispFirst.text.toString()
            if(string.isNotEmpty()) {
                dispFirst.text = string.substring(0, string.length - 1)
                val y = dispFirst.text.toString()
                if(y.isNotEmpty()){
                    convertBin(y.toInt())
                    convertOkt(y.toInt())
                    convertHex(y.toInt())
                }
                else{
                    dispBin.text = ""
                    dispOkt.text = ""
                    dispHex.text = ""
                }
            }
        }
    }

    fun convertBin(number: Int){
        var rem: Int
        var nu: Int
        nu = number
        while(nu > 0) {
            rem = nu % 2
            dispBin.append(rem.toString())
            nu /= 2
        }
    }

    fun convertOkt(number: Int){
        var rem: Int
        var nu: Int
        var ha: String=""
        nu = number
        while(nu > 0){
            rem = nu % 8
            ha += rem.toString()
            nu /= 8
        }
        dispOkt.text = ha.substring(0, ha.length - 1).reversed()
    }

    fun convertHex(number: Int){
        var rem: Int
        var nu: Int
        var hexa: String=""
        nu = number
        while(nu > 0){
            rem = nu % 16
            nu /= 16
            when(rem){
                0 -> hexa+="0"
                1 -> hexa+="1"
                2 -> hexa+="2"
                3 -> hexa+="3"
                4 -> hexa+="4"
                5 -> hexa+="5"
                6 -> hexa+="6"
                7 -> hexa+="7"
                8 -> hexa+="8"
                9 -> hexa+="9"
                10 -> hexa+="A"
                11 -> hexa+="B"
                12 -> hexa+="C"
                13 -> hexa+="D"
                14 -> hexa+="E"
                15 -> hexa+="F"

            }
            dispHex.text = hexa.toString()
        }
    }

    fun convert(number: Int){
        dispFirst.append(number.toString())
        var x: Int
        x = dispFirst.text.toString().toInt()
        convertBin(x)
        convertOkt(x)
        convertHex(x)
    }
}