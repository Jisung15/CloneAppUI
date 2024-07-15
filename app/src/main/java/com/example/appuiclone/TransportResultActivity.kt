package com.example.appuiclone

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appuiclone.databinding.ActivityTransportResultBinding

class TransportResultActivity : AppCompatActivity() {
    private val binding by lazy { ActivityTransportResultBinding.inflate(layoutInflater) }

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

        val intent = intent.getStringExtra(STRING)
        TransportList.addItem(Item(intent.toString()))

        val adapter = PapapgoAdapter(TransportList.list)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        binding.recyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))

        binding.btnClear.setOnClickListener {
            TransportList.list.clear()
            adapter.notifyDataSetChanged()
        }

        binding.btnFinish.setOnClickListener {
            finish()
        }

        // 여기부터는 이전에 TextView 추가하기 도전했던 부분...
        // RecyclerView를 도전해서 이 부분은 필요없으니 주석 처리
        /*val finishButton = findViewById<Button>(R.id.btn_finish)
        val value = findViewById<LinearLayout>(R.id.lv_value)

        val sharedPreferences = getSharedPreferences("transport", Context.MODE_PRIVATE)
        val text1 = sharedPreferences.getStringSet("text", setOf()) ?: setOf()

        for (text in text1) {
            val textView = TextView(applicationContext)
                textView.text = "번역할 내용\n${text}\n\n해당 내용 영어 번역 결과\n(대충 영어로 번역한 결과)"
                textView.textSize = 15f
                textView.layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    setMargins(0, 30, 0, 30)
                }
            value.addView(textView)

            val div = View(applicationContext)
                div.layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, 10
                ).apply {
                    div.setBackgroundColor(Color.BLACK)
                }
            value.addView(div)
        }

        val clearButton = findViewById<Button>(R.id.btn_clear)
        clearButton.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.clear()
            value.removeAllViews()
            editor.apply()
        }

        finishButton.setOnClickListener {
            finish()
        }*/

    }
}