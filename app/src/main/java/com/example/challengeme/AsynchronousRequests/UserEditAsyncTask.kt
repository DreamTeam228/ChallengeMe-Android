package com.example.challengeme.AsynchronousRequests

import android.os.AsyncTask
import com.example.challengeme.AsynchronousRequests.asyncResult.AsyncResult
import com.example.challengeme.Interfaces.Retrofit.PostUserEdit
import com.example.challengeme.R
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

class UserEditAsyncTask(val id: Int, val displayName: String?, val login: String?, val password: String?) : AsyncTask<String, Void, AsyncResult>() {
    override fun doInBackground(vararg p0: String?): AsyncResult {
        val url = p0[0]
        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val postEdit: PostUserEdit = retrofit.create(PostUserEdit::class.java)
        return try {
            val regObj: Call<Int> = postEdit.editUser(id, displayName, login, password)
            val response: Response<Int> = regObj.execute()
            val result: Int? = response.body()

            when (result) {
                0 -> {
                    AsyncResult(success = R.string.change_success)
                }
                1 -> {
                    AsyncResult(error = R.string.loginIsTaken_error)
                }
                2 -> {
                    AsyncResult(error = R.string.oldPass_error)
                }
                3 -> {
                    AsyncResult(error = R.string.all_error)
                }
                else -> {
                    throw Exception()
                }
            }

        } catch (e: Exception) {
            e.printStackTrace()
            AsyncResult(error = R.string.error)
        }

    }
}