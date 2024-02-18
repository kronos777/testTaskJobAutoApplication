package com.example.workautoapplication.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import androidx.lifecycle.switchMap
import com.example.workautoapplication.domain.AutoListRepository
import com.example.workautoapplication.domain.AutoItem

class AutoListRepositoryImpl(application: Application): AutoListRepository {

    private val autoListDao = AppDatabase.getInstance(application).AutoListDao()
    private val mapper = AutoListMapper()

    override suspend fun addAutoItem(autoItem: AutoItem) {
        autoListDao.addAutoItem(mapper.mapEntityToDbModel(autoItem))
    }

    override suspend fun deleteAutoId(autoId: Int) {
        autoListDao.deleteAutoId(autoId)
    }

    override fun getAutoList(): LiveData<List<AutoItem>> {
        return  autoListDao.getAutoList().map{
            mapper.mapListDbModelToListEntity(it)
        }
    }


    override suspend fun getAutoItem(autoId: Int): AutoItem {
        return  mapper.mapDbModelToEntity(autoListDao.getAutoItem(autoId))
    }

    override fun getAutoListBrand(brandUser: String): LiveData<List<AutoItem>> {
        return autoListDao.getAutoListBrand(brandUser).map {
            mapper.mapListDbModelToListEntity(it)
        }
    }


    override fun getAutoListModel(modelUser: String): LiveData<List<AutoItem>> {
        return autoListDao.getAutoListModel(modelUser).map {
            mapper.mapListDbModelToListEntity(it)
        }
    }
}