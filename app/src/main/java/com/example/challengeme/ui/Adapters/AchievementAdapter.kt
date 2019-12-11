package com.example.challengeme.ui.Adapters
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.challengeme.R
import com.example.challengeme.User.UserAchievement
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import com.squareup.picasso.Picasso


class AchievementAdapter internal constructor(val context: Context, private var elements: ArrayList<UserAchievement>) :
    RecyclerView.Adapter<AchievementAdapter.ViewHolder>() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view = inflater.inflate(R.layout.item_video, viewGroup, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return elements.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        Log.d("VIEWHOLDER_POSITION", "POSITION IS $position")

        viewHolder.userAchievementTitle_tv.text = elements[position].name
        viewHolder.userAchievementText_tv.text = elements[position].description
        Picasso.get()
            .load(elements[position].image)
            .into(viewHolder.userAchievementImaage_iv)

    }

    inner class ViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {

        val userAchievementTitle_tv = view.findViewById<TextView>(R.id.userAchievementTitle_tv)
        val userAchievementText_tv = view.findViewById<TextView>(R.id.userAchievementText_tv)
        val userAchievementImaage_iv = view.findViewById<ImageView>(R.id.userAchievement_iv)
    }
}
