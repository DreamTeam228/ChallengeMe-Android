package com.example.challengeme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.challengeme.ui.userchallenge.UserChallengeFragment

class UserListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_list_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, UserChallengeFragment.newInstance())
                .commitNow()
        }
    }

}
