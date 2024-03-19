package com.example.jessenjj_kotlin.utils

import android.content.Context
import android.content.SharedPreferences

class SharePrefHelper (context: Context) {
    private val sharedPrev: SharedPreferences =
        context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE)

    fun saveToken(token:String){
        sharedPrev.edit().putString(TOKEN_KEY,token).apply()
    }
    fun getToken():String{
        return sharedPrev.getString(TOKEN_KEY,null) ?: ""
    }

    fun clearDataPref(){
        val editor = sharedPrev.edit()
        editor.clear()
        editor.apply()
    }
    companion object{
        const val PREF_NAME = "pref_name"
        const val TOKEN_KEY = "token_key"
    }
}