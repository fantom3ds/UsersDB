package com.example.usersdb.data.repository

import android.content.Context
import com.example.usersdb.App
import com.example.usersdb.data.db.AppDatabase
import com.example.usersdb.data.model.UserDb
import io.reactivex.Flowable

class DbRepository() : IRepository {

    override fun delete(user: UserDb) {
        db.userDao().delete(user)
    }

    private object Holder {
        val INSTANCE = DbRepository()
    }

    companion object {
        val instance: DbRepository by lazy { Holder.INSTANCE }
    }

    private val db = App.instance.database

    override fun getUsers(): Flowable<List<UserDb>> {
        return db.userDao().getUsers()
    }

    override fun insertUser(user: UserDb) {
        db.userDao().insert(user)
    }

    override fun insertAll(users: List<UserDb>) {
        db.userDao().insertAll(users)
    }

    override fun update(users: List<UserDb>) {
        db.userDao().update(users)
    }


}