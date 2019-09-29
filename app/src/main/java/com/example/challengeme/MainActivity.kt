package com.example.challengeme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

lateinit var tmpObject: HobbyObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // создадим временный объект для тестов

         tmpObject =  HobbyObject("Катание на роликах", "Спорт",
                 2, "Это тапочки с колесами", arrayOf("https://im0-tub-ru.yandex.net/i?id=7bd0fc31f377bc7977dc0ec7dfbe9d54-l&n=13"),
                "Встань и оттолкнись", arrayOf("https://youtu.be/AIBFxKRlgE4"),
                 arrayOf("1. Попробуйте сделать змейку", "2. Попробуйте резко повернуть"),
                 arrayOf("https://im0-tub-ru.yandex.net/i?id=ad88320989e8f07ccc73669fea98e5f0-l&n=13"))

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
        val fragment = InformationFragment().newFragment()
        fragment.arguments = bundle

        return fragment
    }
}
