package com.example.workautoapplication.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AutoListDao {

    @Query("SELECT * FROM auto_item ORDER BY id DESC")
    fun getAutoList(): LiveData<List<AutoItemDbModel>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAutoItem(autoItemDbModel: AutoItemDbModel)


    @Query("DELETE FROM auto_item WHERE id=:autoId")
    suspend fun deleteAutoId(autoId: Int)


    @Query("SELECT * FROM auto_item WHERE id=:autoId LIMIT 1")
    suspend fun getAutoItem(autoId: Int): AutoItemDbModel


    @Query("SELECT * FROM auto_item WHERE brand LIKE :brandUser")
    fun getAutoListBrand(brandUser: String): LiveData<List<AutoItemDbModel>>

    @Query("SELECT * FROM auto_item WHERE brand LIKE :modelUser")
    fun getAutoListModel(modelUser: String): LiveData<List<AutoItemDbModel>>


}