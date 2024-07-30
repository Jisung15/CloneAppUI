package com.example.appuiclone

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appuiclone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    companion object {
        const val STRING = "string"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.button1.setOnClickListener {
            val text = binding.tvLanguage.text.toString()

            if (text.isEmpty()) {
                Toast.makeText(this, "아무것도 입력하지 않았습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // sharedPreferences의 흔적
//            val sharedPreferences = getSharedPreferences("transport", Context.MODE_PRIVATE)
//            val editor = sharedPreferences.edit()
//            val current = sharedPreferences.getStringSet("text", mutableSetOf()) ?: mutableSetOf()
//            current.add(text)
//            editor.putStringSet("text", current)
//            editor.apply()

            // 근데 대체 왜 Activity로 넘기는데 Fragment에서 사용 가능한 거지..?
            val intent = Intent(this, ResultPageActivity::class.java)
            intent.putExtra(STRING, text)
            startActivity(intent)
        }

        binding.button2.setOnClickListener {
            Toast.makeText(this, "이 버튼은 구현되지 않은 기능입니다.", Toast.LENGTH_SHORT).show()
            return@setOnClickListener
        }
        binding.button3.setOnClickListener {
            Toast.makeText(this, "이 버튼은 구현되지 않은 기능입니다.", Toast.LENGTH_SHORT).show()
            return@setOnClickListener
        }
        binding.button4.setOnClickListener {
            Toast.makeText(this, "이 버튼은 구현되지 않은 기능입니다.", Toast.LENGTH_SHORT).show()
            return@setOnClickListener
        }
    }
}
