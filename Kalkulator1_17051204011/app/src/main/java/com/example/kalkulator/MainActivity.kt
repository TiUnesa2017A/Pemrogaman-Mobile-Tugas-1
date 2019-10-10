package com.example.kalkulator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.biasa.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.biasa)

        tvSatu.setOnClickListener{appendOnOperasi("1", true)}
        tvDua.setOnClickListener{appendOnOperasi("2", true)}
        tvTiga.setOnClickListener{appendOnOperasi("3", true)}
        tvEmpat.setOnClickListener{appendOnOperasi("4", true)}
        tvLima.setOnClickListener{appendOnOperasi("5", true)}
        tvEnam.setOnClickListener{appendOnOperasi("6", true)}
        tvTujuh.setOnClickListener{appendOnOperasi("7", true)}
        tvDelapan.setOnClickListener{appendOnOperasi("8", true)}
        tvSembilan.setOnClickListener{appendOnOperasi("9", true)}
        tvNol.setOnClickListener{appendOnOperasi("0", true)}
        tvKoma.setOnClickListener{aturanPenulisan(".", true)}


        tvTambah.setOnClickListener{aturanPenulisan("+", false)}
        tvKurang.setOnClickListener{aturanPenulisan("-", false)}
        tvKali.setOnClickListener{aturanPenulisan("*", false)}
        tvBagi.setOnClickListener{aturanPenulisan("/", false)}
        tvOpen.setOnClickListener{appendOnOperasi("(", false)}
        tvClose.setOnClickListener{appendOnOperasi(")", false)}

        tvClear.setOnClickListener{
            tvHasil.text=""
            tvOperasi.text=""
        }
        tvBS.setOnClickListener{
            val string = tvOperasi.text.toString()
            if(string.isNotEmpty()){
                tvOperasi.text= string.substring(0,string.length-1)

            }
            tvHasil.text=""

        }
        tvSD.setOnClickListener{
            try {
                val operasi = ExpressionBuilder(tvOperasi.text.toString()).build()
                val hasil = operasi.evaluate()
                val longHasil = hasil.toLong()
                if(hasil == longHasil.toDouble())
                    tvHasil.text= longHasil.toString()
                else
                    tvHasil.text = hasil.toString()

            }catch (e:Exception){
                Log.d("Exception", " message"+e.message)
            }
        }
    }
    fun aturanPenulisan(string:String, cekKoma:Boolean){
        if(tvOperasi.text.toString().isNotEmpty()){
            val cekstr = tvOperasi.text.toString().substring(tvOperasi.text.toString().length - 1)
            if(cekKoma){
                if(cekstr=="+" || cekstr=="-" || cekstr=="*" || cekstr=="/"){
                    appendOnOperasi("0"+string, true)
                }else if(cekstr!=".")
                    appendOnOperasi(string, true)
            }else{
                if(cekstr=="+" || cekstr=="-" || cekstr=="*" || cekstr=="/"){
                    tvOperasi.text=tvOperasi.text.toString().substring(0,tvOperasi.text.toString().length-1)
                    appendOnOperasi(string, false)
                }else if (cekstr=="."){
                    appendOnOperasi("0"+string, false)
                }else
                    appendOnOperasi(string, false)
            }

        }else{
            if (cekKoma)
                appendOnOperasi("0"+string, true)
            else
                appendOnOperasi("0"+string, false)
        }
    }


    fun appendOnOperasi(string:String,canClear :Boolean){
        if(tvHasil.text.isNotEmpty()){
            tvOperasi.text=""
        }
        if (canClear){
            tvHasil.text=""
            tvOperasi.append(string)
        }else {
            tvOperasi.append(tvHasil.text)
            tvOperasi.append(string)
            tvHasil.text=""
        }
    }
}
