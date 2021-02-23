package ru.mmteams91.quest.di

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import ru.mmteams91.dagger.PerFeature
import ru.mmteams91.network.retrofit.IRetrofitFactory
import ru.mmteams91.network.retrofit.NetworkBasis
import ru.mmteams91.quest.BuildConfig
import ru.mmteams91.quest.data.network.GoogleApiKeyInterceptor

private const val PLACES_URI = "https://maps.googleapis.com/maps/api/place"

@Module
class ServicesModule {

    @Provides
    @PerFeature
    fun retrofit(
        okHttp: OkHttpClient,
        moshi: Moshi,
        networkBasis: NetworkBasis
    ): Retrofit = networkBasis.retrofitBasis(PLACES_URI, moshi, okHttp)
        .build()

    @Provides
    @PerFeature
    fun okHttp(networkBasis: NetworkBasis): OkHttpClient = networkBasis.okHttpBasis()
        .addNetworkInterceptor(GoogleApiKeyInterceptor())
        .build()

}