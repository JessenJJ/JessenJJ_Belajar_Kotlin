package com.example.jessenjj_kotlin.di

import com.example.jessenjj_kotlin.data.Service
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent:: class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideOkHttpClient() = OkHttpClient.Builder().build()

    @Singleton
    @Provides
    fun  provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://private-3bac3-jessenjj.apiary-mock.com/")
        .client(okHttpClient)
        .build()

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): Service = retrofit.create(Service:: class.java)
}