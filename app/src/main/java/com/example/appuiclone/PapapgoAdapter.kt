package com.example.appuiclone

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appuiclone.databinding.ActivityTransportResultBinding
import com.example.appuiclone.databinding.RecyclerviewBinding

class PapapgoAdapter (val items : MutableList<Item>) : RecyclerView.Adapter<PapapgoAdapter.Holder>() {

    inner class Holder(val binding: RecyclerviewBinding) : RecyclerView.ViewHolder(binding.root) {
        var result = binding.tvTransportResultText
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PapapgoAdapter.Holder {
        val binding = RecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: PapapgoAdapter.Holder, position: Int) {
        holder.result.text = items[position].string
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return items.size
    }

}