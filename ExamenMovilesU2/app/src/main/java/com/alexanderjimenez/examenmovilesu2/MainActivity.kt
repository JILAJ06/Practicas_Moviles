package com.alexanderjimenez.examenmovilesu2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.alexanderjimenez.examenmovilesu2.navigation.AppNavigation
import com.alexanderjimenez.examenmovilesu2.ui.theme.ExamenMovilesU2Theme
import com.alexanderjimenez.examenmovilesu2.viewModel.ThemeViewModel
import com.alexanderjimenez.examenmovilesu2.viewModel.ThemeViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val context = LocalContext.current
            val themeViewModel: ThemeViewModel = viewModel(
                factory = ThemeViewModelFactory(context)
            )
            val isDarkTheme by themeViewModel.isDarkTheme.collectAsState()
            ExamenMovilesU2Theme(darkTheme = isDarkTheme) {
                AppNavigation()
            }
        }
    }
}
@Preview
@Composable
fun DefaultPreview() {
    ExamenMovilesU2Theme {
        AppNavigation()
    }
}
