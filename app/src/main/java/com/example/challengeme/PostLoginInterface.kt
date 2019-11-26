package com.example.challengeme

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface PostLoginInterface {

    @FormUrlEncoded
    @POST("//here will be a post path")
    fun checkUserLogin  (
            @Field("username") name: String,
            @Field ("password") pass: String
    ) : Call<String>

}