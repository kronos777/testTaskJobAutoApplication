package com.example.workautoapplication.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "auto_item")
data class AutoItemDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val brand: String,
    val model: String,
    val price: Int
)
