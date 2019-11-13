package com.example.challengeme

import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.util.Base64
import androidx.core.content.ContextCompat.startActivity
import com.example.challengeme.Hobby.HobbyController
import com.example.challengeme.Hobby.HobbyObject
import com.example.challengeme.Hobby.MainActivity
import com.example.challengeme.Interfaces.Hobby.HobbyControllerInterface
import com.example.challengeme.Interfaces.HobbyApi
import org.springframework.http.*
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.client.RestTemplate
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.lang.Exception

class RESTTask : AsyncTask<String, Void, ResponseEntity<HobbyObject>>() {
    override fun doInBackground(vararg url: String): ResponseEntity<HobbyObject>? {
        val url: String = url[0]
        val restTemplate: RestTemplate = RestTemplate()
        try {
            restTemplate.messageConverters.add(MappingJackson2HttpMessageConverter())

            val headers: HttpHeaders = HttpHeaders()

            val auth: String = "Login" + ":" + "Password"

            val encodeAuth = Base64.encodeToString(auth.toByteArray(), Base64.DEFAULT)
            val authHeader: String = "Basic $encodeAuth"
            headers.set("Authorization", authHeader)

            val entity: HttpEntity<String> = HttpEntity<String>(headers)

            val response: ResponseEntity<HobbyObject> =
                restTemplate.exchange(url, HttpMethod.GET, entity, HobbyObject::class.java)

            return response
        } catch (e: IOException) {
            e.printStackTrace()
            return null
        }

    }

        override fun onPostExecute(result: ResponseEntity<HobbyObject>?) {
            super.onPostExecute(result)
            val statusCode : HttpStatus  = result!!.statusCode
            val model = result.body


        }

    }

class RetroAsyncTask (var context: Context) : AsyncTask<String, Void, HobbyObject?>() {

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
            return null
        }

    }

    override fun onPostExecute(result: HobbyObject?) {
        super.onPostExecute(result)
        //var hobbyController: HobbyControllerInterface = HobbyController(result)
        val i = Intent(context, MainActivity::class.java)
        i.putExtra(R.string.modelIntent.toString(), result)
        startActivity(context,i, null)

    }
}

