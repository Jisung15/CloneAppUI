package com.example.appuiclone

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appuiclone.databinding.FragmentResultChoiceBinding

class ResultChoiceFragment : Fragment() {
    private var _binding: FragmentResultChoiceBinding? = null
    private val binding get() = _binding!!

    companion object {
        const val KEY_FRAGMENT_RESULT = "key_fragment_result"
    }

    // 이거는 항상 빼 먹지 말고 써 놓아야 한다.
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultChoiceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 좋아요 확인 버튼 누르면 좋아요 넘어온 개수 확인
        parentFragmentManager.setFragmentResultListener(KEY_FRAGMENT_RESULT, viewLifecycleOwner) { _, bundle ->
            val likedItems = bundle.getInt(KEY_FRAGMENT_RESULT)
            binding.choiceNumber.setOnClickListener {
                Toast.makeText(
                    requireContext(),
                    "좋아요 개수 : ${likedItems} 잘 전달 되었네요!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    }

    // 이거 은근 안 써서 놓치기 쉽다.
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}