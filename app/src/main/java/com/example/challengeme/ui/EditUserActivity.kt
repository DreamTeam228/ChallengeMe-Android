package com.example.challengeme.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import com.example.challengeme.AsynchronousRequests.UserEditAsyncTask
import com.example.challengeme.AsynchronousRequests.asyncResult.AsyncResult
import com.example.challengeme.R
import com.example.challengeme.data.globalData.userRepository
import com.squareup.picasso.Picasso

class EditUserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_user)

        val displayName = findViewById<EditText>(R.id.editUserDisplayName)
        val picture = findViewById<ImageView>(R.id.editUserProfilePicture_ImageView)
        val username = findViewById<EditText>(R.id.editUsername)
        val oldPass = findViewById<EditText>(R.id.editUserOldPass)
        val newPassEditable = findViewById<EditText>(R.id.editUserNewPass)
        val newPassConf = findViewById<EditText>(R.id.editUserNewPassConf)
        val save = findViewById<Button>(R.id.editUser_submitBtn)

        val oldDisplayName = intent.getStringExtra(getText(R.string.intentDisplayName).toString())
        val oldLogin = intent.getStringExtra(getText(R.string.intentLogin).toString())
        val oldPicture = intent.getStringExtra(getText(R.string.intentPicture).toString())
        val id = intent.getIntExtra(getText(R.string.intentId).toString(), -1)

        displayName.setText(oldDisplayName)
        username.setText(oldLogin)
        Picasso.get()
            .load(oldPicture)
            .into(picture)


        save.setOnClickListener {
            var newDisplayName: String? = null
            var newUsername: String? = null
            var newPass: String? = null
            var newPic: String? = null
            var smthEdited: Boolean = false
            if (displayName.text.toString() != oldDisplayName) {
                newDisplayName = displayName.text.toString()
                smthEdited = true
            }
            if (username.text.toString() != oldLogin) {
                newUsername = username.text.toString()
                smthEdited = true
            }
            if (oldPass.text.isNotBlank() &&
                (newPassEditable.text.isNotBlank() && newPassConf.text.isNotBlank())) {
                newPass = newPassEditable.text.toString()
                smthEdited = true
            }
            if (newPassEditable.text.toString() != newPassConf.text.toString()) {
                smthEdited = false
            }
            // add picture
            if (smthEdited) {
                val result: AsyncResult =
                    UserEditAsyncTask(
                        id,
                        newDisplayName,
                        newUsername,
                        newPass
                    ).execute(getText(R.string.standardUrl).toString()).get()

                when {
                    result.success != null -> {
                        userRepository.instance.changeData(
                            newDisplayName,
                            newUsername,
                            newPass,
                            newPic
                        )
                        //val intent = Intent()
                        setResult(RESULT_OK)
                        finish()
                    }
                    result.error != null -> {
                        val builder = AlertDialog.Builder(this@EditUserActivity)
                        builder.setTitle(R.string.error)
                        builder.setMessage(result.error)
                        builder.setPositiveButton(R.string.yes) { _, _ -> }
                        val dialog: AlertDialog = builder.create()
                        dialog.show()

                    }
                    else -> {
                        val builder = AlertDialog.Builder(this@EditUserActivity)
                        builder.setTitle(R.string.error)
                        builder.setMessage(R.string.error)
                        builder.setPositiveButton(R.string.yes) { _, _ -> }
                        val dialog: AlertDialog = builder.create()
                        dialog.show()
                    }
                }
            }
            else {
                val builder = AlertDialog.Builder(this@EditUserActivity)
                builder.setTitle(R.string.error)
                builder.setMessage(R.string.sameFieldsOrPassword_error)
                builder.setPositiveButton(R.string.no) { _, _ -> }
                val dialog: AlertDialog = builder.create()
                dialog.show()
                newPassEditable.text.clear()
                newPassConf.text.clear()
            }

        }


    }
}
