package com.example.workautoapplication.domain

class AddAutoUseCase(private val autoListRepository: AutoListRepository) {

    suspend fun addAutoUseCase(autoItem: AutoItem) {
        autoListRepository.addAutoItem(autoItem)
    }

}