package com.example.usersdb

import android.app.Application
import androidx.room.Room
import com.example.usersdb.data.db.AppDatabase


class App : Application() {

    lateinit var database: AppDatabase

    override fun onCreate() {
        super.onCreate()
        instance = this
        database = Room.databaseBuilder(this, AppDatabase::class.java, "database")
            .build()
    }

    companion object {
        lateinit var instance: App
    }
}