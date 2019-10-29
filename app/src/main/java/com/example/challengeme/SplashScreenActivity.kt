package com.example.challengeme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.challengeme.Hobby.HobbyObject
import com.example.challengeme.Interfaces.Hobby.HobbyModelInterface
import com.example.challengeme.Interfaces.Markers.MarkerModelInterface
import com.example.challengeme.Markers.Markers

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        var HobbyModel: HobbyModelInterface = HobbyObject()
        var MapMarkersModel: MarkerModelInterface = Markers()
    }

}
