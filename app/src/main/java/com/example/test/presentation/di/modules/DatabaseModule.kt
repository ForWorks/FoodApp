package com.example.test.presentation.di.modules

import com.example.test.domain.database.ProductDAO
import com.example.test.domain.database.ProductDatabase
import com.example.test.presentation.di.App
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(): ProductDatabase {
        return ProductDatabase.getInstance(App.getContext()!!)
    }

    @Provides
    @Singleton
    fun provideDAO(database: ProductDatabase): ProductDAO {
        return database.productDAO()
    }
}