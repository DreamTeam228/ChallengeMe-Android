package com.example.challengeme.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.challengeme.R
import com.example.challengeme.ui.userlist.UserAchievementFragment
import com.example.challengeme.ui.userlist.UserChallengeFragment

class UserListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_list_activity)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val fragmentPurpose = intent.getStringExtra(getText(R.string.userList).toString())
        val bundle = Bundle()
        bundle.putInt("id", intent.getIntExtra(getText(R.string.userId).toString(),-1))


        if(fragmentPurpose == "achievements") {
            val fragment = UserAchievementFragment.newInstance()
            fragment.arguments = bundle
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .commitNow()
        } else {
            val fragment = UserChallengeFragment.newInstance()
            fragment.arguments = bundle
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragment )
                .commitNow()
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> {
                finish()
                super.onBackPressed()
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}
