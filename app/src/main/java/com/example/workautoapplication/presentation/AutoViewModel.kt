package com.example.workautoapplication.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.workautoapplication.data.AutoListRepositoryImpl
import com.example.workautoapplication.domain.AddAutoUseCase
import com.example.workautoapplication.domain.AutoItem
import com.example.workautoapplication.domain.EditAutoUseCase
import com.example.workautoapplication.domain.GetAutoItemUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AutoViewModel @Inject constructor(repository: AutoListRepositoryImpl) : ViewModel() {

    private val getAutoItemUseCase = GetAutoItemUseCase(repository)
    private val addAutoItemUseCase = AddAutoUseCase(repository)
    private val editAutoUseCase = EditAutoUseCase(repository)


    private val _shouldCloseScreen = MutableLiveData<Unit>()
    val shouldCloseScreen: LiveData<Unit>
        get() = _shouldCloseScreen


    private val _autoItem = MutableLiveData<AutoItem>()
    val autoItem: LiveData<AutoItem>
        get() = _autoItem


    fun getAutoItem(autoItemId: Int) {
        viewModelScope.launch {
            val item = getAutoItemUseCase.getAutoItem(autoItemId)
            _autoItem.value = item
        }
    }

    fun addAutoItem(brand: String, model: String, price: Int) {
        val item = AutoItem(brand, model, price)
        viewModelScope.launch {
            addAutoItemUseCase.addAutoUseCase(item)
            finishWork()
        }
    }

    fun editAutoItem(brand: String, model: String, price: Int) {
        _autoItem.value?.let {
            viewModelScope.launch {
                val autoItem = it.copy(
                    brand = brand,
                    model = model,
                    price = price
                )
                editAutoUseCase.editAutoItem(autoItem)
                finishWork()
            }
        }
    }


    private fun finishWork() {
        _shouldCloseScreen.value = Unit
    }


}