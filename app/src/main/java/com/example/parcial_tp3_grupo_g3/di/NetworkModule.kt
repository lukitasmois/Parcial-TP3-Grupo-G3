package com.example.parcial_tp3_grupo_g3.di

import com.example.parcial_tp3_grupo_g3.core.Config
import com.example.parcial_tp3_grupo_g3.core.InterceptorCustom
import com.example.parcial_tp3_grupo_g3.data.network.TripApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    val interceptor : HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    var client : OkHttpClient = OkHttpClient.Builder().apply {
        addInterceptor(interceptor).addInterceptor(InterceptorCustom)
    }.build()

    @Singleton
    @Provides
    fun provideRetrofilt(): Retrofit {
        val baseUrl = Config.url


        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideQuoteApiClient(retrofit: Retrofit): TripApiClient {
        return retrofit.create(TripApiClient::class.java)
    }
}