package com.example.challengeme.Interfaces

import com.example.challengeme.User.UserAchievement
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET

interface PostAchievements {
    @GET("//achievements")
    fun postAchievements(
        @Body body: Map<String, Int>
    ) : Call<ArrayList<UserAchievement>?>
}