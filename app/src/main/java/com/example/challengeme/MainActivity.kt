package com.example.challengeme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

lateinit var tmpObject: HobbyObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         tmpObject =  HobbyObject("Катание на роликах", "Спорт",
                 2, "Это тапочки с колесами", arrayOf("https://im0-tub-ru.yandex.net/i?id=7bd0fc31f377bc7977dc0ec7dfbe9d54-l&n=13"),
                "Встань и оттолкнись", arrayOf("https://youtu.be/AIBFxKRlgE4"),
                 arrayOf("1. Попробуйте сделать змейку", "2. Попробуйте резко повернуть"),
                 arrayOf("https://im0-tub-ru.yandex.net/i?id=ad88320989e8f07ccc73669fea98e5f0-l&n=13"))
        val fragmentManager = supportFragmentManager
        var fragment = fragmentManager.findFragmentById(R.id.fragment_layout)
        if (fragment == null) {
            fragment = createFragment()
            fragmentManager.beginTransaction()
                .add(R.id.fragment_layout,fragment)
                .commit()
        }


    }

    fun createFragment() : Fragment {
        val item = tmpObject
        val bundle = Bundle()
        bundle.putParcelable("item",item)
        val fragment = HeadFragment().newFragment()
        fragment.arguments = bundle

        return fragment
    }
}
