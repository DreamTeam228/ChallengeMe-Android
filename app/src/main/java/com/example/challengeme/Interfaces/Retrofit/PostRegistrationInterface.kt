package com.example.challengeme.Interfaces
import com.example.challengeme.ui.login.RegistrationResult
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface PostRegistrationInterface {

    @FormUrlEncoded
    @POST("registration")
    fun createUserLogin  (
            @Field("username") name: String,
            @Field ("password") pass: String,
            @Field("displayName") displayName: String
    ) : Call<String>
}