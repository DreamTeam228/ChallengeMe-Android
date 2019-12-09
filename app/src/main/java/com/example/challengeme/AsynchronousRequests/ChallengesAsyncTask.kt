package com.example.challengeme.AsynchronousRequests

import android.os.AsyncTask
import com.example.challengeme.Interfaces.GetChallenges
import com.example.challengeme.User.UserChallenge
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

class ChallengesAsyncTask : AsyncTask<String, Void, ArrayList<UserChallenge>?>() {

    override fun doInBackground(vararg p0: String?): ArrayList<UserChallenge>? {
        val url = p0[0]
        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val getChallenges: GetChallenges = retrofit.create(GetChallenges::class.java)
        try {
            val challengeObj: Call<ArrayList<UserChallenge>?>? = getChallenges.getChallenges()
            val response: Response<ArrayList<UserChallenge>?> = challengeObj!!.execute()
            return response.body()

        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }

    }
}