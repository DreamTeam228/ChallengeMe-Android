package com.example.challengeme.Interfaces.Hobby

interface HobbyObservableInterface {

    fun notifyObservers()
    fun registerObserver(o: HobbyObserverInterface)
    fun deleteObserver(o: HobbyObserverInterface)
}