package com.example.usersdb.presentation.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.usersdb.R
import com.example.usersdb.data.model.UserDb
import kotlinx.android.synthetic.main.activity_add_user.*

class AddUserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)

        btn_add.setOnClickListener {
            if (et_name.text != null) {
                val intent = Intent()
                val user = UserDb(
                    0,
                    et_name.text.toString(),
                    0,
                    0,
                    et_status.text.toString(),
                    0
                )
                if (cb_online.isChecked)
                    user.online = 1
                else
                    user.online = 0

                intent.putExtra("newUser", user)
                setResult(Activity.RESULT_OK, intent)
                finish()
            }

        }
    }
}
