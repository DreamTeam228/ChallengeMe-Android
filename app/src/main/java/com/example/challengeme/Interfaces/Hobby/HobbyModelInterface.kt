package com.example.challengeme.Interfaces.Hobby

import java.util.*
import kotlin.collections.ArrayList

interface HobbyModelInterface {
    /*
    * private val name: String,
                   private val category: String,
                   private val difficulty: Int,
                   private val description:String,
                   private val images: Array<String>,
                   private val guide:String,
                   private val guideVideo: Array<String>,
                   private val exercise: Array<String>,
                   private val exerciseImage:Array<String>)*/
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