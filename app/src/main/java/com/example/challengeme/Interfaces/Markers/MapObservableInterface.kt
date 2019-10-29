package com.example.challengeme.Interfaces.Markers

interface MapObservableInterface {

    fun notifyObservers()
    fun registerObserver(o: MapObserverInterface)
    fun deleteObserver(o: MapObserverInterface)
}