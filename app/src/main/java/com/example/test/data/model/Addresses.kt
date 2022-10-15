package com.example.test.data.model

import com.google.gson.annotations.SerializedName

data class Addresses (
    @SerializedName("addressId")
    val addressId : String,
    @SerializedName("number")
    val number : String,
    @SerializedName("line1")
    val line1 : String,
    @SerializedName("line2")
    val line2 : String,
    @SerializedName("postcode")
    val postcode : String,
    @SerializedName("country")
    val country : String
)