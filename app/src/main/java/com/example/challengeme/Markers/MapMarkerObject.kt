package com.example.challengeme.Markers

import com.example.challengeme.Interfaces.Markers.MarkerModelInterface
import com.example.challengeme.Interfaces.Markers.MarkerObservableInterface
import com.example.challengeme.Interfaces.Markers.MarkerObserverInterface

class MapMarkerObject : MarkerModelInterface,
    MarkerObservableInterface {
    override fun setEducationMarkers() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setShopMarkers() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setRentMarkers() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getEducationMarkers(): List<MapMarker> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getShopMarkers(): List<MapMarker> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getRentMarkers(): List<MapMarker> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun notifyObservers() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun registerObserver(o: MarkerObserverInterface) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteObserver(o: MarkerObserverInterface) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    lateinit private var educationMarkers: List<MapMarker>
    lateinit private var shopMarkers: List<MapMarker>
    lateinit private var rentMarkers: List<MapMarker>
}