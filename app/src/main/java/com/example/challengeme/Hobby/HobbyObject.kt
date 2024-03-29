package com.example.challengeme.Hobby

import android.os.Parcel
import android.os.Parcelable
import com.example.challengeme.Interfaces.Hobby.HobbyObjectInterface

class HobbyObject
    : HobbyObjectInterface {

    /*
    Существует проблема передачи объекта через интент -
    после передачи - это уже другой объект
    поэтому выдвигаю предложение сделать модель Синглтоном
    таким образом в интенте будем передаваться ссылка
    на нашу модель, вместо копии

    либо объявить ее internal и обращаться, но это как-то bad practice
     */

    private var id: Int = 0
    private var name: String = "Name"
    private var category: String = "Category"
    private var difficulty: Int = 5
    private var description:String = "Description"
    private var images: ArrayList<String> = ArrayList()
    private var guide:String = "Guide"
    private var guideVideo: ArrayList<String> = ArrayList()
    private var exercise: ArrayList<String> = ArrayList()
    private var exerciseImage:ArrayList<String> = ArrayList()

    override fun setName(str: String) {
        this.name = str
    }

    override fun setCategory(str: String) {
        this.category = str
    }

    override fun setDifficulty(level: Int) {
        if (level in 1..5)
        this.difficulty = level
        else this.difficulty = 2
    }

    override fun setDescription(str: String) {
        this.description = str
    }

    override fun setImages(images: ArrayList<String>) {
        this.images = images
    }

    override fun setGuide(str: String) {
        this.guide = str
    }

    override fun setGuideVideo(videos: ArrayList<String>) {
       this.guideVideo = videos
           }

    override fun setExercise(exes: ArrayList<String>) {
        this.exercise = exes
    }

    override fun setExerciseImage(exesImages: ArrayList<String>) {
        this.exerciseImage = exesImages
    }


    override fun getImageSize(): Int {
        return this.images.size
    }
    override fun getGuideVideoSize(): Int {
        return this.guideVideo.size
    }
    override fun getExecImageSize(): Int {
        return this.exerciseImage.size
    }


    override fun getCategory(): String {
        return this.category
    }

    override fun getGuideVideo(position: Int): String {
        return this.guideVideo[position]
    }

    override fun getVideoArray(): ArrayList<String> {
        return this.guideVideo
    }

    override fun getExercise(position: Int): String {
        return this.exercise[position]
    }

    override fun getExercises(): ArrayList<String> {
        return this.exercise
    }

    override fun getExerciseImage(position: Int): String {
        return this.exerciseImage[position]
    }


    override fun getName(): String {
        return this.name
    }

    override fun getDifficulty(): Int {
       return this.difficulty
    }

    override fun getImages(position: Int): String {
        return this.images[position]
    }

    override fun getDescription(): String {
        return this.description
    }

    override fun getGuide(): String {
        return this.guide
    }

    override fun getData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setData(id: Int,
                         name: String,
                         category: String,
                         difficulty: Int,
                         description:String,
                         images: ArrayList<String>,
                         guide:String,
                         guideVideo: ArrayList<String>,
                         exercise: ArrayList<String>,
                         exerciseImage:ArrayList<String>) {

        /*
        заполняем поля
        после этого уведомляем наблюдателей
        наблюдатели обновляются
        *
         */

        setName(name)
        setCategory(category)
        setDifficulty(difficulty)
        setDescription(description)
        setImages(images)
        setGuide(guide)
        setGuideVideo(guideVideo)
        setExercise(exercise)
        setExerciseImage(exerciseImage)

    }


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(category)
        parcel.writeInt(difficulty)
        parcel.writeString(description)
        parcel.writeStringList(images)
        parcel.writeString(guide)
        parcel.writeStringList(guideVideo)
        parcel.writeStringList(exercise)
        parcel.writeStringList(exerciseImage)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<HobbyObject> {
        override fun createFromParcel(parcel: Parcel): HobbyObject {

            return HobbyObject()
        }

        override fun newArray(size: Int): Array<HobbyObject?> {
            return arrayOfNulls(size)
        }
    }
}