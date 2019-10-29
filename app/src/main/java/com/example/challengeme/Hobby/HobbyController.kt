package com.example.challengeme.Hobby

import com.example.challengeme.Interfaces.Hobby.HobbyControllerInterface
import com.example.challengeme.Interfaces.Hobby.HobbyObjectInterface

//private val INTENT_TAG = "model"

class HobbyController(private val model: HobbyObjectInterface) : HobbyControllerInterface {

    /*override fun startNewActivity(from: Context, to: Activity) {
        val i = Intent(from, to::class.java)
        i.putExtra(INTENT_TAG, model)
        startActivity(from, i, null)
    }*/


    override fun onMapButtonClick() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCompanyButtonClick() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onProfileButtonClick() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}