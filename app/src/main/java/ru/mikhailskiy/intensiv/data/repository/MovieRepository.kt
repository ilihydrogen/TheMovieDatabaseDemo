package ru.mikhailskiy.intensiv.data.repository

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.mikhailskiy.intensiv.data.CreditsResponse
import ru.mikhailskiy.intensiv.data.Movie
import ru.mikhailskiy.intensiv.data.MovieResponse
import ru.mikhailskiy.intensiv.network.MovieApiClient

object MovieRepository {

    fun search(
        query: String,
        onResult: ((page: Int, movies: List<Movie>) -> Unit)? = null,
        onError: ((throwable: Throwable) -> Unit)? = null,
        page: Int = 1,
        language: String = "en_US"
    ) {
        MovieApiClient.getRetrofit().search(query = query, page = page, language = language)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError { onError?.invoke(it) }
            .subscribe { onResult?.invoke(it.page, it.movies) }
    }

    fun nowPlaying(
        onResult: ((page: Int, movies: List<Movie>) -> Unit)? = null,
        onError: ((throwable: Throwable) -> Unit)? = null,
        page: Int = 1,
        language: String = "en_US"
    ) {
        MovieApiClient.getRetrofit().nowPlaying(page = page, language = language)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError { onError?.invoke(it) }
            .subscribe { onResult?.invoke(it.page, it.movies) }
    }

    fun popular(
        onResult: ((page: Int, movies: List<Movie>) -> Unit)? = null,
        onError: ((throwable: Throwable) -> Unit)? = null,
        page: Int = 1,
        language: String = "en_US"
    ) {
        MovieApiClient.getRetrofit().popular(page = page, language = language)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError { onError?.invoke(it) }
            .subscribe { onResult?.invoke(it.page, it.movies) }
    }

    fun popularTvShows(
        onResult: ((page: Int, movies: List<Movie>) -> Unit)? = null,
        onError: ((throwable: Throwable) -> Unit)? = null,
        page: Int = 1,
        language: String = "en_US"
    ) {
        MovieApiClient.getRetrofit().tvPopular(page = page, language = language)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError { onError?.invoke(it) }
            .subscribe { onResult?.invoke(it.page, it.movies) }
    }

    fun movieDetails(
        id: Int,
        onResult: ((movie: Movie) -> Unit)? = null,
        onError: ((throwable: Throwable) -> Unit)? = null,
        language: String = "en_US"
    ) {
        MovieApiClient.getRetrofit().movieDetails(id = id, language = language)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError { onError?.invoke(it) }
            .subscribe { onResult?.invoke(it) }
    }

    fun movieCredits(
        id: Int,
        onResult: ((movie: CreditsResponse) -> Unit)? = null,
        onError: ((throwable: Throwable) -> Unit)? = null,
        language: String = "en_US"
    ) {
        MovieApiClient.getRetrofit().movieCredits(id = id, language = language)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError { onError?.invoke(it) }
            .subscribe { onResult?.invoke(it) }
    }

}
