package ru.mikhailskiy.intensiv.data

import com.google.gson.annotations.SerializedName

data class Actor(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("profile_path") val profilePath: String?
)
