package com.example.appuiclone

// 여기는 이제 안 씁니다. Fragment로 코드가 옮겨갔어요

/*
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
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))

        val adapter = PapapgoAdapter { item ->
            val builder = AlertDialog.Builder(this)
            builder.setTitle("번역 기록 확인")
            builder.setMessage("번역할 문장 또는 단어\n: ${item.string}\n\n번역된 문장 또는 단어\n: (대충 영어로 번역한 결과)")
            val listener = DialogInterface.OnClickListener { dialog, which ->
                when (which) {
                    DialogInterface.BUTTON_POSITIVE -> {
                        Toast.makeText(
                            this,
                            "\"${item.string}\"\n의 번역 결과를 확인하셨습니다.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    DialogInterface.BUTTON_NEGATIVE -> dialog.dismiss()
                }
            }
            builder.setPositiveButton("확인", listener)
            builder.setNegativeButton("취소", listener)
            builder.show()
        }

        adapter.submitList(TransportList.list.toList())
        binding.recyclerView.adapter = adapter

        binding.btnDelete.setOnClickListener {
            if (TransportList.list.isEmpty()) {
                Toast.makeText(this, "삭제할 항목이 없습니다.", Toast.LENGTH_SHORT).show()
            } else {
                val delete = TransportList.list.removeAt(0)
                adapter.submitList(TransportList.list.toList())
                Toast.makeText(this, "\"${delete.string}\"을(를) 번역한 기록을 삭제했습니다.", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnClear.setOnClickListener {
            if (TransportList.list.isEmpty()) {
                Toast.makeText(this, "삭제할 항목이 없습니다.", Toast.LENGTH_SHORT).show()
            } else {
                TransportList.list.clear()
                adapter.submitList(TransportList.list.toList())
                Toast.makeText(this, "전체 번역 기록을 삭제하였습니다.", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnFinish.setOnClickListener {
            finish()
        }
    }
}*/