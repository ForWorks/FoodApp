package com.example.test.data.model

import com.example.test.domain.model.UIProduct
import com.google.gson.annotations.SerializedName

data class Product (
    @SerializedName("id")
    val id : Int,
    @SerializedName("name")
    val name : String,
    @SerializedName("restaurant")
    val restaurant : String,
    @SerializedName("web")
    val web : String,
    @SerializedName("description")
    val description : String,
    @SerializedName("ingredients")
    val ingredients : List<String>,
    @SerializedName("addresses")
    val addresses : List<Addresses>
) {
    fun getUIProduct(): UIProduct {
        return UIProduct(name, restaurant, description, ingredients)
    }
}