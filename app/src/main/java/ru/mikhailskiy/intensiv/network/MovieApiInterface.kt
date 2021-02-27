package ru.mikhailskiy.intensiv.network

import android.annotation.SuppressLint
import io.reactivex.rxjava3.core.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.mikhailskiy.intensiv.BuildConfig
import ru.mikhailskiy.intensiv.data.CreditsResponse
import ru.mikhailskiy.intensiv.data.Movie
import ru.mikhailskiy.intensiv.data.MovieResponse
import java.util.*


@SuppressLint("ConstantLocale")
val lang: String = Locale.getDefault().isO3Language

interface MovieApiInterface {
    @GET("/3/movie/now_playing")
    fun nowPlaying(
        @Query("page") page: Int = 1,
        @Query("language") language: String = lang,
        @Query("api_key") token: String = BuildConfig.THE_MOVIE_DATABASE_API
    ): Observable<MovieResponse>

    @GET("/3/movie/popular")
    fun popular(
        @Query("page") page: Int = 1,
        @Query("language") language: String = lang,
        @Query("api_key") token: String = BuildConfig.THE_MOVIE_DATABASE_API
    ): Observable<MovieResponse>

    @GET("/3/tv/popular")
    fun tvPopular(
        @Query("page") page: Int = 1,
        @Query("language") language: String = lang,
        @Query("api_key") token: String = BuildConfig.THE_MOVIE_DATABASE_API
    ): Observable<MovieResponse>

    @GET("/3/movie/{movie_id}")
    fun movieDetails(
        @Path("movie_id") id: Int,
        @Query("language") language: String = lang,
        @Query("api_key") token: String = BuildConfig.THE_MOVIE_DATABASE_API
    ): Observable<Movie>

    @GET("/3/movie/{movie_id}/credits")
    fun movieCredits(
        @Path("movie_id") id: Int,
        @Query("language") language: String = lang,
        @Query("api_key") token: String = BuildConfig.THE_MOVIE_DATABASE_API
    ): Observable<CreditsResponse>

    @GET("/3/search/movie")
    fun search(
        @Query("query") query: String,
        @Query("page") page: Int = 1,
        @Query("language") language: String = lang,
        @Query("api_key") token: String = BuildConfig.THE_MOVIE_DATABASE_API
    ): Observable<MovieResponse>

}
