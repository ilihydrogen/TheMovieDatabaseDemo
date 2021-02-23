package ru.mikhailskiy.intensiv.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.mikhailskiy.intensiv.BuildConfig
import java.util.concurrent.TimeUnit

object MovieApiClient {

    private val interceptor = run {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.apply {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        }
    }


    private val okHttpClient = OkHttpClient.Builder()
        .addNetworkInterceptor(interceptor)
        .connectTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .build()

    fun getRetrofit(): MovieApiInterface {

        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .baseUrl(BuildConfig.THE_MOVIE_DATABASE_API_ENDPOINT)
            .build()

        return retrofit.create(MovieApiInterface::class.java)
    }
}
