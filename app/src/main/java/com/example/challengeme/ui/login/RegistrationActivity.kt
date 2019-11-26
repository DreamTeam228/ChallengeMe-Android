package com.example.challengeme.ui.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.*
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.challengeme.ProfileActivity
import com.example.challengeme.R

class RegistrationActivity : AppCompatActivity() {

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        val name = findViewById<EditText>(R.id.nameReg)
        val username = findViewById<EditText>(R.id.usernameReg)
        val password = findViewById<EditText>(R.id.passwordReg)
        val signup = findViewById<Button>(R.id.registrationButton)
        val loading = findViewById<ProgressBar>(R.id.loading)


        loginViewModel = ViewModelProviders.of(this, LoginViewModelFactory())
            .get(LoginViewModel::class.java)

        loginViewModel.loginFormState.observe(this@RegistrationActivity, Observer {
            val loginState = it ?: return@Observer
            //отслеживает ввод в  поля, блокирует кнопку, выводит сообщения об ошибке

            // disable login button unless both username / password is valid
            signup.isEnabled = loginState.isDataValid

            if (loginState.usernameError != null) {
                username.error = getString(loginState.usernameError)
            }
            if (loginState.passwordError != null) {
                password.error = getString(loginState.passwordError)
            }
        })

        loginViewModel.loginResult.observe(this@RegistrationActivity, Observer {
            val loginResult = it ?: return@Observer

            loading.visibility = View.GONE
            if (loginResult.error != null) {
                showLoginFailed(loginResult.error)
            }
            if (loginResult.success != null) {
                updateUiWithUser(loginResult.success)
                startActivity(Intent(this,LoginActivity::class.java))
            }
            // подумать над закрытием этого активити - если будет возвращаться сюда - закрываем его
            setResult(Activity.RESULT_OK)

            //Complete and destroy login activity once successful
            finish()
        })

        username.afterTextChanged {
            loginViewModel.loginDataChanged(
                username.text.toString(),
                password.text.toString()
            )
        }

        password.apply {
            afterTextChanged {
                loginViewModel.loginDataChanged(
                    username.text.toString(),
                    password.text.toString()
                )
            }

            setOnEditorActionListener { _, actionId, _ ->
                when (actionId) {
                    // Вызывает метод логин репозитория по нажатию на клавишу ОК
                    EditorInfo.IME_ACTION_DONE ->
                        true
                        // Регистрируем пользователя через метод регистрации в loginViewModel
                       /* loginViewModel.login(
                            username.text.toString(),
                            password.text.toString()
                        )*/
                }
                false
            }

            //
            signup.setOnClickListener {
                loading.visibility = View.VISIBLE

                //Регистрируем пользователя через метод регистрации в loginViewModel
               // loginViewModel.login(username.text.toString(), password.text.toString())

            }
        }

    }

    private fun updateUiWithUser(model: LoggedInUserView) {
        val welcome = getString(R.string.sign_up_success)
        // TODO : initiate successful logged in experience
        Toast.makeText(
            applicationContext,
            welcome,
            Toast.LENGTH_LONG
        ).show()
    }

    private fun showLoginFailed(@StringRes errorString: Int) {
        Toast.makeText(applicationContext, errorString, Toast.LENGTH_SHORT).show()
    }
}

