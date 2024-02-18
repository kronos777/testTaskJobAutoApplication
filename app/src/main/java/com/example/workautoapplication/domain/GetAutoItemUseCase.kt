package com.example.workautoapplication.domain

class GetAutoItemUseCase(private val autoListRepository: AutoListRepository) {

    suspend fun getAutoItem(autoItemId: Int): AutoItem {
        return autoListRepository.getAutoItem(autoItemId)
    }
}