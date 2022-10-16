package com.example.test.presentation.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.test.data.model.Product
import com.example.test.data.repository.Repository
import com.example.test.domain.model.UIProduct
import com.example.test.domain.utils.Constants.ERROR
import com.example.test.presentation.di.App
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
            var products: List<Product>?

            try {
                products = repository.getData()
            }
            catch (e: Exception) {
                products = null
                Log.e(ERROR, e.message.toString())
            }

            if(products != null) {
                val uiProducts = mutableListOf<UIProduct>()

                products.forEach {
                    uiProducts.add(it.getUIProduct())
                }
                withContext(Dispatchers.Main) { productsList.value = uiProducts }

                if(App.getContext() != null) {
                    repository.insertProducts(uiProducts)
                }
            }
        }
    }

    fun getDataFromDatabase() {
        CoroutineScope(Dispatchers.IO).launch {
            if(App.getContext() != null) {
                val products = repository.getProducts()
                withContext(Dispatchers.Main) { productsList.value = products }
            }
        }
    }
}