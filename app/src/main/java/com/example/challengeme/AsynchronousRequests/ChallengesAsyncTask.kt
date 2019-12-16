package com.example.challengeme.AsynchronousRequests

import android.os.AsyncTask
import com.example.challengeme.Interfaces.GetChallenges
import com.example.challengeme.User.UserAchievement
import com.example.challengeme.User.UserChallenge
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

class ChallengesAsyncTask : AsyncTask<String, Void, ArrayList<UserChallenge>?>() {

    override fun doInBackground(vararg p0: String?): ArrayList<UserChallenge>? {
        /*val url = p0[0]
        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()*/

        //val getChallenges: GetChallenges = retrofit.create(GetChallenges::class.java)
        try {
            /*val challengeObj: Call<ArrayList<UserChallenge>?>? = getChallenges.getChallenges()
            val response: Response<ArrayList<UserChallenge>?> = challengeObj!!.execute()
            return response.body()*/


            // ЖДЁМ СЕРВЕРМЭНА НЕ ЗАБЫВАЕМ СТЕРЕТЬ
            val userChallenge = UserChallenge()
            userChallenge.id = 0
            userChallenge.name = "Убеги от Некита за рулём"
            userChallenge.difficulty = 4
            userChallenge.image = "https://avatars.mds.yandex.net/get-pdb/34158/a7ca4842-b60a-48b5-b062-3be63e4dd18c/s1200"
            val result = arrayListOf(userChallenge, userChallenge, userChallenge)
            return result
            // ЖДЁМ СЕРВЕРМЭНА НЕ ЗАБЫВАЕМ СТЕРЕТЬ
            // И ВООБЩЕ НЕПЛОХО БЫ ЗАБИВАТЬ ГДЕ-НИТЬ ДЕФОЛТНЫМИ ЗНАЧЕНИЯМИ, ИБО АДАПТЕР ДАВИТСЯ ПУСТОТОй

        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }

    }
}