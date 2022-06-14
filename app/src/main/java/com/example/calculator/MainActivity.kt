package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    var temp_no: String = ""
    var operator_flag : Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var num : String

        val btn_one: Button = findViewById(R.id.btn_One)
        val btn_two: Button = findViewById(R.id.btn_Two)
        val btn_three: Button = findViewById(R.id.btn_Three)
        val btn_four: Button = findViewById(R.id.btn_Four)
        val btn_five: Button = findViewById(R.id.btn_Five)
        val btn_six: Button = findViewById(R.id.btn_Six)
        val btn_seven: Button = findViewById(R.id.btn_Seven)
        val btn_eight: Button = findViewById(R.id.btn_Eight)
        val btn_nine: Button = findViewById(R.id.btn_Nine)
        val btn_zero: Button = findViewById(R.id.btn_Zero)

        val btn_plus: Button = findViewById(R.id.btn_Plus)
        val btn_minus: Button = findViewById(R.id.btn_Minus)
        val btn_mul: Button = findViewById(R.id.btn_Mul)
        val btn_div: Button = findViewById(R.id.btn_Divide)

        val btn_clear: Button = findViewById(R.id.btn_Clear)
        val btn_equalTo: Button = findViewById(R.id.btn_Equals)

        val tv_expression: TextView = findViewById(R.id.tvExpression)
        val tv_result: TextView = findViewById(R.id.tvResult)

        // all number button on click listners 0..9
        btn_one.setOnClickListener {
            num = btn_one.text.toString()
            operator_flag = false
            appendLast(num, tv_expression)
        }
        btn_two.setOnClickListener {
            num = btn_two.text.toString()
            operator_flag = false
            appendLast(num, tv_expression)
        }
        btn_three.setOnClickListener {
            num = btn_three.text.toString()
            operator_flag = false
            appendLast(num, tv_expression)
        }
        btn_four.setOnClickListener {
            num = btn_four.text.toString()
            operator_flag = false
            appendLast(num, tv_expression)
        }
        btn_five.setOnClickListener {
            num = btn_five.text.toString()
            operator_flag = false
            appendLast(num, tv_expression)
        }
        btn_six.setOnClickListener {
            num = btn_six.text.toString()
            operator_flag = false
            appendLast(num, tv_expression)
        }
        btn_seven.setOnClickListener {
            num = btn_seven.text.toString()
            operator_flag = false
            appendLast(num, tv_expression)
        }
        btn_eight.setOnClickListener {
            num = btn_eight.text.toString()
            operator_flag = false
            appendLast(num, tv_expression)
        }
        btn_nine.setOnClickListener {
            num = btn_nine.text.toString()
            operator_flag = false
            appendLast(num, tv_expression)
        }
        btn_zero.setOnClickListener {
            num = btn_zero.text.toString()
            operator_flag = false
            appendLast(num, tv_expression)
        }

        // action buttons onclicklistners
        btn_plus.setOnClickListener {
            num = btn_plus.text.toString()
            actionBtn_condition_checks(num,operator_flag,tv_expression)

        }
        btn_minus.setOnClickListener {
            num = btn_minus.text.toString()
            actionBtn_condition_checks(num,operator_flag,tv_expression)
        }
        btn_mul.setOnClickListener {
            num = btn_mul.text.toString()
            if(!tv_expression.text.toString().isEmpty()) {
                actionBtn_condition_checks(num,operator_flag,tv_expression)
            }
        }
        btn_div.setOnClickListener {
            num = btn_div.text.toString()
            if(!tv_expression.text.toString().isEmpty()){
                actionBtn_condition_checks(num,operator_flag,tv_expression)
            }
        }

        // equals button onclickListner
        btn_equalTo.setOnClickListener {
            val expression = ExpressionBuilder(tv_expression.text.toString()).build()
            try {
                val result = expression.evaluate().toString()
                tv_result.setText(result)
            }catch (ex: Exception){
                tv_result.setText("Error")
            }
        }


    }

    private fun actionBtn_condition_checks(num: String, operatorFlag: Boolean, tvExpression: TextView) {
        if(!operator_flag){
            appendLast(num,tvExpression)
            operator_flag = true
        }else{
            var temp_str = tvExpression.text.toString().substring(0,tvExpression.text.toString().length - 1)
            temp_str = temp_str + num
            tvExpression.setText(temp_str)
        }
    }

    private fun appendLast(num: String, tvExpression: TextView) {
        if (tvExpression.text.toString().isEmpty()) {
            tvExpression.setText(num)
        } else {
            tvExpression.setText(tvExpression.text.toString() + num)
        }
    }
}