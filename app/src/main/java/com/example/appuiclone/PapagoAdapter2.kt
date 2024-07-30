package com.example.appuiclone

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.appuiclone.databinding.RecyclerviewBinding

// ListAdapter... 이거는 아직 공부 필요합니다. (그냥 RecyclerView Adapter 쓸걸 그랬나요?)
class PapapgoAdapter(private val onClick: (Item) -> Unit, private val onLikeClick: (Item) -> Unit) :
    ListAdapter<Item, PapapgoAdapter.ViewHolder>(object : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.string == newItem.string
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }
    }) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            RecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, onClick, onLikeClick)
    }

    inner class ViewHolder(private val binding: RecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Item, onClick: (Item) -> Unit, onLikeClick: (Item) -> Unit) {
            binding.tvTransportResultText.text = item.string

            // 초기 좋아요 이미지 설정
            // likedCheck가 false = 빈 하트 상태 / true = 꽉 찬 하트 상태
            val heartResId = if (item.likedCheck) { R.drawable.heart_full } else R.drawable.heart
            binding.ivChoiceButton.setImageResource(heartResId)

            // 아이템 클릭 리스너 설정 (= 아이템 클릭 시 번역 기록 확인 다이얼 로그 뜨는 그거)
            itemView.setOnClickListener {
                onClick(item)
            }

            // 문제의 좋아요 이미지
            binding.ivChoiceButton.setOnClickListener {

                // 좋아요 이미지 클릭하면 꽉찬 하트 되면서 좋아요 +1, 다시 누르면 빈 하트 되면서 좋아요 - 1
                item.likedCheck = !item.likedCheck
                item.like += if (item.likedCheck) 1 else -1

                val heartImage = if (item.likedCheck) {
                    R.drawable.heart_full
                } else R.drawable.heart
                // 바뀐 이미지로 이미지뷰 하트 이미지 변경
                binding.ivChoiceButton.setImageResource(heartImage)

                // 좋아요 수를 번역 기록 Fragment에서 표시하는 부분
                Toast.makeText(itemView.context, "좋아요 수 : ${item.like}", Toast.LENGTH_SHORT).show()

                onLikeClick(item)

            }
        }
    }
}