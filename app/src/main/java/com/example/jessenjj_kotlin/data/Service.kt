package com.example.jessenjj_kotlin.data

import com.example.jessenjj_kotlin.model.MenuDashboardResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {

    @GET("menu-dashboard")
    suspend fun getHomeMenu(): Response<MenuDashboardResponse>

    //    @GET("api/json/v1/1/search.php")
    //    suspend fun getDetail(@Query("s") query: String)
}

