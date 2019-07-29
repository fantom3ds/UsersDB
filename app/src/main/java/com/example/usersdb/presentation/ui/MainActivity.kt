package com.example.usersdb.presentation.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.usersdb.R
import com.example.usersdb.data.model.UserDb
import com.example.usersdb.presentation.presenter.IUsersListView
import com.example.usersdb.presentation.presenter.UserListPresenter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.header.*

class MainActivity : AppCompatActivity(), IUsersListView {

    override fun showUsers(users: List<UserDb>) {
        adapter.setUsers(users)
    }

    override fun setLoading(isLoading: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    var adapter = UserAdapter(arrayListOf())
    val presenter = UserListPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(tb_back)
        supportActionBar?.title = "Пользователи"

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter

        presenter.showUsers()

        //костыль на удаление, сюда бы AlertDialog прикрутить или в отдельной активити открыть
        adapter.onItemClickFunction = { user -> presenter.deleteUser(user) }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.m_add -> {
                startActivityForResult(
                    Intent(this@MainActivity, AddUserActivity::class.java),
                    1
                )
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && data != null) {
            presenter.addUser(data.getSerializableExtra("newUser") as UserDb)
        }
    }
}
