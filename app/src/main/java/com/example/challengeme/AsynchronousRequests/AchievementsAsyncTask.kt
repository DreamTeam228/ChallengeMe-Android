package com.example.challengeme.AsynchronousRequests

import android.os.AsyncTask
import com.example.challengeme.User.UserAchievement
import java.lang.Exception

class AchievementsAsyncTask(val id: Int) : AsyncTask<String, Void, ArrayList<UserAchievement>?>() {

    override fun doInBackground(vararg p0: String?): ArrayList<UserAchievement>? {
        /*val url = p0[0]
        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
*/
        //val postChallenges: GetAchievements = retrofit.create(GetAchievements::class.java)
        try {
            //val achievementObj: Call<ArrayList<UserAchievement>?> = postChallenges.postAchievements()
            /*val achievementObj = postChallenges.postAchievements()
            val response: Response<ArrayList<UserAchievement>?> = achievementObj.execute()
            return response.body()*/


            // ЖДЁМ СЕРВЕРМЭНА НЕ ЗАБЫВАЕМ СТЕРЕТЬ
            val userAchievement = UserAchievement()
            userAchievement.id = 0
            userAchievement.name = "Сдай курсач вовремя"
            userAchievement.description = "о, да вы красавчик"
            userAchievement.image = "https://pbs.twimg.com/profile_banners/819426580606881793/1545042538/1500x500"
            val result = arrayListOf(userAchievement, userAchievement, userAchievement)
            return result
            // ЖДЁМ СЕРВЕРМЭНА НЕ ЗАБЫВАЕМ СТЕРЕТЬ
            // И ВООБЩЕ НЕПЛОХО БЫ ЗАБИВАТЬ ГДЕ-НИТЬ ДЕФОЛТНЫМИ ЗНАЧЕНИЯМИ, ИБО АДАПТЕР ДАВИТСЯ ПУСТОТОй

        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }

    }

}