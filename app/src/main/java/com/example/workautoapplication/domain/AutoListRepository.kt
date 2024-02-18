package com.example.workautoapplication.domain

import androidx.lifecycle.LiveData
import com.example.workautoapplication.data.AutoItemDbModel

interface AutoListRepository {

    fun getAutoList(): LiveData<List<AutoItem>>


    suspend fun addAutoItem(autoItem: AutoItem)


    suspend fun deleteAutoId(autoId: Int)


    suspend fun getAutoItem(autoId: Int): AutoItem


    fun getAutoListBrand(brandUser: String): LiveData<List<AutoItem>>


    fun getAutoListModel(modelUser: String): LiveData<List<AutoItem>>


}