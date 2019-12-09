package com.example.challengeme.Interfaces

import com.example.challengeme.User.UserChallenge
import retrofit2.Call
import retrofit2.http.GET

interface GetChallenges {
    @GET("//give me challenges mazfck")
    fun getChallenges(): Call<ArrayList<UserChallenge>?>?
}