package com.example.challengeme.ui.profile
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.challengeme.R
import com.example.challengeme.data.globalData.userRepository
import com.example.challengeme.ui.UserListActivity
import com.example.challengeme.ui.home.HomeViewModel


class ProfileActivity : AppCompatActivity() {

    public lateinit var profileViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        profileViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_qr_code,
                R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        //supportActionBar!!.setDisplayHomeAsUpEnabled(true)



    }

    override fun onCreateOptionsMenu (menu: Menu) : Boolean {
        menuInflater.inflate(R.menu.profile_menu, menu)
        val logout = menu.findItem(R.id.logout)
        val edit = menu.findItem(R.id.edit)
        val apply = menu.findItem(R.id.apply)
        // А перед тем, как проверять зарегистрированность юзера, надо проверить, есть ли инфа о нём в кэше
        logout.setOnMenuItemClickListener {
            /*val builder = AlertDialog.Builder(baseContext)
            builder.setTitle(R.string.logoutTitle)
            builder.setMessage(R.string.logoutText)
            builder.setPositiveButton(R.string.yes) { _, _ ->
                userRepository.instance.logout()
                logoutUser()
            }
            builder.setNegativeButton(R.string.no) { _, _ ->

            }

            val dialog : AlertDialog = builder.create()
            dialog.show()*/

            userRepository.instance.logout()
            logoutUser()
            finish()

            true
        }

        edit.setOnMenuItemClickListener {
            profileViewModel.disableEditState()
            edit.isVisible = false
            apply.isVisible = true

            true
        }

        apply.setOnMenuItemClickListener {
            profileViewModel.enableEditState()
            apply.isVisible = false
            edit.isVisible = true

            //profileViewModel.sendRequest(name, position...)
            true
        }

        return true
    }


    private fun logoutUser() {
        val pref = getSharedPreferences(getText(R.string.userCache).toString(), Context.MODE_PRIVATE)
        val editor = pref.edit()
        editor.clear()
        editor.apply()
    }


    fun onViewMoreClick(view: View?) {
        val intent = Intent(baseContext, UserListActivity::class.java)
        when(view!!.id) {
            R.id.viewMoreChallenges_Title -> { intent.putExtra(getText(R.string.userList).toString(), "challenges") }
            R.id.viewMoreAchievements_Title -> { intent.putExtra(getText(R.string.userList).toString(), "achievements") }
        }
        startActivity(intent)
    }
}
