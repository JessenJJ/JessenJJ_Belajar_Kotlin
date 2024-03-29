package com.example.jessenjj_kotlin.data.remote

import com.example.jessenjj_kotlin.model.MenuDashboardResponse
import retrofit2.Response

interface MenuDashboardRemoteDataSource {

    suspend fun getMenuDashboard() : Response<MenuDashboardResponse>
}