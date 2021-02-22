package ru.mikhailskiy.intensiv.data.repository

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.mikhailskiy.intensiv.data.CreditsResponse
import ru.mikhailskiy.intensiv.data.Movie
import ru.mikhailskiy.intensiv.data.MovieResponse
import ru.mikhailskiy.intensiv.network.MovieApiClient

object MovieRepository {

    fun nowPlaying(
        onResult: ((page: Int, movies: List<Movie>) -> Unit)? = null,
        onError: ((throwable: Throwable) -> Unit)? = null,
        page: Int = 1,
        language: String = "en_US"
    ) {
        MovieApiClient.getRetrofit().nowPlaying(page = page, language = language)
            .enqueue(object : Callback<MovieResponse> {

                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    onError?.invoke(t)
                }

                override fun onResponse(
                    call: Call<MovieResponse>,
                    response: Response<MovieResponse>
                ) {
                    response.body()?.page?.let { onResult?.invoke(it, response.body()!!.movies) }
                }

            })
    }

    fun popular(
        onResult: ((page: Int, movies: List<Movie>) -> Unit)? = null,
        onError: ((throwable: Throwable) -> Unit)? = null,
        page: Int = 1,
        language: String = "en_US"
    ) {
        MovieApiClient.getRetrofit().popular(page = page, language = language)
            .enqueue(object : Callback<MovieResponse> {

                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    onError?.invoke(t)
                }

                override fun onResponse(
                    call: Call<MovieResponse>,
                    response: Response<MovieResponse>
                ) {
                    response.body()?.page?.let { onResult?.invoke(it, response.body()!!.movies) }
                }

            })
    }

    fun popularTvShows(
        onResult: ((page: Int, movies: List<Movie>) -> Unit)? = null,
        onError: ((throwable: Throwable) -> Unit)? = null,
        page: Int = 1,
        language: String = "en_US"
    ) {
        MovieApiClient.getRetrofit().tvPopular(page = page, language = language)
            .enqueue(object : Callback<MovieResponse> {

                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    onError?.invoke(t)
                }

                override fun onResponse(
                    call: Call<MovieResponse>,
                    response: Response<MovieResponse>
                ) {
                    response.body()?.page?.let { onResult?.invoke(it, response.body()!!.movies) }
                }

            })
    }

    fun movieDetails(
        id: Int,
        onResult: ((movie: Movie) -> Unit)? = null,
        onError: ((throwable: Throwable) -> Unit)? = null,
        language: String = "en_US"
    ) {
        MovieApiClient.getRetrofit().movieDetails(id = id, language = language)
            .enqueue(object : Callback<Movie> {

                override fun onFailure(call: Call<Movie>, t: Throwable) {
                    onError?.invoke(t)
                }

                override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                    response.body()?.let { onResult?.invoke(it) }
                }

            })
    }

    fun movieCredits(
        id: Int,
        onResult: ((movie: CreditsResponse) -> Unit)? = null,
        onError: ((throwable: Throwable) -> Unit)? = null,
        language: String = "en_US"
    ) {
        MovieApiClient.getRetrofit().movieCredits(id = id, language = language)
            .enqueue(object : Callback<CreditsResponse> {

                override fun onFailure(call: Call<CreditsResponse>, t: Throwable) {
                    onError?.invoke(t)
                }

                override fun onResponse(
                    call: Call<CreditsResponse>,
                    response: Response<CreditsResponse>
                ) {
                    response.body()?.let { onResult?.invoke(it) }
                }

            })
    }

}
