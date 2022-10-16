package com.example.test.data.repository

import com.example.test.data.model.Product
import com.example.test.data.service.Service
import com.example.test.domain.database.ProductDAO
import com.example.test.domain.model.UIProduct
import javax.inject.Inject

class Repository @Inject constructor(private val apiService: Service, private val productDAO: ProductDAO) {

    suspend fun getData(): List<Product>? {
        return apiService.getData().body()
    }

    fun getProducts(): MutableList<UIProduct> {
        return productDAO.getProducts()
    }

    fun insertProducts(products: List<UIProduct>) {
        productDAO.insertProducts(products)
    }
}