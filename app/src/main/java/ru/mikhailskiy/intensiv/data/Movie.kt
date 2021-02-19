package ru.mikhailskiy.intensiv.data

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("id") val id: Int,
    @SerializedName("title", alternate = ["name"]) val title: String? = "",
    @SerializedName("vote_average") val voteAverage: Double = 0.0,
    @SerializedName("video") val video: Boolean,
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("overview") val overview: String,
    @SerializedName("release_date", alternate = ["first_air_date"]) val releaseDate: String,
    @SerializedName("genre_ids") val genreIds: List<Int>,
    @SerializedName("genres") val genres: List<Genre>?,
    @SerializedName("production_companies") val production: List<ProductionCompany>?
) {
    var actors: List<Actor>? = null
    val rating: Float
        get() = voteAverage.div(2).toFloat()

    val imageUrl: String
        get() = "https://image.tmdb.org/t/p/w500$posterPath"

    val year: String
        get() = releaseDate.split("-").first()
}
