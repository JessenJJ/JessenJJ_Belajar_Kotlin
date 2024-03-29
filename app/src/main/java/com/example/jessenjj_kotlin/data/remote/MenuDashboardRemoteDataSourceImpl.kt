package com.example.jessenjj_kotlin.data.remote

import com.example.jessenjj_kotlin.data.Service
import com.example.jessenjj_kotlin.model.MenuDashboardResponse
import retrofit2.Response
import javax.inject.Inject

class MenuDashboardRemoteDataSourceImpl @Inject constructor(val service: Service) : MenuDashboardRemoteDataSource {

    override suspend fun getMenuDashboard(): Response<MenuDashboardResponse> {
        return service.getHomeMenu()
    }
}