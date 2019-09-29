package com.example.challengeme

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.VideoView
import androidx.fragment.app.Fragment

class InformationFragment : Fragment() {
    lateinit var item : HobbyObject
    lateinit var  description_tv : TextView
    lateinit var guide_tv: TextView
    lateinit var exercise_tv: TextView
    lateinit var videoGuide_vv: VideoView // скорее всего для видео тоже будет отдельный фрагмент позже

    fun newFragment() : InformationFragment { // функция создания нового фрагмента
        return InformationFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle: Bundle? = this.arguments // получаем объект через "интент" для фрагментов
        if (bundle != null) {
            item = bundle.getParcelable("item")!!
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

        description_tv.text = item.description
        guide_tv.text = item.guide
        for ( i in item.exercise)
            exercise_tv.text = "${exercise_tv.text}$i\n"

        return view

    }
}