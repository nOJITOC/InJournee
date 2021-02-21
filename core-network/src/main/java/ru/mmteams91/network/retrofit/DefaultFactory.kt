package ru.mmteams91.network.retrofit

import com.squareup.moshi.Moshi
import okhttp3.Authenticator
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

private const val TIMEOUT_SECONDS = 30L

internal class DefaultFactory(private val moshi: Moshi = defaultMoshi()) :
    IRetrofitFactory {

    override fun retrofit(baseUrl: String, authenticator: Authenticator?): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .callFactory(
                OkHttpClient.Builder()
                    .connectTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
                    .readTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
                    .writeTimeout(TIMEOUT_SECONDS, TimeUnit.SECONDS)
                    .apply { authenticator(authenticator ?: return@apply) }
                    .build()
            ).build()
    }
}

private fun defaultMoshi(): Moshi = Moshi.Builder().build()
