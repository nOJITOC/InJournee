package ru.mmteams91.network.retrofit

import com.squareup.moshi.Moshi
import okhttp3.Call
import okhttp3.OkHttpClient
import retrofit2.Retrofit

interface IRetrofitFactory {
    fun retrofit(baseUrl: String): Retrofit

    fun callFactory(): OkHttpClient

    companion object {
        fun default(): IRetrofitFactory = DefaultFactory()

        fun default(moshi: Moshi): IRetrofitFactory = DefaultFactory(moshi)
    }
}