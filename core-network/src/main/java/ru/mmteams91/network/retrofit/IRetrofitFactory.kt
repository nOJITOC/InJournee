package ru.mmteams91.network.retrofit

import com.squareup.moshi.Moshi
import okhttp3.Authenticator
import retrofit2.Retrofit

interface IRetrofitFactory {
    fun retrofit(baseUrl: String, authenticator: Authenticator? = null): Retrofit

    companion object {
        fun default(): IRetrofitFactory = DefaultFactory()

        fun default(moshi: Moshi): IRetrofitFactory = DefaultFactory(moshi)
    }
}