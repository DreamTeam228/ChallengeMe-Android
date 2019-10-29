package com.example.challengeme.Hobby

import android.os.Parcel
import android.os.Parcelable
import com.example.challengeme.Interfaces.Hobby.HobbyObjectInterface
import com.example.challengeme.Interfaces.Hobby.HobbyObservableInterface
import com.example.challengeme.Interfaces.Hobby.HobbyObserverInterface

class HobbyObject
    : HobbyObjectInterface,
    HobbyObservableInterface {

    lateinit private var observers: MutableList<HobbyObserverInterface>
    lateinit private var name: String
    lateinit private var category: String
    private var difficulty: Int = 0
    lateinit private var description:String
    lateinit private var images: ArrayList<String>
    lateinit private var guide:String
    lateinit private var guideVideo: ArrayList<String>
    lateinit private var exercise: ArrayList<String>
    lateinit private var exerciseImage:ArrayList<String>

    override fun setName() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setCategory() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setDifficulty() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setDescription() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setImages() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setGuide() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setGuidevideo() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setExercise() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setExerciseImage() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCategory(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getGuidevideo(): ArrayList<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getExercise(): ArrayList<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getExerciseImage(): ArrayList<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun getName(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getDifficulty(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getImages(): ArrayList<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getDescription(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getGuide(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun notifyObservers() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        observers.forEachIndexed { index, element ->
            element.update()
        }
    }

    override fun registerObserver(o: HobbyObserverInterface) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteObserver(o: HobbyObserverInterface) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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