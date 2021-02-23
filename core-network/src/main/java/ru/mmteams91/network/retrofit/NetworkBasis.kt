package ru.mmteams91.network.retrofit

import com.squareup.moshi.Moshi
import okhttp3.Call
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class NetworkBasis @Inject constructor() {
    fun okHttpBasis(): OkHttpClient.Builder = OkHttpClient.Builder()
        .connectTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
        .readTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
        .writeTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)

    fun retrofitBasis(
        baseUrl: String,
        moshi: Moshi = Moshi.Builder().build(),
        callFactory: Call.Factory = okHttpBasis().build()
    ): Retrofit.Builder = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .callFactory(callFactory)

    companion object {
        const val TIMEOUT_SECONDS = 30L

    }
}