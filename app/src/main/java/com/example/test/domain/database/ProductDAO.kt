package com.example.test.domain.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.test.domain.model.UIProduct

@Dao
interface ProductDAO {

    @Query("SELECT * FROM uiProduct")
    fun getProducts(): MutableList<UIProduct>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProducts(products: List<UIProduct>)
}