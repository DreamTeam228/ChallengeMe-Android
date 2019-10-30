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
    fun getImages(position: Int) : String
    fun getGuide(): String
    fun getGuidevideo(position: Int) : String
    fun getExercise(position: Int): String
    fun getExerciseImage(position: Int): String
    fun getImageSize(): Int
    fun getGuideVideoSize(): Int
    fun getExecImageSize(): Int


    fun setName(str:String)
    fun setCategory(str:String)
    fun setDifficulty(level: Int)
    fun setDescription(str:String)
    fun setImages(images: ArrayList<String>)
    fun setGuide(str: String)
    fun setGuidevideo(videos: ArrayList<String>)
    fun setExercise(exes: ArrayList<String>)
    fun setExerciseImage(exesImages: ArrayList<String>)


}