package com.example.jessenjj_kotlin.di

import com.example.jessenjj_kotlin.data.Service
import com.example.jessenjj_kotlin.data.remote.MenuDashboardRemoteDataSource
import com.example.jessenjj_kotlin.data.remote.MenuDashboardRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MenuModule {

    @Singleton
    @Provides
    fun provideMenuDashboardRemoteDataSource(service: Service) : MenuDashboardRemoteDataSource {
        return MenuDashboardRemoteDataSourceImpl(service)
    }
}