package ru.mmteams91.network.retrofit

import com.squareup.moshi.Moshi
import okhttp3.Call
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

private const val TIMEOUT_SECONDS = 30L

internal class DefaultFactory(
    private val moshi: Moshi = defaultMoshi(),
    private val callFactory: Call.Factory = defaultCallFactory()
) :
    IRetrofitFactory {

    override fun retrofit(baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .callFactory(callFactory)
            .build()
    }

    override fun callFactory(): OkHttpClient = defaultCallFactory()
}

private fun defaultMoshi(): Moshi = Moshi.Builder().build()

private fun defaultCallFactory(): OkHttpClient = OkHttpClient.Builder()
    .connectTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
    .readTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
    .writeTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
    .build()
