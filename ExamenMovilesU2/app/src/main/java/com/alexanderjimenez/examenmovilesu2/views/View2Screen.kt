package com.alexanderjimenez.examenmovilesu2.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.alexanderjimenez.examenmovilesu2.viewModel.ThemeViewModel

@SuppressLint("ViewModelConstructorInComposable")
@Composable
fun View2Screen() {
    val context = LocalContext.current
    val themeViewModel = ThemeViewModel(context = context)

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { themeViewModel.setDarkTheme(false) }) {
            Text("Light Theme")
        }
        Button(onClick = { themeViewModel.setDarkTheme(true) }) {
            Text("Dark Theme")
        }
    }
}
@Preview
@Composable
fun View2ScreenPreview() {
    View2Screen()
}