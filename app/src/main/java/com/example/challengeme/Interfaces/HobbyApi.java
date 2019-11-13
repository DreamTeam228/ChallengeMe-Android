package com.example.challengeme.Interfaces;

import com.example.challengeme.Hobby.HobbyObject;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HobbyApi {

    @GET ("json")
    Call<HobbyObject> hobbyObj();

}
