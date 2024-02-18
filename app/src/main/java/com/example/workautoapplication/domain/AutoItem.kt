package com.example.workautoapplication.domain

data class AutoItem(
    val brand: String,
    val model: String,
    val price: Int,
    val id: Int = AutoItem.UNDEFINED_ID
) {
    companion object {
        const val UNDEFINED_ID = 0
    }
}