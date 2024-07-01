package com.example.appuiclone

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.setMargins

class TransportResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_transport_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val finishButton = findViewById<Button>(R.id.btn_finish)
        val value = findViewById<LinearLayout>(R.id.lv_value)

        val text1 = intent.getStringExtra("text")

        finishButton.setOnClickListener {

            val textView = TextView(this).apply {
                text = "번역할 내용\n${text1}\n\n해당 내용 영어 번역 결과\n(대충 영어로 번역한 결과)"
                textSize = 15f
                setTypeface(typeface, android.graphics.Typeface.BOLD)
                layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT).apply {
                    setMargins(0, 30, 0, 30)
                }
            }
            value.addView(textView)

            val div = View(this).apply {
                layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 10).apply {
                    setMargins(0, 0, 0, 0)
                }
                setBackgroundColor(Color.BLACK)
            }
            value.addView(div)

        }
    }
}