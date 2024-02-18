package com.example.workautoapplication.domain

class EditAutoUseCase(private val autoListRepository: AutoListRepository) {

    suspend fun editAutoItem(autoItem: AutoItem) {
        autoListRepository.addAutoItem(autoItem)
    }

}