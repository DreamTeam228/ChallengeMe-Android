package com.example.challengeme

import android.os.AsyncTask
import android.util.Base64
import com.example.challengeme.Hobby.HobbyObject
import org.springframework.http.*
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.client.RestTemplate
import java.io.IOException

class RESTTask : AsyncTask<String, Void, ResponseEntity<HobbyObject>>() {
    override fun doInBackground(vararg url: String): ResponseEntity<HobbyObject> {
        val url : String = url[0]
        val restTemplate : RestTemplate = RestTemplate()
        try {
            restTemplate.messageConverters.add(MappingJackson2HttpMessageConverter())

            val headers : HttpHeaders = HttpHeaders()

            val auth : String = "Login" + ":" + "Password"

            val encodeAuth = Base64.encodeToString(auth.toByteArray(), Base64.DEFAULT)
            val authHeader : String = "Basic $encodeAuth"
            headers.set("Authorization", authHeader)

            val entity : HttpEntity<String> = HttpEntity<String>(headers)

            val response : ResponseEntity<HobbyObject> = restTemplate.exchange(url, HttpMethod.GET, entity, HobbyObject::class.java)

            return response
        } catch (e : IOException) {
            e.printStackTrace()
        }

        override fun onPostExecute(result: ResponseEntity<HobbyObject>?) {
            super.onPostExecute(result)
            val statusCode : HttpStatus 
        }

    }

}