package com.example.challengeme.Interfaces.Hobby

import android.os.Parcelable

import kotlin.collections.ArrayList

interface HobbyObjectInterface : Parcelable {

    fun getData()
    fun setData()

    fun getName() : String
    fun getCategory(): String
    fun getDifficulty() : Int
    fun getDescription() : String
    fun getImages() : ArrayList<String>
    fun getGuide(): String
    fun getGuidevideo() : ArrayList<String>
    fun getExercise(): ArrayList<String>
    fun getExerciseImage(): ArrayList<String>


    fun setName()
    fun setCategory()
    fun setDifficulty()
    fun setDescription()
    fun setImages()
    fun setGuide()
    fun setGuidevideo()
    fun setExercise()
    fun setExerciseImage()


}