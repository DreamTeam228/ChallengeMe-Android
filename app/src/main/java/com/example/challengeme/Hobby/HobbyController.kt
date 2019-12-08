package com.example.challengeme.Hobby

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import com.example.challengeme.Interfaces.Hobby.HobbyControllerInterface
import com.example.challengeme.Interfaces.Hobby.HobbyObjectInterface
import com.example.challengeme.Interfaces.Markers.MapMarkerObjectInterface
import com.example.challengeme.ui.MapsActivity
import com.example.challengeme.R
import com.example.challengeme.ui.MainActivity

// private const val INTENT_TAG = "model" - R.string.modelIntent

class HobbyController(private val model: HobbyObjectInterface) : HobbyControllerInterface {

    // Думаю, для удосбтва можно было бы создаать универсальный контроллер,
    // раз мы из Мэйн все равно везде попадаем,
    // и по этой причине у нас уже есть все модели

    private lateinit var mapModel: MapMarkerObjectInterface     // Где-то ее еще нужно заполнить

    // Вот это было бы универсальным решением, идея -
    // - передавать в агрументы откуда переходим и куда
    // В таком случае можно было бы переходить и из Сплэша, и из Мэйн
    /*override fun startNewActivity(from: Context, to: Activity) {
        val i = Intent(from, to::class.java)
        i.putExtra(INTENT_TAG, model)
        // единственная проблема - мы передаем разную модель
        // для карты - модель МарМодель
        // для пользователя, думаю, будет тоже своя
        startActivity(from, i, null)
    }*/


    override fun onLoadingComplete(context: Context) {
        val intent = Intent(context, MainActivity::class.java)
        // модель можно и через bundle передавать, вроде
        intent.putExtra(R.string.modelIntent.toString(), model)
        startActivity(context, intent, null)

    }

    override fun onMapButtonClick(context: Context) {
        //var mapMarkersModel: MapMarkerObjectInterface = MapMarkerObject()       // Пожалуй стоит сделать это при нажатии на мапБаттон

        val intent = Intent(context, MapsActivity::class.java)
        intent.putExtra(R.string.mapIntent.toString(),mapModel)
        // модель можно и через bundle передавать, вроде
        startActivity(context, intent, null)

    }

    override fun onCompanyButtonClick() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onProfileButtonClick() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}