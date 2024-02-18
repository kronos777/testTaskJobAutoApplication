package com.example.workautoapplication.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.workautoapplication.domain.AutoItem

class AutoItemDiffCallback: DiffUtil.ItemCallback<AutoItem>() {
    override fun areItemsTheSame(oldItem: AutoItem, newItem: AutoItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: AutoItem, newItem: AutoItem): Boolean {
        return oldItem == newItem
    }


}