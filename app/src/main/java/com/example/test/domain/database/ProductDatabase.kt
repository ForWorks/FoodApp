package com.example.test.domain.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.test.domain.model.UIProduct

@Database(entities = [UIProduct::class], version = 1, exportSchema = false)
abstract class ProductDatabase: RoomDatabase() {

    abstract fun productDAO(): ProductDAO

    companion object{

        private var instance: ProductDatabase? = null

        fun getInstance(context: Context): ProductDatabase {

            if (instance == null) {
                instance = Room
                    .databaseBuilder(context.applicationContext, ProductDatabase::class.java, "products")
                    .build()
            }

            return instance!!
        }
    }
}