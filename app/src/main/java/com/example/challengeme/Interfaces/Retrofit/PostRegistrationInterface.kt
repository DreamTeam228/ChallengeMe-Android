package com.example.challengeme.Interfaces
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface PostRegistrationInterface {

    @FormUrlEncoded
    @POST("androidreg")
    fun createUserLogin  (
            @Field("email") name: String,
            @Field ("password") pass: String/*,
            @Field("displayName") displayName: String*/
    ) : Call<String>
}