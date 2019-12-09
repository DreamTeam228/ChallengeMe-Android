package com.example.challengeme.AsynchronousRequests

import android.os.AsyncTask
import com.example.challengeme.Interfaces.PostRegistrationInterface
import com.example.challengeme.R
import com.example.challengeme.ui.login.RegistrationResult
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

class RegistrationAsyncTask (val username : String, val password : String) : AsyncTask<String, Void, RegistrationResult?>() {

    override fun doInBackground(vararg p0: String?): RegistrationResult? {
        val url = p0[0]
        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val postReg: PostRegistrationInterface = retrofit.create(PostRegistrationInterface::class.java)
        return try {
            val regObj: Call<String> = postReg.createUserLogin(username, password)
            val response: Response<String> = regObj.execute()
            val status: Boolean? = response.isSuccessful

            if(status!!) {
                RegistrationResult(success = R.string.sign_up_success)
            } else {
                RegistrationResult(error = R.string.registration_failed)
            }

        } catch (e: Exception) {
            e.printStackTrace()
            RegistrationResult(error = R.string.registration_failed)
        }

    }

}