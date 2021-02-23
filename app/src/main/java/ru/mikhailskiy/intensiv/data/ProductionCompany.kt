package ru.mikhailskiy.intensiv.data

import com.google.gson.annotations.SerializedName

data class ProductionCompany(
    @SerializedName("name") val name: String,
    @SerializedName("id") val id: Int,
    @SerializedName("logo_path") val logo: String,
    @SerializedName("origin_country") val originCountry: String
)
