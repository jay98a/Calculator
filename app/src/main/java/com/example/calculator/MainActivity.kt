package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_clear : Button  = findViewById(R.id.btn_Clear);

        btn_clear.setOnClickListener {
            val toast = Toast.makeText(this,"Clear button",Toast.LENGTH_SHORT)
            toast.show()
        }

    }
}