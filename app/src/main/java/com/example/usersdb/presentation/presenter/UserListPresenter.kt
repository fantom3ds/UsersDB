package com.example.usersdb.presentation.presenter

import com.example.usersdb.data.model.UserDb
import com.example.usersdb.data.repository.DbRepository
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class UserListPresenter(val view: IUsersListView) {

    private val repository = DbRepository.instance

    fun showUsers(){
        repository.getUsers()
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe({
                view.showUsers(it)
            }, {
                view.showError(it.message?:"Unknown Error")
            })
    }

    fun addUser(userDb: UserDb){
        Completable.fromRunnable(Runnable() {
            repository.insertUser(userDb)
        })
            .subscribeOn(Schedulers.io())
            .subscribe()
    }

    fun deleteUser(userDb: UserDb){
        Completable.fromRunnable(Runnable() {
            repository.delete(userDb)
        })
            .subscribeOn(Schedulers.io())
            .subscribe()
    }
}