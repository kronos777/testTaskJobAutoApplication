package com.example.workautoapplication.domain

class DeleteAutoUseCase(private val autoListRepository: AutoListRepository) {

    suspend fun deleteAutoItem(autoItem: AutoItem) {
        autoListRepository.deleteAutoId(autoItem.id)
    }


}