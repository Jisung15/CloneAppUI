package com.example.appuiclone

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appuiclone.databinding.FragmentTransportResultBinding

class TransportResultFragment : Fragment() {
    // 이거 꼭 선언해 주어야 한다고 하셨습니다.
    // binding 쓰는 방법이 Activity랑 달라서 헷갈립니다.. ㅠㅠ
    private var _binding: FragmentTransportResultBinding? = null
    private val binding get() = _binding!!
    companion object {
        const val STRING = "string"
        const val KEY_FRAGMENT_RESULT = "key_fragment_result"
    }
    private lateinit var adapter: PapapgoAdapter

    // 이거는 항상 빼 먹지 말고 써 놓아야 한다.
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTransportResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 여기서부터가 진짜
        // MainActivity에서 String 받아와서
        // 그걸 ListAdapter에 넣기
        val intent = arguments?.getString(STRING) ?: ""
        TransportList.addItem(Item(intent))
        // 이건 List 형태로 보여주게 하는 거랑 구분선 넣기 (너무 익숙하니 패스)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))

        // 이건 번역 기록 확인 다이얼로그 파트
        adapter = PapapgoAdapter ({ item ->
            val builder = AlertDialog.Builder(requireContext())
            builder.setTitle("번역 기록 확인")
            builder.setMessage("번역할 문장 또는 단어\n: ${item.string}\n\n번역된 문장 또는 단어\n: (대충 영어로 번역한 결과)")
            val listener = DialogInterface.OnClickListener { dialog, which ->
                when (which) {
                    DialogInterface.BUTTON_POSITIVE -> {
                        Toast.makeText(
                            requireContext(),
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
        }, { item ->
            adapter.notifyItemChanged(TransportList.list.indexOf(item))
            setFragmentResult(KEY_FRAGMENT_RESULT, bundleOf(KEY_FRAGMENT_RESULT to item.like))
        })

        // ListAdapter는 submitList라고 들었네요
        adapter.submitList(TransportList.list.toList())
        binding.recyclerView.adapter = adapter

        // 번역 기록 일부 지우기 버튼 클릭 이벤트
        binding.btnDelete.setOnClickListener {
            if (TransportList.list.isEmpty()) {
                Toast.makeText(requireContext(), "삭제할 항목이 없습니다.", Toast.LENGTH_SHORT).show()
            } else {
                val delete = TransportList.list.removeAt(0)

                // 어댑터에 지운 거 제외한 dataList를 업데이트 해 줘야겠죠?
                adapter.submitList(TransportList.list.toList())
                Toast.makeText(
                    requireContext(),
                    "\"${delete.string}\"을(를) 번역한 기록을 삭제했습니다.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        // 완전 삭제 버튼 클릭 이벤트
        binding.btnClear.setOnClickListener {
            if (TransportList.list.isEmpty()) {
                Toast.makeText(requireContext(), "삭제할 항목이 없습니다.", Toast.LENGTH_SHORT).show()
            } else {
                // 완전히 다 지울 때는 clear
                TransportList.list.clear()
                adapter.submitList(TransportList.list.toList())
                Toast.makeText(requireContext(), "전체 번역 기록을 삭제하였습니다.", Toast.LENGTH_SHORT).show()
            }
        }

        // 이거는 종료하고 메인 화면으로 돌아가는 부분
        binding.btnFinish.setOnClickListener {
            activity?.finish()
        }
    }

    // 이거 은근 안 써서 놓치기 쉽다.
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}