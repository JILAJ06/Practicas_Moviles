package com.alexanderjimenez.examenu2.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert
    suspend fun insert(user: User)


    @Query("SELECT * FROM users ORDER BY name ASC,  lastname DESC, email DESC, password DESC")
    fun getAllUsers(): Flow<List<User>>

}