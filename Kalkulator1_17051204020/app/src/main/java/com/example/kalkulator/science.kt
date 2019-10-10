package com.example.kalkulator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.science.*
import net.objecthunter.exp4j.ExpressionBuilder

class science : common(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.science)

        //numbers
        n.setOnClickListener { appendOnExpresstion("1",true) }
        tw.setOnClickListener { appendOnExpresstion("2",true) }
        thr.setOnClickListener { appendOnExpresstion("3",true) }
        fr.setOnClickListener { appendOnExpresstion("4",true) }
        fv.setOnClickListener { appendOnExpresstion("5",true) }
        sx.setOnClickListener { appendOnExpresstion("6",true) }
        svn.setOnClickListener { appendOnExpresstion("7",true) }
        eght.setOnClickListener { appendOnExpresstion("8",true) }
        nn.setOnClickListener { appendOnExpresstion("9",true) }
        nl.setOnClickListener { appendOnExpresstion("0",true) }
        dt.setOnClickListener { Operator(".",true) }

        //operator
        pls.setOnClickListener { Operator("+", false)}
        mns.setOnClickListener { Operator("-", false)}
        kl.setOnClickListener { Operator("*", false)}
        bg.setOnClickListener { Operator("/", false)}
        op.setOnClickListener { Operator("(", false)}
        cl.setOnClickListener { Operator(")", false)}
        sin.setOnClickListener{ Operator("sin", false)}
        cos.setOnClickListener{ Operator("cos", false)}
        tan.setOnClickListener{ Operator("tan", false)}
        ln.setOnClickListener{ Operator("^", true)}
        lg.setOnClickListener{ Operator("log", false)}

        cl.setOnClickListener {
            dispFirst.text = ""
            dispSecond.text = ""
        }

        bck.setOnClickListener {
            val string = dispFirst.text.toString()
            if(string.isNotEmpty()){
                dispFirst.text = string.substring(0,string.length-1)
            }
            dispSecond.text = ""
        }

        eql.setOnClickListener {
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
}