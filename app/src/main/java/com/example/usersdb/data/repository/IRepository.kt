package com.example.usersdb.data.repository

import com.example.usersdb.data.model.UserDb
import io.reactivex.Flowable

interface IRepository {
    fun getUsers(): Flowable<List<UserDb>>
    fun insertUser(user: UserDb)
    fun insertAll(users: List<UserDb>)
    fun update(users: List<UserDb>)
    fun delete(user: UserDb)
}