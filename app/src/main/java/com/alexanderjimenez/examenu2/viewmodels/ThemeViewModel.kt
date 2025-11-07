package com.alexanderjimenez.examenu2.viewmodels

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class ThemeViewModel(private val dataStore: DataStore<Preferences>) : ViewModel() {

    private val isDarkThemeKey = booleanPreferencesKey("is_dark_theme")

    val isDarkTheme: Flow<Boolean> = dataStore.data.map {
        it[isDarkThemeKey] ?: false
    }

    fun setTheme(isDark: Boolean) {
        viewModelScope.launch {
            dataStore.edit {
                it[isDarkThemeKey] = isDark
            }
        }
    }
}

class ThemeViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ThemeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ThemeViewModel(context.dataStore) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}