package com.example.test.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "uiProduct")
data class UIProduct(
    @PrimaryKey
    val id : Int,
    val name : String,
    val description: String
)