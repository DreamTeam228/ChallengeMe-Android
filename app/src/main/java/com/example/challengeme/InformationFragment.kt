package com.example.challengeme

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.VideoView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.information_fragment_body.view.*

class InformationFragment : Fragment() {
    lateinit var item : HobbyObject
    lateinit var markers: ArrayList<MapMarker>
    lateinit var  description_tv : TextView
    lateinit var guide_tv: TextView
    lateinit var exercise_tv: TextView
    lateinit var image_pager: ViewPager
    lateinit var open_map: Button


    fun newFragment() : InformationFragment { // функция создания нового фрагмента
        return InformationFragment()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle: Bundle? = this.arguments // получаем объект через "интент" для фрагментов
        if (bundle != null) {
            item = bundle.getParcelable("item")!!
            markers = bundle.getParcelableArrayList<MapMarker>("markers")!!
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.information_fragment_body, container, false)

        description_tv = view.findViewById(R.id.description_tv)
        guide_tv = view.findViewById(R.id.guide_tv)
        exercise_tv = view.findViewById(R.id.exercise_tv)
        image_pager = view.findViewById(R.id.image_vp)

        val fm = childFragmentManager
        val adapter = PagerAdapter(fm)
        image_pager.adapter = adapter

        description_tv.text = item.description
        guide_tv.text = item.guide
        for ( i in item.exercise)
            exercise_tv.text = "${exercise_tv.text}$i\n"

        open_map = view.findViewById(R.id.open_map_button)
        open_map.setOnClickListener {
            val openMap = Intent(it.context,MapsActivity::class.java)
            openMap.putExtra("markers",markers)
            startActivity(openMap)
        }
        return view

    }

    inner class PagerAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {
        override fun getItem(position: Int): Fragment {
            val image: String = item.images[position]
            val bundle = Bundle()
            bundle.putString("image", image)
            val imageFragment = ImageFragment().createFragment()
            imageFragment.arguments = bundle
            return imageFragment
        }

        override fun getCount(): Int {
            return item.images.size
        }

    }
}