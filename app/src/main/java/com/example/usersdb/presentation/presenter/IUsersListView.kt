package com.example.usersdb.presentation.presenter

import com.example.usersdb.data.model.UserDb

interface IUsersListView {

    fun showUsers(users:List<UserDb>)
    fun setLoading(isLoading:Boolean)
    fun showError(message:String)
}