package com.example.challengeme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlin.random.Random

lateinit var tmpObject: HobbyObject
var markers : ArrayList<MapMarker> = ArrayList()
const val LAN = 90
const val LNG = 180

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // создадим временный объект для тестов

         tmpObject =  HobbyObject(getString(R.string.tmp_name), getString(R.string.tmp_category),
                 2, getString(R.string.tmp_description), arrayOf("https://im0-tub-ru.yandex.net/i?id=7bd0fc31f377bc7977dc0ec7dfbe9d54-l&n=13", "https://im0-tub-ru.yandex.net/i?id=2a383e99e452377ef82c17c6afaf78e0-l&n=13","https://im0-tub-ru.yandex.net/i?id=358e938efb5f7f856ba7bc2a5e2fcd15-l&n=13"),
                getString(R.string.tmp_guide), arrayOf("https://youtu.be/AIBFxKRlgE4"),
                 arrayOf(getString(R.string.tmp_ex1), getString(R.string.tmp_ex2)),
                 arrayOf("https://im0-tub-ru.yandex.net/i?id=ad88320989e8f07ccc73669fea98e5f0-l&n=13"))

        /* пока я не знаю, где хранить места, в объекте - слишком тяжело
        т.к он передается целиком в фрагменты
         */

        // временны массив меток

        for (i in 0..5) {
            markers.add(MapMarker((Math.random() * LAN), (Math.random() * LNG),
                "Место $i"))
        }

        // фрагмент менеджер для управления фрагментами

        val fragmentManager = supportFragmentManager

        // подключаем первый фрагмент с самой главной информацией

        var headFragment = fragmentManager.findFragmentById(R.id.head_fragment_layout)
        if (headFragment == null) {
            headFragment = createHeadFragment(tmpObject) // загружаем временный объект
            fragmentManager.beginTransaction()
                .add(R.id.head_fragment_layout,headFragment)
                .commit()
        }

        // подключаем фрагмент с информацией

        var informationFragment = fragmentManager.findFragmentById(R.id.body_fragment_layout)
        if (informationFragment == null) {
            informationFragment = createInformationFragment(tmpObject) // загружаем временный объект
            fragmentManager.beginTransaction()
                .add(R.id.body_fragment_layout, informationFragment)
                .commit()
        }


    }

    fun createHeadFragment(hobbyObject: HobbyObject) : Fragment { // функция создания HeadFragment и передачи объекта
        val item = hobbyObject
        val bundle = Bundle()
        bundle.putParcelable("item",item)
        val fragment = HeadFragment().newFragment()
        fragment.arguments = bundle

        return fragment
    }

    fun createInformationFragment(hobbyObject: HobbyObject) : Fragment {
        val item = hobbyObject
        val bundle = Bundle()
        bundle.putParcelable("item", item)
        bundle.putParcelableArrayList("markers", markers)
        val fragment = InformationFragment().newFragment()
        fragment.arguments = bundle

        return fragment
    }
}
