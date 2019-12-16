package com.example.challengeme.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.challengeme.AsynchronousRequests.MapMarkerAsyncTask
import com.example.challengeme.Hobby.ImageFragment
import com.example.challengeme.Interfaces.Hobby.HobbyObjectInterface
import com.example.challengeme.Markers.MapMarker
import com.example.challengeme.data.globalData.hobbyModel
import com.example.challengeme.data.globalData.mapMarkerModel
import com.example.challengeme.data.globalData.userRepository
import com.example.challengeme.ui.Adapters.VideoAdapter
import com.example.challengeme.ui.login.LoginActivity
import com.example.challengeme.ui.profile.ProfileActivity
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList
import java.text.SimpleDateFormat


var markers : ArrayList<MapMarker> = ArrayList()

// Возможно стоит сделать логинРепозитори глобальным
// Чтобы, например, при переходе в профиль не выпендриваться и сразу работать с имеющимися данными
// Или чтобы брать данные о юзере из кэша в сплэшСкрине


class MainActivity : AppCompatActivity() {

    private val formatter = SimpleDateFormat("dd-MM-yyyy")

    private lateinit var model: HobbyObjectInterface
    private var fragmentManager: FragmentManager = supportFragmentManager

    private lateinit var dateTextView: TextView
    private lateinit var dayCouterTextView: TextView
    private lateinit var nameTextView: TextView
    private lateinit var categoryTextView: TextView
    private lateinit var descriptionTextView: TextView
    private lateinit var guideTextView: TextView
    private lateinit var exerciseTextView: TextView

    private lateinit var difficultBar: RatingBar
    private lateinit var image_pager: ViewPager

    private lateinit var mapButton: Button
    private lateinit var companyButton: Button

    private lateinit var recycler : RecyclerView
    private lateinit var viewAdapter : RecyclerView.Adapter<*>
    private lateinit var viewManager : RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.challengeme.R.layout.activity_main)

        model = hobbyModel.instance
        //this.model = intent.getParcelableExtra(R.string.modelIntent.toString())!!
        findViewElements()
        setViewElements()
    }

    override fun onCreateOptionsMenu (menu: Menu) : Boolean {
        menuInflater.inflate(com.example.challengeme.R.menu.to_profile,menu)
        val goProfile = menu.findItem(com.example.challengeme.R.id.profile)
        // А перед тем, как проверять зарегистрированность юзера, надо проверить, есть ли инфа о нём в кэше
         goProfile.setOnMenuItemClickListener {
             if (userRepository.instance.isLoggedIn)
                 startActivity(Intent(this, ProfileActivity::class.java))
             else startActivity (Intent(this, LoginActivity::class.java))
             true // мы понятия не имеем, зачем, но по-другому не работает
         }
        return true
    }


    // сопоставляем view с элементами Layout'a
    private fun findViewElements() {
        nameTextView = findViewById(com.example.challengeme.R.id.hobby_name_tv)
        dateTextView = findViewById(com.example.challengeme.R.id.date_tv)
        categoryTextView = findViewById(com.example.challengeme.R.id.category_tv)
        difficultBar = findViewById(com.example.challengeme.R.id.difficulty_rb)
        descriptionTextView = findViewById(com.example.challengeme.R.id.description_tv)
        image_pager = findViewById(com.example.challengeme.R.id.image_vp)
        guideTextView = findViewById(com.example.challengeme.R.id.guide_tv)
        exerciseTextView = findViewById(com.example.challengeme.R.id.exercise_tv)
        mapButton = findViewById(com.example.challengeme.R.id.open_map_button)
        companyButton = findViewById(com.example.challengeme.R.id.find_people_button)
        recycler = findViewById<RecyclerView>(com.example.challengeme.R.id.video_recyclerView)

        mapButton.setOnClickListener{
            // думаю надо сделать загрузку мапМаркеров именно тут а не в сплэше
            // что-то мне подсказывает, что загрузка не должна осуществляться во view
            // но я согласна, что в сплэшэ она еще не нужна

           // controller.onMapButtonClick(this)
            if(mapMarkerModel.instance.isDataRecieved())
                startActivity(Intent(this,MapsActivity::class.java))
               // controller.onMapButtonClick(this) мб просто старт активити и избавимся от всехх контроллеров?
                else  {
                MapMarkerAsyncTask().execute(getText(com.example.challengeme.R.string.mapMarkersURL).toString())
                startActivity(Intent(this,MapsActivity::class.java))
            }

        }
        companyButton.setOnClickListener {

            // проверяю логин 
            //startActivity(Intent(this, LoginActivity::class.java))
            if (userRepository.instance.isLoggedIn)
                startActivity(Intent(this, ProfileActivity::class.java))
            else startActivity (Intent(this, LoginActivity::class.java))

        }
    }
    // заполняем view
    private fun setViewElements() {
        nameTextView.text = model.getName()
        categoryTextView.text = model.getCategory()
        difficultBar.rating = model.getDifficulty().toFloat()
        descriptionTextView.text = model.getDescription()
        dateTextView.text = formatter.format(Date())
        image_pager.adapter = PagerAdapter(fragmentManager)
        guideTextView.text = model.getGuide()

        val strBuilder = StringBuilder()
        for(i in 0 until model.getExercises().size) {
            strBuilder.append("${i + 1}. ${model.getExercise(i)}\n")
        }
        exerciseTextView.text = strBuilder


        viewManager = LinearLayoutManager(this)
        viewAdapter = VideoAdapter(this, model.getVideoArray(), lifecycle)

        recycler.apply {
            recycler.adapter = viewAdapter
            recycler.layoutManager = viewManager
        }

    }

    inner class PagerAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(fm!!) {
        override fun getItem(position: Int): Fragment {
            val image = model.getImages(position)
            val bundle = Bundle()
            bundle.putString("image", image)
            val imageFragment = ImageFragment().createFragment()
            imageFragment.arguments = bundle
            return imageFragment
        }

        override fun getCount(): Int {
            return model.getImageSize()
        }

    }

}