package com.example.challengeme.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.challengeme.R
import com.example.challengeme.data.globalData.userRepository
import com.example.challengeme.data.model.LoggedInUser
import com.example.challengeme.ui.login.LoggedInUserView
import com.squareup.picasso.Picasso

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var userInfo: LoggedInUserView
    private val user: LoggedInUser? = userRepository.instance.user

    private lateinit var userDisplayName_tv: TextView
    private lateinit var userPosition_tv: TextView
    private lateinit var userRang_tv: TextView

    private lateinit var userProfilePicture_iv: ImageView

    private lateinit var userRangProgress: ProgressBar

    private lateinit var lastChallengeName_tv: TextView
    private lateinit var lastChallengePicture_iv: ImageView
    private lateinit var lastChallengeDifficulty_bar: ProgressBar

    private lateinit var lastAchievemntTitle_tv: TextView
    private lateinit var lastAchievemntText_tv: TextView
    private lateinit var lastAchievementIcon_iv: ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Здесь нужно получать ВМ из профайлАктивити
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        /*val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(this, Observer {
            textView.text = it
        })*/
        userInfo = LoggedInUserView(user!!.displayName, user.position,
            user.userLevel, user.challengeCount,
            // НЕ ЗАБЫТЬ !!!
            // СНЯТЬ КОММЕНТ !!!
            // КАК ТОЛЬКО !!!
            // ДАДУТ ИНЕТ В СЕЛЕ !!!
            user.lastChallenge, user.lastAchievement,
            user.profilePicture)

        userDisplayName_tv = root.findViewById(R.id.userDisplayName_TextView)
        userDisplayName_tv.text = userInfo.displayName
        userPosition_tv = root.findViewById(R.id.userPosition_TextView)
        userPosition_tv.text = userInfo.position
        userRang_tv = root.findViewById(R.id.userRang_TextView)
        userRang_tv.text= userInfo.userLevel
        userProfilePicture_iv = root.findViewById(R.id.userProfilePicture_ImageView)
        Picasso.get()
            .load(userInfo.profilePicture)
            .placeholder(R.drawable.tmp_image)
            .into(userProfilePicture_iv)
        userRangProgress = root.findViewById(R.id.userRang_progressBar)
        userRangProgress.progress = userInfo.challengeCount!!

        var lc = userInfo.lastChallenge
        lastChallengeName_tv = root.findViewById(R.id.lastChallengeName_TextView)
        lastChallengeName_tv.text = lc?.name
            ?: "Вы еще не выполнили ни одного челленджа!"
        lastChallengePicture_iv = root.findViewById(R.id.lastChallengePic_iv)
        Picasso.get()
            .load(lc?.image)
            .error(R.drawable.tmp_image)
            .into(lastChallengePicture_iv)
        lastChallengeDifficulty_bar = root.findViewById(R.id.lastChallengeDiff_pb)
        lastChallengeDifficulty_bar.progress = lc?.difficulty
            ?: 0
        var la = userInfo.lastAchievement
        lastAchievemntTitle_tv = root.findViewById(R.id.userAchievementTitle_tv)
        lastAchievemntTitle_tv.text = la?.name ?: "Нет достижений"
        lastAchievemntText_tv = root.findViewById(R.id.userAchievementText_tv)
        lastAchievemntText_tv.text = la?.description ?: "Нет достижений"
        lastAchievementIcon_iv = root.findViewById(R.id.userAchievement_iv)
        Picasso.get()
            .load(la?.image)
            .into(lastAchievementIcon_iv)


        homeViewModel.editState.observe(this@HomeFragment, Observer {
            val editState = it ?: return@Observer

            if(editState.isEnable == true) {
                userDisplayName_tv.isFocusable = false
                userDisplayName_tv.isEnabled = false
                userDisplayName_tv.isClickable = false
                userDisplayName_tv.isFocusableInTouchMode = false

                userPosition_tv.isFocusable = false
                userPosition_tv.isEnabled = false
                userPosition_tv.isClickable = false
                userPosition_tv.isFocusableInTouchMode = false
            } else {
                userDisplayName_tv.isFocusable = true
                userDisplayName_tv.isEnabled = true
                userDisplayName_tv.isClickable = true
                userDisplayName_tv.isFocusableInTouchMode = true

                userPosition_tv.isFocusable = true
                userPosition_tv.isEnabled = true
                userPosition_tv.isClickable = true
                userPosition_tv.isFocusableInTouchMode = true
            }

        })


        return root
    }


}