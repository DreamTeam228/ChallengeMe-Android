package com.example.challengeme

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*

fun getDate () : Date {  //функция вывода сегодняшней даты
    val formatter = SimpleDateFormat(
        "dd/MM/yyyy"
    )
    return formatter.parse(formatter.format(Date()))
}

class HeadFragment : Fragment() {
    lateinit var item: HobbyObject
    lateinit var nameTextView: TextView
    lateinit var  dateTextView : TextView
    lateinit var dayTextView: TextView
    lateinit var  categoryTextView: TextView
    lateinit var difficultyView : RatingBar


fun newFragment() : Fragment { // создание нового фрагмента
    return HeadFragment()
}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true // запрет на убийство фрагмена при повороте экрана
        val bundle: Bundle? = this.arguments // получаем объект
        if (bundle != null) {
            item = bundle.getParcelable("item")!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //return super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_header, container, false)

        nameTextView = view.findViewById(R.id.hobby_name_tv)
        categoryTextView = view.findViewById(R.id.category_tv)
        dateTextView = view.findViewById(R.id.date_tv)
        dayTextView = view.findViewById(R.id.day_tv)
        difficultyView = view.findViewById(R.id.difficulty_rb)
        difficultyView.numStars = 5

        // отображаем соответствующую информацию на экране

        nameTextView.text = item.name
        categoryTextView.text = item.category
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            dateTextView.text = LocalDate.now().toString()
        } else
            dateTextView.text = getDate().toString()
        difficultyView.rating = item.difficulty.toFloat()

        return view
    }

}