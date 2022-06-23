package jay.learning.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import jay.learning.calculator.R
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    var temp_no: String = ""
    var operator_flag: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var num: String

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

        val btn_dot: Button = findViewById(R.id.btn_Dot)

        val btn_clear: Button = findViewById(R.id.btn_Clear)
        val btn_del: Button = findViewById(R.id.btn_Back)
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

        btn_dot.setOnClickListener {
            num = btn_dot.text.toString()
            operator_flag = false
            appendLast(num, tv_expression)
        }

        // action buttons onclicklistners
        btn_plus.setOnClickListener {
            num = btn_plus.text.toString()
            if (tv_expression.text.toString().isNotEmpty()) {
                actionBtn_condition_checks(num, operator_flag, tv_expression)
            }
        }
        btn_minus.setOnClickListener {
            num = btn_minus.text.toString()
            if (tv_expression.text.toString().isNotEmpty()) {
                actionBtn_condition_checks(num, operator_flag, tv_expression)
            }
        }
        btn_mul.setOnClickListener {
            num = btn_mul.text.toString()
            if (tv_expression.text.toString().isNotEmpty()) {
                actionBtn_condition_checks(num, operator_flag, tv_expression)
            }
        }
        btn_div.setOnClickListener {
            num = btn_div.text.toString()
            if (tv_expression.text.toString().isNotEmpty()) {
                actionBtn_condition_checks(num, operator_flag, tv_expression)
            }
        }

        // equals button onclickListner
        btn_equalTo.setOnClickListener {
            if (tv_expression.text.isNotEmpty()) {
                val expression = ExpressionBuilder(tv_expression.text.toString()).build()
                try {
                    val result = expression.evaluate().toString()
                    tv_result.text = result
                } catch (ex: Exception) {
                    tv_result.text = "Error"
                }
            }
        }

        // clear and delete button
        btn_clear.setOnClickListener {
            tv_expression.text = ""
            tv_result.text = ""
            operator_flag = false
        }

        btn_del.setOnClickListener {
            if (tv_expression.text.isNotEmpty()) {
                try {
                    var new_Tempstr = tv_expression.text.toString()
                        .substring(0, tv_expression.text.toString().length - 1)
                    tv_expression.text = new_Tempstr
                    operator_flag = !new_Tempstr.get(new_Tempstr.length - 1).isDigit()
                } catch (ex: Exception) {
                    tv_expression.text = ""
                    operator_flag = false
                }
            }
        }
    }

    private fun actionBtn_condition_checks(num: String, operatorFlag: Boolean, tvExpression: TextView) {
        if (!operator_flag) {
            appendLast(num, tvExpression)
            operator_flag = true
        } else {
            var temp_str =
                tvExpression.text.toString().substring(0, tvExpression.text.toString().length - 1)
            temp_str = temp_str + num
            tvExpression.text = temp_str
        }
    }

    private fun appendLast(num: String, tvExpression: TextView) {
        if (tvExpression.text.toString().isEmpty()) {
            tvExpression.text = num
        } else {
            tvExpression.text = tvExpression.text.toString() + num
        }
    }
}