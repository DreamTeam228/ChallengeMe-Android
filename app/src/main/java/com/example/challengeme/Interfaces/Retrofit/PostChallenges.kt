package com.example.challengeme.Interfaces

import com.example.challengeme.User.UserChallenge
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET

interface PostChallenges {
    @GET("//give me challenges mazfck")
    fun postChallenges(
        @Body body: Map<String, Int>
    ): Call<ArrayList<UserChallenge>?>
}