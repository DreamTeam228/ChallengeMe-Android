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
            result.setEducationMarkers(arrayListOf(
                MapMarker(55.7417793, 37.61886679999998,"Студия рисования CANVAS на пер. Малый Толмачёвский, д. 10.", "edu","Улица кукушкина"),
                MapMarker(55.729602, 37.63297460000001,"Школа рисования для взрослых «А-ля Прима»  ул. Зацепа, д. 21 ", "edu","Улица кукушкина"),
                MapMarker(55.7973063, 37.496627399999966,"Студия Art of You ул. Маршала Рыбалко, д. 2, корп. 8 ", "edu","Улица кукушкина")
                ))
            result.setShopMarkers(arrayListOf(
                MapMarker(55.8503501, 37.44459640000002,"Леонардо на ул. Сходненская, д. 56", "shop","Улица прокукушкина"),
                MapMarker(55.6127692, 37.605507999999986,"Леонардо на ул.Кировоградская, д.13А", "shop","Улица прокукушкина"),
                MapMarker(55.7446675, 37.56589370000006,"Леонардо площадь Киевского вокзала, д.2", "shop","Улица прокукушкина"),
                MapMarker(55.6269294, 37.711880000000065,"Леонардо Каширское шоссе, д. 61Г", "shop","Улица прокукушкина")
                ))
            result.setRentMarkers(arrayListOf())
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