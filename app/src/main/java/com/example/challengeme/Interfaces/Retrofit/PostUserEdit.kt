package com.example.challengeme.Interfaces.Retrofit

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.POST

interface PostUserEdit {
    @POST("//editUser")
    fun editUser(@Field("id") id: Int,
                 @Field("displayName") displayName: String?,
                 @Field("login") login: String?,
                 @Field("password") pass: String?) : Call<Int>
}
