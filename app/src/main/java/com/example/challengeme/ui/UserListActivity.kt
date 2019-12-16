package com.example.challengeme.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.challengeme.R
import com.example.challengeme.ui.userlist.UserAchievementFragment
import com.example.challengeme.ui.userlist.UserChallengeFragment

class UserListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_list_activity)

        val fragmentPurpose = intent.getStringExtra(getText(R.string.userList).toString())

        if(fragmentPurpose == "achievements") {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, UserAchievementFragment.newInstance())
                .commitNow()
        } else {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, UserChallengeFragment.newInstance())
                .commitNow()
        }

    }

}
