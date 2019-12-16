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
import com.example.challengeme.User.UserChallenge
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.squareup.picasso.Picasso


class ChallengeAdapter internal constructor(val context: Context, private var elements: ArrayList<UserChallenge>) :
    RecyclerView.Adapter<ChallengeAdapter.ViewHolder>() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view = inflater.inflate(R.layout.item_challenge, viewGroup, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return elements.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        Log.d("VIEWHOLDER_POSITION", "POSITION IS $position")

        viewHolder.userChallengeName_tv.text = elements[position].name
        viewHolder.userChallenge_rb.progress = elements[position].difficulty
        Picasso.get()
            .load(elements[position].image)
            .into(viewHolder.userChallengeImage_iv)

    }

    inner class ViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {

        val userChallengeName_tv = view.findViewById<TextView>(R.id.itemChallengeName_TextView)
        val userChallengeImage_iv = view.findViewById<ImageView>(R.id.itemChallenge_ImageView)
        val userChallenge_rb = view.findViewById<RatingBar>(R.id.itemChallenge_RatingBar)
        }

}
