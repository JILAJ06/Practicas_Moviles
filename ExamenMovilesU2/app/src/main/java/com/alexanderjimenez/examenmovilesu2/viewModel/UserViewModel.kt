package com.alexanderjimenez.examenmovilesu2.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexanderjimenez.examenmovilesu2.data.User
import com.alexanderjimenez.examenmovilesu2.data.UserDao
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class UserViewModel(private val userDao: UserDao) : ViewModel() {

    val allUsers = userDao.getAllUsers()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun addUser(name: String) {
        viewModelScope.launch {
            userDao.insert(User(name = name))
        }
    }
}