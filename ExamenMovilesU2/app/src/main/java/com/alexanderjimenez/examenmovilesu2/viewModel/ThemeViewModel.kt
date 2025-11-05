package com.alexanderjimenez.examenmovilesu2.viewModel
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
class ThemeViewModel(context: Context) : ViewModel() {
    private val dataStore = context.dataStore
    companion object {
        val DARK_THEME_KEY = booleanPreferencesKey("dark_theme")
    }
    val isDarkTheme = dataStore.data
        .map { preferences ->
            preferences[DARK_THEME_KEY] ?: false
        }
            .stateIn(viewModelScope, SharingStarted.Lazily, false)

    fun setDarkTheme(isDark: Boolean) {
        viewModelScope.launch {
            dataStore.edit {settings ->
                settings[DARK_THEME_KEY] = isDark
            }
        }
    }
}
