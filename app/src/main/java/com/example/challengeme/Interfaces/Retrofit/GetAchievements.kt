package com.example.challengeme.Interfaces

import com.example.challengeme.User.UserAchievement
import retrofit2.Call
import retrofit2.http.GET

interface GetAchievements {
    @GET("//achievements")
    fun getAchievements() : Call<ArrayList<UserAchievement>?>?
}