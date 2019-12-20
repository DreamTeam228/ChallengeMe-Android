package com.example.challengeme.Interfaces
import com.example.challengeme.AsynchronousRequests.asyncResult.RequestResult
import com.example.challengeme.data.RegistrationData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface PostRegistrationInterface {

    //@FormUrlEncoded
    @POST("androidreg")
    /*fun createUserLogin  (
            @Field("email") name: String,
            @Field ("password") pass: String/*,
            @Field("displayName") displayName: String*/
    ) : Call<String>*/
    /*fun createUserLogin (
        @Body body: RegistrationData
    ) : Call<String>*/

    fun createUserLogin (
        @Body body: Map<String, String>
    ) : Call<RequestResult>
}