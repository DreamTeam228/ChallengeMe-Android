package com.example.challengeme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import com.example.challengeme.Hobby.HobbyObject
import com.example.challengeme.Hobby.MainActivity
import com.example.challengeme.Interfaces.Hobby.HobbyObjectInterface

class SplashScreenActivity : AppCompatActivity() {

    lateinit var loadingLine: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        loadingLine = findViewById(R.id.progressBar)
        var hobbyModel: HobbyObjectInterface = HobbyObject()

        /*
        Контроллер создает представление ?
        Или контроллер создается в представлении ?
         */


        /*
        А заполнять модели мы тоже будем через контроллер?
        Вроде, мвс не разрешает делать такие вещи в представлениях
         */

        //var hobbyController: HobbyControllerInterface = HobbyController(hobbyModel)
        val i = Intent(this, MainActivity::class.java)
        i.putExtra(R.string.modelIntent.toString(), hobbyModel)
        startActivity(i)

    }



}
