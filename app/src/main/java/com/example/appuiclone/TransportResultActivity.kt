package com.example.appuiclone

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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

        val value = findViewById<TextView>(R.id.tv_transport)
        val finishButton = findViewById<Button>(R.id.btn_finish)

        val text = intent.getStringExtra("text")
        value.text = "번역 결과\n\n한국어 : ${text}\n영어 : (대충 영어로 번역한 결과)"

        finishButton.setOnClickListener {
            finish()
        }
    }
}