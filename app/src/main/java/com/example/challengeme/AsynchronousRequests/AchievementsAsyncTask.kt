package com.example.challengeme.AsynchronousRequests

import android.os.AsyncTask
import com.example.challengeme.Interfaces.GetAchievements
import com.example.challengeme.User.UserAchievement
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

class AchievementsAsyncTask : AsyncTask<String, Void, ArrayList<UserAchievement>?>() {

    override fun doInBackground(vararg p0: String?): ArrayList<UserAchievement>? {
        val url = p0[0]
        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val getChallenges: GetAchievements = retrofit.create(GetAchievements::class.java)
        try {
            val achievementObj: Call<ArrayList<UserAchievement>?>? = getChallenges.getAchievements()
            val response: Response<ArrayList<UserAchievement>?> = achievementObj!!.execute()
            return response.body()

        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }

    }

}