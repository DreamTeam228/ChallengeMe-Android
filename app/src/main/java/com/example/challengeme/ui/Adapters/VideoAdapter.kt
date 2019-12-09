package com.example.challengeme.ui.Adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.challengeme.R


class VideoAdapter internal constructor(context: Context, private var elements: ArrayList<String>, val filter: String) :
    RecyclerView.Adapter<VideoAdapter.ViewHolder>() {
    private val inflater: LayoutInflater
    init {
        this.inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view = inflater.inflate(R.layout.item_video, viewGroup, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return elements.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        Log.d("VIEWHOLDER_POSITION", "POSITION IS $position")

        youTubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            fun onReady(youTubePlayer: YouTubePlayer) {
                val videoId = "S0Q4gqBUs7c"
                youTubePlayer.loadVideo(videoId, 0)
            }
        })

        val element = elements[position]
        viewHolder.checkBox.text = element.text
        viewHolder.imageView.setColorFilter(element.image)
        viewHolder.checkBox.isChecked = element.isChecked
        viewHolder.checkBox.setOnClickListener{
            element.isChecked = !element.isChecked
            viewHolder.checkBox.isChecked = element.isChecked
            if (element.isChecked) {
                if (filter == STATION_FILTER)
                    checkedMetro.add(element.text)
                else if (filter == CATEGORY_FILTER)
                    checkedCategory.add(element.text)
            }
            else {
                if (filter == STATION_FILTER)
                    checkedMetro.remove(element.text)
                else if (filter == CATEGORY_FILTER)
                    checkedCategory.remove(element.text)
            }
        }



        if (viewHolder.checkBox.isChecked) {
            Log.d("CHECKSTATE_IS_TRUE", "POSITION IS $position")
        }

    }

    inner class ViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {

        val youTubePlayerView: YouTubePlayerView = findViewById(R.id.youtube_player_view)
        getLifecycle().addObserver(youTubePlayerView)

        internal val imageView: ImageView
        internal val checkBox: CheckBox
        init {
            imageView = view.findViewById<View>(R.id.list_icon) as ImageView
            checkBox = view.findViewById<View>(R.id.checkBox_search) as CheckBox
        }
    }

    fun setData(elements: ArrayList<SearchOption>) {
        this.elements = elements
        notifyDataSetChanged()
    }
}
