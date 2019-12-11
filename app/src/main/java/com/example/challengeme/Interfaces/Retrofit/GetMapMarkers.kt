package com.example.challengeme.Interfaces.Retrofit

import com.example.challengeme.Markers.MapMarkerObject
import retrofit2.Call
import retrofit2.http.GET

interface GetMapMarkers {
    @GET("//////")
    fun getMapMarkers() : Call<MapMarkerObject>
}