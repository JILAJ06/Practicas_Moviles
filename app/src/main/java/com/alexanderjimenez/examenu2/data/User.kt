package com.alexanderjimenez.examenu2.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val lastname: String,
    val email: String,
    val password: String

)