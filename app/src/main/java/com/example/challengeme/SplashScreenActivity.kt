package com.example.challengeme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import com.example.challengeme.Hobby.HobbyObject


class SplashScreenActivity : AppCompatActivity() {

    lateinit var loadingLine: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        loadingLine = findViewById(R.id.progressBar)
        //var hobbyModel: HobbyObjectInterface = HobbyObject()

        /*
        Контроллер создает представление ?
        Или контроллер создается в представлении ?
         */


        /*
        А заполнять модели мы тоже будем через контроллер?
        Вроде, мвс не разрешает делать такие вещи в представлениях
         */

        /* Асинхронная подрузка жисона ретрофитом

        hobbyObj.enqueue(Callback<HobbyObject> {
           override fun onResponse(call: Call<List<HobbyObject>>, response: Response<List<HobbyObject>>) {
                //log("response " + response.body().size())
            }

           override fun onFailure(call: Call<List<HobbyObject>>, t: Throwable) {

            }
        })

         */

        val retrAsyncTask = RetroAsyncTask(this)
        retrAsyncTask.execute("http://188.225.46.84")


    }



    companion object {
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

}
