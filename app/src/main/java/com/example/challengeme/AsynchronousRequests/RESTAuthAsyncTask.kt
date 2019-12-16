package com.example.challengeme.AsynchronousRequests
import android.os.AsyncTask
import android.util.Base64
import com.example.challengeme.data.model.LoggedInUser
import org.springframework.http.*
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.client.RestTemplate

class RESTAuthAsyncTask(val username : String, val password : String) : AsyncTask<String, Void, LoggedInUser>() {
    override fun doInBackground(vararg url: String): LoggedInUser? {
        val url: String = url[0]
        val restTemplate: RestTemplate = RestTemplate()
        try {
            restTemplate.messageConverters.add(MappingJackson2HttpMessageConverter())

            val headers = HttpHeaders()

            val auth = "$username:$password"

            val encodeAuth = Base64.encodeToString(auth.toByteArray(), Base64.DEFAULT)
            val authHeader = "Basic $encodeAuth"
            headers.set("Authorization", authHeader)

            val entity: HttpEntity<String> = HttpEntity(headers)

            val response: ResponseEntity<LoggedInUser> =
                restTemplate.exchange(url, HttpMethod.GET, entity, LoggedInUser::class.java)

            /*response.statusCode
            response.headers
            response.body*/

            return response.body
        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }
    }
}









