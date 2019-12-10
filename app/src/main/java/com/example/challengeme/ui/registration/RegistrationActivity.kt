package com.example.challengeme.ui.registration

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.*
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.challengeme.R
import com.example.challengeme.ui.login.*

class RegistrationActivity : AppCompatActivity() {

    private lateinit var registrationViewModel: RegistrationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        val displayName = findViewById<EditText>(R.id.nameReg)
        val username = findViewById<EditText>(R.id.usernameReg)
        val password = findViewById<EditText>(R.id.passwordReg)
        val signup = findViewById<Button>(R.id.registrationButton)
        val loading = findViewById<ProgressBar>(R.id.loading)


        registrationViewModel = ViewModelProviders.of(this,
            RegistrationViewModelFactory()
        )
            .get(RegistrationViewModel::class.java)

        registrationViewModel.registrationFormState.observe(this@RegistrationActivity, Observer {
            val registrationState = it ?: return@Observer
            //отслеживает ввод в  поля, блокирует кнопку, выводит сообщения об ошибке

            // disable login button unless both username / password is valid
            signup.isEnabled = registrationState.isDataValid

            if (registrationState.usernameError != null) {
                username.error = getString(registrationState.usernameError)
            }
            if (registrationState.passwordError != null) {
                password.error = getString(registrationState.passwordError)
            }
        })

        registrationViewModel.registrationResult.observe(this@RegistrationActivity, Observer {
            val registrationResult = it ?: return@Observer

            loading.visibility = View.GONE
            if (registrationResult.error != null) {
                showRegistrationResult(registrationResult.error)
            }
            if (registrationResult.success != null) {
                showRegistrationResult(registrationResult.success)
                startActivity(Intent(this,
                    LoginActivity::class.java))
            }
            // подумать над закрытием этого активити - если будет возвращаться сюда - закрываем его
            setResult(Activity.RESULT_OK)

            //Complete and destroy login activity once successful
            finish()
        })


        displayName.afterTextChanged {
            registrationViewModel.registrationDataChanged(
                username.text.toString(),
                password.text.toString(),
                displayName.text.toString()
            )
        }

        username.afterTextChanged {
            registrationViewModel.registrationDataChanged(
                username.text.toString(),
                password.text.toString(),
                displayName.text.toString()
            )
            // checking post here
        }

        password.apply {
            afterTextChanged {
                registrationViewModel.registrationDataChanged(
                    username.text.toString(),
                    password.text.toString(),
                    displayName.text.toString()
                )
            }

            setOnEditorActionListener { _, actionId, _ ->
                when (actionId) {
                    // Вызывает метод логин репозитория по нажатию на клавишу ОК
                    EditorInfo.IME_ACTION_DONE ->
                        // Регистрируем пользователя через метод регистрации в registrationViewModel
                    registrationViewModel.login(username.text.toString(), password.text.toString())
                }
                false
            }

            //
            signup.setOnClickListener {
                loading.visibility = View.VISIBLE

                //Регистрируем пользователя через метод регистрации в loginViewModel
                registrationViewModel.login(username.text.toString(), password.text.toString())

            }
        }

    }

    private fun showRegistrationResult(@StringRes resultString: Int) {
        Toast.makeText(applicationContext, resultString, Toast.LENGTH_SHORT).show()
    }

}

