package com.example.challengeme.Interfaces.Retrofit

import com.example.challengeme.AsynchronousRequests.asyncResult.RequestResult
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.POST

interface PostLoginCheck {
    @POST("//post")
    //fun isLoginFree(@Field("username") username : String) : Call<Int?>
    fun isLoginFree(
        @Body body: Map<String, String>
    ) : Call<RequestResult>
}