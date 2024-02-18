package com.example.workautoapplication.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.workautoapplication.data.AutoListRepositoryImpl
import com.example.workautoapplication.domain.DeleteAutoUseCase
import com.example.workautoapplication.domain.GetAutoListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AutoListViewModel @Inject constructor(repository: AutoListRepositoryImpl) : ViewModel() {

    private val getAutoItemList = GetAutoListUseCase(repository)
    private val deleteAutoUseCase = DeleteAutoUseCase(repository)


    val autoList = getAutoItemList.getAutoList()


}