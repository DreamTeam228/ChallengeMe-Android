package com.example.challengeme.AsynchronousRequests

import android.os.AsyncTask
import com.example.challengeme.AsynchronousRequests.asyncResult.AsyncResult
import com.example.challengeme.Interfaces.PostRegistrationInterface
import com.example.challengeme.R
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

class RegistrationAsyncTask (val email : String, val password : String, val displayName: String) : AsyncTask<String, Void, AsyncResult?>() {

    override fun doInBackground(vararg p0: String?): AsyncResult? {
        val url = p0[0]
        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val postReg: PostRegistrationInterface = retrofit.create(PostRegistrationInterface::class.java)
        return try {
            val regObj: Call<String> = postReg.createUserLogin(email, password/*, displayName*/)
           val body = regObj.request().body()
            val response: Response<String> = regObj.execute()
            val status: Boolean? = response.isSuccessful

            if(status!!) {
                AsyncResult(success = R.string.sign_up_success)
            } else {
                AsyncResult(error = R.string.registration_failed)
            }

        } catch (e: Exception) {
            e.printStackTrace()
            AsyncResult(error = R.string.registration_failed)
        }

    }

}