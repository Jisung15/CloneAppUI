package com.example.appuiclone

// 이거는 RecyclerView Adapter의 흔적입니다


//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.example.appuiclone.databinding.ActivityTransportResultBinding
//import com.example.appuiclone.databinding.RecyclerviewBinding
//
//class PapapgoAdapter(private val items: MutableList<Item>) :
//    RecyclerView.Adapter<PapapgoAdapter.Holder>() {
//
//    inner class Holder(private val binding: RecyclerviewBinding) :
//        RecyclerView.ViewHolder(binding.root) {
//        var result = binding.tvTransportResultText
//    }
//
//    interface OnClick {
//        fun click(view: View, position: Int)
//    }
//
//    var click: OnClick? = null
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PapapgoAdapter.Holder {
//        val binding =
//            RecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return Holder(binding)
//    }
//
//    override fun onBindViewHolder(holder: PapapgoAdapter.Holder, position: Int) {
//        holder.itemView.setOnClickListener {
//            click?.click(it, position)
//        }
//
//        holder.result.text = items[position].string
//    }
//
//    override fun getItemId(position: Int): Long {
//        return position.toLong()
//    }
//
//    override fun getItemCount(): Int {
//        return items.size
//    }
//
//}