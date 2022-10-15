package com.example.test.presentation.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.test.data.repository.Repository
import com.example.test.domain.model.UIProduct
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository): ViewModel() {

    val productsList = MutableLiveData<MutableList<UIProduct>>()

    fun getProductsList() {
        CoroutineScope(Dispatchers.IO).launch {
            val products = repository.getData()
            val uiProducts = mutableListOf<UIProduct>()
            products?.forEach { uiProducts.add(it.getUIProduct()) }
            withContext(Dispatchers.Main) { productsList.value = uiProducts }
        }
    }
}