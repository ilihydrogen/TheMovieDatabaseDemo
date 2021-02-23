package ru.mikhailskiy.intensiv.network

import ru.mikhailskiy.intensiv.BuildConfig

object ImageUtils {
    fun imageUrl(id: String, format: String = "w500") =
        BuildConfig.THE_MOVIE_DATABASE_IMAGE_URL_PREFIX.format(format).plus(id)
}