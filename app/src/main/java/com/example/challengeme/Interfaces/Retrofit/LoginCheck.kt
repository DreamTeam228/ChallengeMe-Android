package com.example.challengeme.Interfaces.Retrofit

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.POST

interface LoginCheck {
    @POST("//post")
    fun isLoginFree(@Field("username") username : String) : Call<Int?>
}