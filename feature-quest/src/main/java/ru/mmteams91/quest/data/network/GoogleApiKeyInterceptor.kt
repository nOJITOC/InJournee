package ru.mmteams91.quest.data.network

import okhttp3.Interceptor
import okhttp3.Response
import ru.mmteams91.quest.BuildConfig

class GoogleApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val newUrl = request.url().newBuilder()
            .addQueryParameter("key", BuildConfig.GOOGLE_API_KEY)
            .build()
        return chain.proceed(
            chain.request().newBuilder()
                .url(newUrl)
                .build()
        )
    }
}