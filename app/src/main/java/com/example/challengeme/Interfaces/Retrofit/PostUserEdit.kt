package com.example.challengeme.Interfaces.Retrofit

import com.example.challengeme.AsynchronousRequests.asyncResult.RequestResult
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.POST

interface PostUserEdit {
    @POST("//editUser")
    /*fun editUser(@Field("id") id: Int,
                 @Field("displayName") displayName: String?,
                 @Field("login") login: String?,
                 @Field("password") pass: String?) : Call<Int>*/
    fun editUser(
        @Body body: Map<String, Any?>
    ) : Call<RequestResult>
}
