package com.example.workautoapplication.domain

import androidx.lifecycle.LiveData
import com.example.workautoapplication.data.AutoItemDbModel

class GetAutoListModelUseCase(private val autoListRepository: AutoListRepository) {
    suspend fun getAutoListModel(model: String): LiveData<List<AutoItem>> {
        return autoListRepository.getAutoListModel(model)
    }
}