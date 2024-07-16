package com.example.appuiclone

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
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

        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )

        adapter.click = object : PapapgoAdapter.OnClick {
            override fun click(view: View, position: Int) {
                val builder = AlertDialog.Builder(this@TransportResultActivity)
                val check = TransportList.list.getOrNull(position)

                builder.setTitle("번역 기록 확인")
                builder.setMessage("번역할 문장 또는 단어\n: ${check?.string}\n\n번역된 문장 또는 단어\n: (대충 영어로 번역한 결과)")
                val listener = DialogInterface.OnClickListener { dialog, which ->
                    when (which) {
                        DialogInterface.BUTTON_POSITIVE -> {
                            Toast.makeText(
                                this@TransportResultActivity,
                                "\"${check?.string}\"\n의 번역 결과를 확인하셨습니다.",
                                Toast.LENGTH_SHORT
                            ).show()
                            return@OnClickListener
                        }

                        DialogInterface.BUTTON_NEGATIVE -> dialog?.dismiss()
                    }
                }

                builder.setPositiveButton("확인", listener)
                builder.setNegativeButton("취소", listener)
                builder.show()
            }

        }

        binding.btnDelete.setOnClickListener {
            if (TransportList.list.isEmpty()) {
                Toast.makeText(this@TransportResultActivity, "삭제할 항목이 없습니다.", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            } else {
                val delete = TransportList.list.getOrNull(0)
                Toast.makeText(
                    this@TransportResultActivity,
                    "\"${delete?.string}\"\n을(를) 번역한 기록을 삭제했습니다.",
                    Toast.LENGTH_SHORT
                ).show()

                TransportList.list.removeAt(0)
                adapter.notifyItemRemoved(0)
                adapter.notifyDataSetChanged()
                return@setOnClickListener
            }
        }

        binding.btnClear.setOnClickListener {
            if (TransportList.list.isEmpty()) {
                Toast.makeText(this@TransportResultActivity, "삭제할 항목이 없습니다.", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            } else {
                TransportList.list.clear()
                adapter.notifyDataSetChanged()
                Toast.makeText(this, " 전체 번역 기록을 삭제하였습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
        }

        binding.btnFinish.setOnClickListener {
            finish()
        }

        // 여기부터는 이전에 TextView 추가하기 도전했던 부분...
        // RecyclerView를 도전해서 이 부분은 필요없으니 주석 처리
//        val finishButton = findViewById<Button>(R.id.btn_finish)
//        val value = findViewById<LinearLayout>(R.id.lv_value)
//
//        val sharedPreferences = getSharedPreferences("transport", Context.MODE_PRIVATE)
//        val text1 = sharedPreferences.getStringSet("text", setOf()) ?: setOf()
//
//        for (text in text1) {
//            val textView = TextView(applicationContext)
//                textView.text = "번역할 내용\n${text}\n\n해당 내용 영어 번역 결과\n(대충 영어로 번역한 결과)"
//                textView.textSize = 15f
//                textView.layoutParams = LinearLayout.LayoutParams(
//                    LinearLayout.LayoutParams.WRAP_CONTENT,
//                    LinearLayout.LayoutParams.WRAP_CONTENT
//                ).apply {
//                    setMargins(0, 30, 0, 30)
//                }
//            value.addView(textView)
//
//            val div = View(applicationContext)
//                div.layoutParams = LinearLayout.LayoutParams(
//                    LinearLayout.LayoutParams.MATCH_PARENT, 10
//                ).apply {
//                    div.setBackgroundColor(Color.BLACK)
//                }
//            value.addView(div)
//        }
//
//        val clearButton = findViewById<Button>(R.id.btn_clear)
//        clearButton.setOnClickListener {
//            val editor = sharedPreferences.edit()
//            editor.clear()
//            value.removeAllViews()
//            editor.apply()
//        }
//
//        finishButton.setOnClickListener {
//            finish()
//        }

    }
}