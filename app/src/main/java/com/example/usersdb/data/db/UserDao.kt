package com.example.usersdb.data.db

import androidx.room.*
import com.example.usersdb.data.model.UserDb
import io.reactivex.Flowable

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(userDb: UserDb)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(users:List<UserDb>)

    @Update
    fun update(users: List<UserDb>)

    @Query("select * from Users")
    fun getUsers(): Flowable<List<UserDb>>

    @Delete
    fun delete(userDb: UserDb)
}