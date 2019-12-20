package com.example.challengeme.AsynchronousRequests

import android.os.AsyncTask
import com.example.challengeme.Markers.MapMarker
import com.example.challengeme.Markers.MapMarkerObject
import com.example.challengeme.data.globalData.mapMarkerModel
import java.lang.Exception

class MapMarkerAsyncTask : AsyncTask<String, Void, Unit>() {

    override fun doInBackground(vararg p0: String?) {
        //val url = p0[0]
       /* val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val getMapMarkers: GetMapMarkers = retrofit.create(GetMapMarkers::class.java)*/
        try {/*
            val markersObj: Call<MapMarkerObject>? = getMapMarkers.getMapMarkers()
            val response: Response<MapMarkerObject> = markersObj!!.execute()
            val result = response.body()*/
            val result = MapMarkerObject()
            result.setEducationMarkers(arrayListOf(MapMarker(34.6, 45.8,"Edu", "edu","Улица кукушкина")))
            result.setShopMarkers(arrayListOf(MapMarker(20.6, 10.8,"Shopu", "shop","Улица прокукушкина")))
            result.setRentMarkers(arrayListOf(MapMarker(4.6, -45.8,"Rent", "rent","Улица закукушкина")))
            if(result != null) {
                mapMarkerModel.instance = result
            } else {
                throw Exception()
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}