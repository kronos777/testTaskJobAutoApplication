package com.example.workautoapplication.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.workautoapplication.data.AutoItemDbModel

class GetAutoListBrandUseCase(private val autoListRepository: AutoListRepository) {
    suspend fun getAutoListBrand(brand: String): LiveData<List<AutoItem>> {
        return autoListRepository.getAutoListBrand(brand)
    }
}