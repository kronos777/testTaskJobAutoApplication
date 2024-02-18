package com.example.workautoapplication.presentation


import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.workautoapplication.R
import com.example.workautoapplication.databinding.AutoItemBinding
import com.example.workautoapplication.domain.AutoItem

class AutoListAdapter: ListAdapter<AutoItem, AutoItemViewHolder>(AutoItemDiffCallback()) {
    var onAutoItemClickListener: ((AutoItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AutoItemViewHolder {
        val layout = R.layout.auto_item
        val binding = DataBindingUtil.inflate<AutoItemBinding>(
            LayoutInflater.from(parent.context),
            layout,
            parent,
            false
        )

        return AutoItemViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: AutoItemViewHolder, position: Int) {
        val autoItem = getItem(position)
        val binding = viewHolder.binding
        binding.root.setOnClickListener {
            onAutoItemClickListener?.invoke(autoItem)
        }
        Log.d("dataInAdapter", autoItem.toString())
        binding.autoItem = autoItem
    }

     companion object {
        const val VIEW_TYPE_ENABLED = 100
        const val MAX_POOL_SIZE = 30
    }
}