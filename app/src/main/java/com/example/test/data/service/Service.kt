package com.example.test.data.service

import com.example.test.data.model.Product
import com.example.test.domain.utils.Constants.BURGER_ENDPOINT
import com.example.test.domain.utils.Constants.HEADER_HOST
import com.example.test.domain.utils.Constants.HEADER_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface Service {
    @Headers(HEADER_KEY, HEADER_HOST)
    @GET(BURGER_ENDPOINT)
    suspend fun getData(): Response<List<Product>>
}