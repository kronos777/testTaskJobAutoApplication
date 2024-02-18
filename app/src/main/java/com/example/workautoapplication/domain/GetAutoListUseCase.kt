package com.example.workautoapplication.domain

import androidx.lifecycle.LiveData
import com.example.workautoapplication.data.AutoItemDbModel

class GetAutoListUseCase(private val autoListRepository: AutoListRepository) {
    fun getAutoList(): LiveData<List<AutoItem>> {
        return autoListRepository.getAutoList()
    }
}


