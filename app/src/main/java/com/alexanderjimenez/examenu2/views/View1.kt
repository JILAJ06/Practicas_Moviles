package com.alexanderjimenez.examenu2.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.alexanderjimenez.examenu2.viewmodels.ThemeViewModel

@Composable
fun View1(themeViewModel: ThemeViewModel) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { themeViewModel.setTheme(true) }) {
            Text("Tema Oscuro")
        }
        Button(onClick = { themeViewModel.setTheme(false) }) {
            Text("Tema Claro")
        }
    }
}