package com.alexanderjimenez.examen2.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.alexanderjimenez.examen2.data.AppDatabase
import com.alexanderjimenez.examen2.data.User
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {
    private val userDao = AppDatabase.getDatabase(application).userDao()

    val users = userDao.getAllUsers()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun addUser(name: String) {
        viewModelScope.launch {
            if (name.isNotBlank()) {
                userDao.insertUser(User(name = name))
            }
        }
    }
}
