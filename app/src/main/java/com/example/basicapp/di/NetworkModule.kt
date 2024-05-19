package com.example.basicapp.di

import com.example.basicapp.Api.TweetsyApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
// singleton componet ka matlab hai pure project me single object ho
class NetworkModule {
    // below there is two method which help to create object corresponding to interface TweetsyApi.interface
    // jo object create ho rha hai vo retrofit ki vajah se ho rha hai

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit{
        return Retrofit.Builder().baseUrl("https://api.jsonbin.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideTweetsyapi(retrofit: Retrofit): TweetsyApi{
        return retrofit.create(TweetsyApi::class.java)
    }
}