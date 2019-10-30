package com.example.challengeme.Hobby

import android.os.Parcel
import android.os.Parcelable
import com.example.challengeme.Interfaces.Hobby.HobbyObjectInterface
import com.example.challengeme.Interfaces.Hobby.HobbyObservableInterface
import com.example.challengeme.Interfaces.Hobby.HobbyObserverInterface

class HobbyObject
    : HobbyObjectInterface,
    HobbyObservableInterface {

    private lateinit var observers: MutableList<HobbyObserverInterface>
    private lateinit var name: String
    private lateinit var category: String
    private var difficulty: Int = 0
    private lateinit var description:String
    private lateinit var images: ArrayList<String>
    private lateinit var guide:String
    private lateinit var guideVideo: ArrayList<String>
    private lateinit var exercise: ArrayList<String>
    private lateinit var exerciseImage:ArrayList<String>

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

    override fun setGuidevideo(videos: ArrayList<String>) {
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

    override fun getGuidevideo(position: Int): String {
        return this.guideVideo[position]
    }

    override fun getExercise(position: Int): String {
        return this.exercise[position]
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

    override fun notifyObservers() {

        observers.forEachIndexed { _, element ->
            element.update()
        }
    }

    override fun registerObserver(o: HobbyObserverInterface) {
       observers.add(o)
    }

    override fun deleteObserver(o: HobbyObserverInterface) {
        observers.remove(o)
    }

    override fun getData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        /*
        заполняем поля
        после этого уведомляем наблюдателей
        наблюдатели обновляются
        *
         */
    }


    override fun writeToParcel(parcel: Parcel, flags: Int) {
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