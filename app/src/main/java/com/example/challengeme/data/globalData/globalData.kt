package com.example.challengeme.data.globalData

import com.example.challengeme.Hobby.HobbyObject
import com.example.challengeme.Markers.MapMarkerObject
import com.example.challengeme.data.LoginDataSource
import com.example.challengeme.data.LoginRepository

object userRepository{
    private var userRepository : LoginRepository? = null

    var instance: LoginRepository
        get() {
            if(userRepository == null) userRepository = LoginRepository(LoginDataSource())
            return userRepository!!
        }
        set(userRepository : LoginRepository) {
            this.userRepository = userRepository
        }
}


object hobbyModel{
    private var model : HobbyObject? = null

    var instance: HobbyObject
        get() {
            if (model == null) model = HobbyObject()
            return model!!
        }
        set(hobbyObj : HobbyObject) {
            model = hobbyObj
        }
}

object mapMarkerModel {
    private var mapMarkerModel : MapMarkerObject? = null

    var instance : MapMarkerObject
    get() {
        if(mapMarkerModel == null) mapMarkerModel = MapMarkerObject()
        return mapMarkerModel!!
    } set(model : MapMarkerObject) {
        mapMarkerModel = model
    }
}

