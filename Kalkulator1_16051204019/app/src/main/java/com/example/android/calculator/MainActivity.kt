package com.example.android.calculator

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.HorizontalScrollView
import android.widget.TextView
import android.widget.Toast

import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder

import android.graphics.Color.rgb


class MainActivity : AppCompatActivity() {

    internal var numberDisplay: TextView
    internal var operationsDisplay: TextView
    internal var scrollerDisplayNumber: HorizontalScrollView
    internal var scrollerDisplayOperations: HorizontalScrollView
    internal var button1: Button
    internal var button2: Button
    internal var button3: Button
    internal var button4: Button
    internal var button5: Button
    internal var button6: Button
    internal var button7: Button
    internal var button8: Button
    internal var button9: Button
    internal var button0: Button
    internal var buttonCE: Button
    internal var buttonRoot: Button
    internal var buttonSin: Button
    internal var buttonCos: Button
    internal var buttonBracketsOpen: Button
    internal var buttonBracketsClose: Button
    internal var buttonTan: Button
    internal var buttonPI: Button
    internal var buttonExponentation: Button
    internal var buttonSum: Button
    internal var buttonSubtraction: Button
    internal var buttonMultiplication: Button
    internal var buttonDivision: Button
    internal var buttonEqual: Button
    internal var stringNumber: String
    internal var stringSpecial: String
    internal var expression: Expression
    internal var value = 0.0
    internal var numberClicked = false
    internal var clipboard: ClipboardManager
    internal var clip: ClipData
    internal var charBracketOpenCount = 0
    internal var charBracketCloseCount = 0
    internal var charInExceed = 0
    internal var dotCount = 0
    internal var bracketOpen = '('
    internal var bracketClose = ')'

    @Override
    protected fun onCreate(savedInstanceState: Bundle) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numberDisplay = findViewById(R.id.displayNumber) as TextView
        operationsDisplay = findViewById(R.id.displayOperationNumber) as TextView
        scrollerDisplayNumber = findViewById(R.id.displayNumberScroller) as HorizontalScrollView
        scrollerDisplayOperations = findViewById(R.id.displayOperationNumberScroller) as HorizontalScrollView
        button1 = findViewById(R.id.button1) as Button
        button2 = findViewById(R.id.button2) as Button
        button3 = findViewById(R.id.button3) as Button
        button4 = findViewById(R.id.button4) as Button
        button5 = findViewById(R.id.button5) as Button
        button6 = findViewById(R.id.button6) as Button
        button7 = findViewById(R.id.button7) as Button
        button8 = findViewById(R.id.button8) as Button
        button9 = findViewById(R.id.button9) as Button
        button0 = findViewById(R.id.button0) as Button
        buttonCE = findViewById(R.id.buttonCE) as Button
        buttonRoot = findViewById(R.id.buttonRoot) as Button
        buttonSin = findViewById(R.id.buttonSin) as Button
        buttonCos = findViewById(R.id.buttonCos) as Button
        buttonBracketsOpen = findViewById(R.id.buttonBracketsOpen) as Button
        buttonBracketsClose = findViewById(R.id.buttonBracketsClose) as Button
        buttonTan = findViewById(R.id.buttonTan) as Button
        buttonPI = findViewById(R.id.buttonPI) as Button
        buttonExponentation = findViewById(R.id.buttonExponentation) as Button
        buttonSum = findViewById(R.id.buttonSum) as Button
        buttonSubtraction = findViewById(R.id.buttonSubtraction) as Button
        buttonMultiplication = findViewById(R.id.buttonMultiplication) as Button
        buttonDivision = findViewById(R.id.buttonDivision) as Button
        buttonEqual = findViewById(R.id.buttonEqaul) as Button

        getSupportActionBar().setElevation(0)

        clickButtonCE()


    }

    @Override
    protected fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        stringSpecial = numberDisplay.getText().toString()
        outState.putString("numberDisplay", stringSpecial)

        stringSpecial = operationsDisplay.getText().toString()
        outState.putString("operationsDisplay", stringSpecial)

        outState.putDouble("resultValue", value)

        outState.putBoolean("numberClicked", numberClicked)

        outState.putInt("bracketOpenCount", charBracketOpenCount)
        outState.putInt("bracketCloseCOunt", charBracketCloseCount)
        outState.putInt("charInExceed", charInExceed)
        outState.putInt("dotCount", dotCount)
    }

    @Override
    protected fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        numberDisplay.setText(savedInstanceState.getString("numberDisplay"))
        operationsDisplay.setText(savedInstanceState.getString("operationsDisplay"))

        value = savedInstanceState.getDouble("resultValue")

        numberClicked = savedInstanceState.getBoolean("numberClicked")

        charBracketOpenCount = savedInstanceState.getInt("bracketOpenCount")
        charBracketCloseCount = savedInstanceState.getInt("bracketCloseCount")
        charInExceed = savedInstanceState.getInt("charInExceed")
        dotCount = savedInstanceState.getInt("dotCount")
    }

    fun clickButton1(v: View) {

        numberDisplay.setText(numberDisplay.getText() + "1")
        operationsDisplay.setText(operationsDisplay.getText() + "1")
        numberClicked = true
    }

    fun clickButton2(v: View) {

        numberDisplay.setText(numberDisplay.getText() + "2")
        operationsDisplay.setText(operationsDisplay.getText() + "2")
        numberClicked = true
    }

    fun clickButton3(v: View) {

        numberDisplay.setText(numberDisplay.getText() + "3")
        operationsDisplay.setText(operationsDisplay.getText() + "3")
        numberClicked = true
    }

    fun clickButton4(v: View) {

        numberDisplay.setText(numberDisplay.getText() + "4")
        operationsDisplay.setText(operationsDisplay.getText() + "4")
        numberClicked = true
    }

    fun clickButton5(v: View) {

        numberDisplay.setText(numberDisplay.getText() + "5")
        operationsDisplay.setText(operationsDisplay.getText() + "5")
        numberClicked = true
    }

    fun clickButton6(v: View) {

        numberDisplay.setText(numberDisplay.getText() + "6")
        operationsDisplay.setText(operationsDisplay.getText() + "6")
        numberClicked = true
    }

    fun clickButton7(v: View) {

        numberDisplay.setText(numberDisplay.getText() + "7")
        operationsDisplay.setText(operationsDisplay.getText() + "7")
        numberClicked = true
    }

    fun clickButton8(v: View) {

        numberDisplay.setText(numberDisplay.getText() + "8")
        operationsDisplay.setText(operationsDisplay.getText() + "8")
        numberClicked = true
    }

    fun clickButton9(v: View) {

        numberDisplay.setText(numberDisplay.getText() + "9")
        operationsDisplay.setText(operationsDisplay.getText() + "9")
        numberClicked = true
    }

    fun clickButton0(v: View) {

        numberDisplay.setText(numberDisplay.getText() + "0")
        operationsDisplay.setText(operationsDisplay.getText() + "0")
        numberClicked = true
    }

    fun clickButtonDot(v: View) {

        stringSpecial = operationsDisplay.getText().toString()

        if (numberClicked == false) {

        } else if (stringSpecial.endsWith("(") || stringSpecial.endsWith("+") || stringSpecial.endsWith("-") || stringSpecial.endsWith("*") || stringSpecial.endsWith("/")) {

        } else {
            if (dotCount == 1) {

            } else {
                dotCount++
                operationsDisplay.setText(operationsDisplay.getText() + ".")
                stringSpecial = numberDisplay.getText().toString()
                if (!stringSpecial.contains(".")) {
                    numberDisplay.setText(numberDisplay.getText() + ".")
                }
            }
        }
    }

    fun clickButtonBracketsOpen(v: View) {

        numberDisplay.setText(numberDisplay.getText() + "(")
        operationsDisplay.setText(operationsDisplay.getText() + "(")
        dotCount = 0
        numberClicked = false
    }

    fun clickButtonBracketsClose(v: View) {

        stringSpecial = operationsDisplay.getText().toString()

        if (stringSpecial.isEmpty()) {

        } else if (stringSpecial.substring(stringSpecial.length() - 1).equals("(")) {

        } else if (stringSpecial.substring(stringSpecial.length() - 1).equals("+") ||
                stringSpecial.substring(stringSpecial.length() - 1).equals("-") ||
                stringSpecial.substring(stringSpecial.length() - 1).equals("*") ||
                stringSpecial.substring(stringSpecial.length() - 1).equals("/")) {

        } else if (!stringSpecial.contains("(")) {

        } else {
            operationsDisplay.setText(operationsDisplay.getText() + ")")
            numberDisplay.setText(numberDisplay.getText() + ")")
            dotCount = 0
        }
    }

    fun clickButtonExponentation(view: View) {

        stringSpecial = numberDisplay.getText().toString()
        if (numberClicked == false) {

        } else if (stringSpecial.endsWith("^")) {

        } else {
            numberDisplay.setText(numberDisplay.getText() + "^")
            operationsDisplay.setText(operationsDisplay.getText() + "^")

        }

    }

    fun clickButtonSquareRoot(v: View) {

        numberDisplay.setText(numberDisplay.getText() + "√(")
        operationsDisplay.setText(operationsDisplay.getText() + "sqrt(")
        numberClicked = false
        charBracketOpenCount = 0
        charBracketCloseCount = 0
        charInExceed = 0
        dotCount = 0

    }

    fun clickButtonSin(v: View) {
        numberDisplay.setText(numberDisplay.getText() + "sin(")
        operationsDisplay.setText(operationsDisplay.getText() + "sin(")
        numberClicked = false
        charBracketOpenCount = 0
        charBracketCloseCount = 0
        charInExceed = 0
        dotCount = 0
    }

    fun clickButtonCos(v: View) {

        numberDisplay.setText(numberDisplay.getText() + "cos(")
        operationsDisplay.setText(operationsDisplay.getText() + "cos(")
        numberClicked = false
        charBracketOpenCount = 0
        charBracketCloseCount = 0
        charInExceed = 0
        dotCount = 0
    }

    fun clickButtonTan(v: View) {

        numberDisplay.setText(numberDisplay.getText() + "tan(")
        operationsDisplay.setText(operationsDisplay.getText() + "tan(")
        numberClicked = false
        charBracketOpenCount = 0
        charBracketCloseCount = 0
        charInExceed = 0
        dotCount = 0
    }

    fun clickButtonPI(v: View) {

        numberDisplay.setText(numberDisplay.getText() + "π")
        operationsDisplay.setText(operationsDisplay.getText() + "π")
        numberClicked = true

    }

    fun clickButtonAddition(v: View) {

        checkNumberDisplay()

        stringSpecial = operationsDisplay.getText().toString()

        if (stringSpecial.isEmpty()) {

        } else if (stringSpecial.charAt(stringSpecial.length() - 1) === '+' || stringSpecial.charAt(stringSpecial.length() - 1) === '-' || stringSpecial.charAt(stringSpecial.length() - 1) === '*' || stringSpecial.charAt(stringSpecial.length() - 1) === '/') {

        } else {
            buttonCE.setText("DEL")
            operationsDisplay.setText(operationsDisplay.getText() + "+")
            numberDisplay.setText(null)
            numberClicked = false
            charBracketCloseCount = 0
            charBracketCloseCount = 0
            charBracketOpenCount = 0
            dotCount = 0

        }


    }

    fun clickButtonSubtraction(v: View) {

        checkNumberDisplay()

        stringSpecial = operationsDisplay.getText().toString()

        if (stringSpecial.endsWith("sqrt(")) {

        } else {
            buttonCE.setText("DEL")
            operationsDisplay.setText(operationsDisplay.getText() + "-")
            numberDisplay.setText("-")
            numberClicked = false
            charBracketCloseCount = 0
            charBracketCloseCount = 0
            charBracketOpenCount = 0
            dotCount = 0
        }

    }

    fun clickButtonMultiplication(v: View) {

        checkNumberDisplay()


        stringSpecial = operationsDisplay.getText().toString()

        if (stringSpecial.isEmpty()) {

        } else if (stringSpecial.charAt(stringSpecial.length() - 1) === '(') {

        } else if (stringSpecial.charAt(stringSpecial.length() - 1) === '+' || stringSpecial.charAt(stringSpecial.length() - 1) === '-' || stringSpecial.charAt(stringSpecial.length() - 1) === '*' || stringSpecial.charAt(stringSpecial.length() - 1) === '/') {

        } else {
            buttonCE.setText("DEL")
            operationsDisplay.setText(operationsDisplay.getText() + "*")
            numberDisplay.setText(null)
            numberClicked = false
            charBracketCloseCount = 0
            charBracketCloseCount = 0
            charBracketOpenCount = 0
            dotCount = 0
        }
    }

    fun clickButtonDivision(v: View) {

        checkNumberDisplay()

        stringSpecial = operationsDisplay.getText().toString()

        if (stringSpecial.isEmpty()) {

        } else if (stringSpecial.charAt(stringSpecial.length() - 1) === '(') {

        } else if (stringSpecial.charAt(stringSpecial.length() - 1) === '+' || stringSpecial.charAt(stringSpecial.length() - 1) === '-' || stringSpecial.charAt(stringSpecial.length() - 1) === '*' || stringSpecial.charAt(stringSpecial.length() - 1) === '/') {

        } else {
            numberClicked = false
            buttonCE.setText("DEL")
            operationsDisplay.setText(operationsDisplay.getText() + "/")
            numberDisplay.setText(null)
            numberClicked = false
            charBracketCloseCount = 0
            charBracketCloseCount = 0
            charBracketOpenCount = 0
            dotCount = 0
        }
    }

    fun checkNumberDisplay() {
        stringSpecial = numberDisplay.getText().toString()
        if (Double.toString(value).equals(stringSpecial)) {
            operationsDisplay.setText(stringSpecial)
        }
    }

    fun checkBracketsNumber() {

        charBracketCloseCount = 0
        charBracketOpenCount = 0
        charInExceed = 0

        for (i in 0 until stringNumber.length()) {
            if (stringNumber.charAt(i) === bracketOpen)
                charBracketOpenCount++
            else if (stringNumber.charAt(i) === bracketClose)
                charBracketCloseCount++
        }

        if (charBracketOpenCount == charBracketCloseCount) {

        } else if (charBracketOpenCount > charBracketCloseCount) {
            charInExceed = charBracketOpenCount - charBracketCloseCount

            for (j in 0 until charInExceed) {
                stringNumber = "$stringNumber)"
            }
        }
    }

    fun clickButtonEqual(v: View) {

        if (numberClicked == false) {

        } else {

            stringNumber = operationsDisplay.getText().toString()

            checkBracketsNumber()

            if (charBracketCloseCount > charBracketOpenCount) {
                numberDisplay.setText("Invalid expression")
            } else if (stringNumber.contains("Infinity")) {
                numberDisplay.setText("Infinity")
            } else {

                expression = ExpressionBuilder(stringNumber).build()

                try {
                    value = expression.evaluate()
                    numberDisplay.setText(Double.toString(value))
                } catch (e: ArithmeticException) {
                    numberDisplay.setText("Can't divide by 0")
                }

                buttonCE.setText("CLR")
            }
        }

    }

    fun clickNumberDisplay(v: View) {

        clipboard = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
        clip = ClipData.newPlainText("number", numberDisplay.getText().toString())
        clipboard.setPrimaryClip(clip)
        Toast.makeText(this@MainActivity, "Copied result to clipboard", Toast.LENGTH_SHORT).show()
    }

    fun clickOperationsDisplay(v: View) {

        clipboard = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
        clip = ClipData.newPlainText("operations", operationsDisplay.getText().toString())
        clipboard.setPrimaryClip(clip)
        Toast.makeText(this@MainActivity, "Copied operations to clipboard", Toast.LENGTH_SHORT).show()
    }

    fun clickButtonCE() {

        buttonCE.setOnClickListener(object : View.OnClickListener() {
            @Override
            fun onClick(view: View) {

                stringSpecial = operationsDisplay.getText().toString()

                if (!stringSpecial.isEmpty()) {

                    if (Double.toString(value).equals(numberDisplay.getText().toString())) {

                    } else if (stringSpecial.endsWith("sin(") || stringSpecial.endsWith("cos(") || stringSpecial.endsWith("tan(")) {
                        stringSpecial = stringSpecial.substring(0, stringSpecial.length() - 4)
                        operationsDisplay.setText(stringSpecial)
                    } else if (stringSpecial.endsWith(".")) {
                        dotCount = 0
                        stringSpecial = stringSpecial.substring(0, stringSpecial.length() - 1)
                        operationsDisplay.setText(stringSpecial)

                    } else {
                        stringSpecial = stringSpecial.substring(0, stringSpecial.length() - 1)
                        operationsDisplay.setText(stringSpecial)
                        numberClicked = false
                        if (stringSpecial.endsWith("1") || stringSpecial.endsWith("2") || stringSpecial.endsWith("3") || stringSpecial.endsWith("4") || stringSpecial.endsWith("5") || stringSpecial.endsWith("6") || stringSpecial.endsWith("7") || stringSpecial.endsWith("8") || stringSpecial.endsWith("9") || stringSpecial.endsWith("0") || stringSpecial.endsWith(")")) {
                            numberClicked = true
                        }
                    }
                }

                stringSpecial = numberDisplay.getText().toString()

                if (!stringSpecial.isEmpty()) {

                    if (Double.toString(value).equals(numberDisplay.getText().toString())) {

                    } else if (stringSpecial.equals("Invalid expression") || stringSpecial.equals("Can't divide by 0")) {

                    } else if (stringSpecial.endsWith("sin(") || stringSpecial.endsWith("cos(") || stringSpecial.endsWith("tan(")) {
                        stringSpecial = stringSpecial.substring(0, stringSpecial.length() - 4)
                        numberDisplay.setText(stringSpecial)
                    } else if (stringSpecial.endsWith("√(")) {
                        stringSpecial = stringSpecial.substring(0, stringSpecial.length() - 2)
                        numberDisplay.setText(stringSpecial)
                    } else {

                        stringSpecial = stringSpecial.substring(0, stringSpecial.length() - 1)
                        numberDisplay.setText(stringSpecial)
                    }
                }

            }
        })


        buttonCE.setOnLongClickListener(object : View.OnLongClickListener() {
            @Override
            fun onLongClick(view: View): Boolean {
                numberDisplay.setText(null)
                operationsDisplay.setText(null)
                stringNumber = ""
                stringSpecial = ""
                value = 0.0
                numberClicked = false
                charBracketCloseCount = 0
                charBracketOpenCount = 0
                charInExceed = 0
                dotCount = 0
                buttonCE.setText("DEL")
                return true
            }
        })
    }

}
