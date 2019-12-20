package com.example.challengeme.AsynchronousRequests

import android.os.AsyncTask
import com.example.challengeme.AsynchronousRequests.asyncResult.RequestResult
import com.example.challengeme.Interfaces.Retrofit.PostLoginCheck
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

class LoginCheckAsyncTask (val username : String) : AsyncTask<String, Void, Int?>() {

    override fun doInBackground(vararg p0: String?): Int? {
        val url = p0[0]
        val retrofit = Retrofit.Builder()
            .baseUrl(url!!)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val loginCheck: PostLoginCheck = retrofit.create(PostLoginCheck::class.java)
        try {
           //val loginObj: Call<Int?> = loginCheck.isLoginFree(username)
            val loginObj: Call<RequestResult> = loginCheck.isLoginFree(mapOf("username" to username))
           val response: Response<RequestResult> = loginObj.execute()
            val status = response.isSuccessful

            return if(status) {
                1
            } else {
                0
            }

        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }

    }

}