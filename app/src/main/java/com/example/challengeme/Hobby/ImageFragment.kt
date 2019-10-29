package com.example.challengeme.Hobby

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.challengeme.R
import com.squareup.picasso.Picasso

class ImageFragment : Fragment() {

    lateinit var imageView: ImageView
    lateinit var imageString: String

    fun createFragment() : ImageFragment {
        return ImageFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = this.arguments
        if (bundle != null)
            imageString = bundle.getString("image")!!


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.image_fragment, container, false)

        imageView = view.findViewById(R.id.imageView)
        Picasso.get()
            .load(imageString)
            .placeholder(R.drawable.tmp_image)
            .into(imageView)

        return view

    }
}