package com.alexanderjimenez.jetpackcomposecurso.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.alexanderjimenez.jetpackcomposecurso.ui.viewmodel.ThemeViewModel

@Composable
fun SettingsScreen(vm: ThemeViewModel = viewModel()) {
    val isDark by vm.isDark.collectAsState()

    Column(modifier = Modifier.fillMaxWidth().padding(24.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text("Tema", style = MaterialTheme.typography.titleLarge)
        Text(if (isDark) "Modo oscuro" else "Modo claro")
        Switch(
            checked = isDark,
            onCheckedChange = { vm.toggleDark(it) },
            colors = SwitchDefaults.colors(checkedThumbColor = MaterialTheme.colorScheme.primary)
        )
    }
}

