package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() , View.OnClickListener {
    override fun onClick(view: View?) {
        when(view){
            cv0 -> createExpression(zero.text as String,true)
            cv1 -> createExpression(one.text as String,true)
            cv2 -> createExpression(two.text as String,true)
            cv3 -> createExpression(three.text as String,true)
            cv4 -> createExpression(four.text as String,true)
            cv5 -> createExpression(five.text as String,true)
            cv6 -> createExpression(six.text as String,true)
            cv7 -> createExpression(seven.text as String,true)
            cv8 -> createExpression(eight.text as String,true)
            cv9 -> createExpression(nine.text as String,true)

            cvBK -> createExpression(openBracket.text as String,false)
            cvTK -> createExpression(closeBracket.text as String,false)
            cvBagi -> createExpression(divide.text as String,false)
            cvKali -> createExpression(multiply.text as String,false)
            cvTambah -> createExpression(plus.text as String,false)
            cvKurang -> createExpression(minus.text as String,false)

            cvTitik -> createExpression(dot.text as String,false)

            cvEqual -> calculate()
            cvCE -> clearExp()
            cvBackSpace -> backSpace()







        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun createExpression (string :String, canClear : Boolean) {
        if(tvResult.text.isNotEmpty()){
            tvExp.text=""
        }
        if (canClear){
            tvResult.text="";
            tvExp.append(string)
        }else{
            tvExp.append(tvResult.text)
            tvExp.append(string)
            tvResult.text=""
        }
    }
    fun clearExp(){
        tvExp.text=""
        tvResult.text=""

    }
    fun backSpace(){
        val string = tvExp.text.toString()
        if(string.isNotEmpty()){
            tvExp.text = string.substring(0,string.length-1)
        }
        tvResult.text=""
    }
    fun calculate(){
        try {
            val exp = ExpressionBuilder(tvExp.text.toString()).build()
            val result = exp.evaluate()
            val longResult = result.toLong()
            if(result==longResult.toDouble()){
                tvResult.text=longResult.toString()
            }else{
                tvResult.text=result.toString()
            }
        }catch (e:Exception){
            Log.i("error : ",e.message);
        }
    }
}
