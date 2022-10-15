package com.example.test.data.repository

import com.example.test.data.model.Product
import com.example.test.data.service.Service
import javax.inject.Inject

class Repository @Inject constructor(private val apiService: Service) {

    suspend fun getData(): List<Product>? {
        return apiService.getData().body()
    }
}