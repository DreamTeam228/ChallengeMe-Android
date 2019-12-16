package com.example.challengeme.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import com.example.challengeme.R
import com.example.challengeme.AsynchronousRequests.HobbyAsyncTask
import com.example.challengeme.data.globalData.userRepository


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

        loadUser()

        val retrAsyncTask =
            HobbyAsyncTask(this)
        retrAsyncTask.execute(getText(R.string.standardUrl).toString())


    }

    private fun loadUser() {
        val pref = getSharedPreferences(getText(R.string.userCache).toString(), Context.MODE_PRIVATE)
        val login = pref.getString(getText(R.string.userCacheLogin).toString(), null)
        val password = pref.getString(getText(R.string.userCachePassword).toString(), null)

        if(login != null && password != null) {
            userRepository.instance.login(login, password)
        }
        // УБРАТЬ НЕ ЗАБЫТЬ !!!!!!!!!
        else {
            userRepository.instance.setLoggedInUserNoInternet()
        }
        // ДО СЮДА!!!

        // Если логин и пароль != 0, отправляем пост-запрос на сервер
        // Если возвращается значение - собираем юзера в репозитории (userRepository.login(login, password))
        // Если нулл - ничего не делаем
    }
}
