package com.example.challengeme.AsynchronousRequests

import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import androidx.core.content.ContextCompat
import com.example.challengeme.Hobby.HobbyObject
import com.example.challengeme.Interfaces.Retrofit.HobbyApi
import com.example.challengeme.data.globalData.hobbyModel
import com.example.challengeme.ui.MainActivity
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

class HobbyAsyncTask (var context: Context) : AsyncTask<String, Void, HobbyObject?>() {

    override fun doInBackground(vararg p0: String?): HobbyObject? {
        val url = p0[0]
        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val hobbyApi: HobbyApi = retrofit.create(HobbyApi::class.java)
        try {
            val hobbyObj: Call<HobbyObject> = hobbyApi.hobbyObj()
            val response: Response<HobbyObject> = hobbyObj.execute()
            var hobbyObject: HobbyObject? = response.body()
            return hobbyObject!!

        } catch (e: Exception) {
            e.printStackTrace()
            return HobbyObject()
        }

    }

    override fun onPostExecute(result: HobbyObject?) {
        super.onPostExecute(result)
        hobbyModel.instance = result!!
        //var hobbyController: HobbyControllerInterface = HobbyController(result)

        /*val i = Intent(context, MainActivity::class.java)
        i.putExtra(R.string.modelIntent.toString(), result)
        startActivity(context,i, null)*/

        ContextCompat.startActivity(context, Intent(context, MainActivity::class.java), null)

    }
}
