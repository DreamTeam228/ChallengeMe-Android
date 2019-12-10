package com.example.challengeme.ui.Adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import com.example.challengeme.R
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView


class VideoAdapter internal constructor(val context: Context, private var elements: ArrayList<String>, private val lifeCycle : Lifecycle) :
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


        //lifeCycle.addObserver(viewHolder.youTubePlayerView)
        viewHolder.youTubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                val videoId = elements[position]
                //val videoId = "dQw4w9WgXcQ"
                youTubePlayer.loadVideo(videoId, 0f)
                youTubePlayer.pause()
            }
        })
    }

    inner class ViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {

        val youTubePlayerView: YouTubePlayerView = view.findViewById(R.id.youtube_player_view)
    }

}
