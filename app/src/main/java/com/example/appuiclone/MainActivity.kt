package com.example.appuiclone

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val transportButton = findViewById<LinearLayout>(R.id.button)

        transportButton.setOnClickListener {
            val transportText = findViewById<EditText>(R.id.tv_language)
            val text = transportText.text.toString()

            val intent = Intent(this, TransportResultActivity::class.java)
            intent.putExtra("text", text)
            val transport = text
            TransPort.add(transport)
            startActivity(intent)
        }
    }
}
