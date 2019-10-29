package com.example.challengeme.Hobby

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.challengeme.Interfaces.Hobby.HobbyControllerInterface
import com.example.challengeme.Interfaces.Hobby.HobbyModelInterface
import com.example.challengeme.Markers.MapMarker
import com.example.challengeme.R

lateinit var tmpObject: HobbyObject
var markers : ArrayList<MapMarker> = ArrayList()
const val LAN = 90
const val LNG = 180

class MainActivity : AppCompatActivity() {
    lateinit var image_pager: ViewPager
    lateinit var model: HobbyModelInterface
    lateinit var controller: HobbyControllerInterface
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val fragmentManager = supportFragmentManager
        image_pager.adapter = PagerAdapter(fragmentManager)

    }

    inner class PagerAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {
        override fun getItem(position: Int): Fragment {
            val images: ArrayList<String> = model.getImages()
            val image: String = images[position]
            val bundle = Bundle()
            bundle.putString("image", image)
            val imageFragment = ImageFragment().createFragment()
            imageFragment.arguments = bundle
            return imageFragment
        }

        override fun getCount(): Int {
            val images = model.getImages()
            return images.size
        }

    }
}
