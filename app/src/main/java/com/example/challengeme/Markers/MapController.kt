package com.example.challengeme.Markers


import com.example.challengeme.Interfaces.Markers.MapControllerInterface

class MapController(private val model: MapMarkerObject) : MapControllerInterface {


    override fun showRent() {
        val markers = model.getRentMarkers()
        // вызываем changeMarkers в MapsActivity

    }

    override fun showShop() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showEdu() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getInfo() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}