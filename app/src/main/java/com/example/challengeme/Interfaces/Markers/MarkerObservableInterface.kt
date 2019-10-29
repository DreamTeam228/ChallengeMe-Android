package com.example.challengeme.Interfaces.Markers

interface MarkerObservableInterface {

    fun notifyObservers()
    fun registerObserver(o: MarkerObserverInterface)
    fun deleteObserver(o: MarkerObserverInterface)
}