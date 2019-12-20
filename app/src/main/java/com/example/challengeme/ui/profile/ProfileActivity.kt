package com.example.challengeme.ui.profile
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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


class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

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

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

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

    override fun onCreateOptionsMenu (menu: Menu) : Boolean {
        menuInflater.inflate(R.menu.profile_menu, menu)
        val logout = menu.findItem(R.id.logout)
        // А перед тем, как проверять зарегистрированность юзера, надо проверить, есть ли инфа о нём в кэше

        logout.setOnMenuItemClickListener {

            val builder = AlertDialog.Builder(this@ProfileActivity)

            builder.setTitle("Выход из профиля")

            builder.setMessage("Вы уверены, что хотите выйти?")

            builder.setPositiveButton("ХОЧУ"){ _, _ ->
                Toast.makeText(applicationContext,"Ok, fuck you",Toast.LENGTH_SHORT).show()
                userRepository.instance.logout()
                logoutUser()
                finish()
            }

            builder.setNegativeButton("НЕ ХОЧУ"){ _, _ ->
                Toast.makeText(applicationContext,"You are breathtaking",Toast.LENGTH_SHORT).show()
            }

            val dialog: AlertDialog = builder.create()
            dialog.show()

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



}
