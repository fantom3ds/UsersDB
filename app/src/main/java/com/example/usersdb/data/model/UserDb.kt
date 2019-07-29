package com.example.usersdb.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Users")
data class UserDb(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    var online: Int,
    val lastActivity: Long,
    val status: String,
    val platform: Byte
):Serializable