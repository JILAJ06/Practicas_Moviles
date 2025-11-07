package com.alexanderjimenez.examenu2.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.alexanderjimenez.examenu2.data.AppDatabase
import com.alexanderjimenez.examenu2.data.User
import com.alexanderjimenez.examenu2.data.UserDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class UserViewModel(private val userDao: UserDao) : ViewModel() {
    val allUsers: Flow<List<User>> = userDao.getAllUsers()

    fun insert(user: User) = viewModelScope.launch {
        userDao.insert(user)
    }
}

class UserViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            val userDao = AppDatabase.getDatabase(application).userDao()
            @Suppress("UNCHECKED_CAST")
            return UserViewModel(userDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}