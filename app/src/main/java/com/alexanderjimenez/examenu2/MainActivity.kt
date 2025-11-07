package com.alexanderjimenez.examenu2

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.alexanderjimenez.examenu2.ui.theme.ExamenU2Theme
import com.alexanderjimenez.examenu2.viewmodels.ThemeViewModel
import com.alexanderjimenez.examenu2.viewmodels.ThemeViewModelFactory
import com.alexanderjimenez.examenu2.viewmodels.UserViewModel
import com.alexanderjimenez.examenu2.viewmodels.UserViewModelFactory
import com.alexanderjimenez.examenu2.views.DashboardView
import com.alexanderjimenez.examenu2.views.View1
import com.alexanderjimenez.examenu2.views.View2

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val context = LocalContext.current
            val themeViewModel: ThemeViewModel = viewModel(factory = ThemeViewModelFactory(context))
            val userViewModel: UserViewModel = viewModel(factory = UserViewModelFactory(context.applicationContext as Application))
            val isDarkTheme by themeViewModel.isDarkTheme.collectAsState(initial = isSystemInDarkTheme())

            ExamenU2Theme(darkTheme = isDarkTheme) {
                Surface(modifier = Modifier.fillMaxSize()) {
                    AppNavigation(themeViewModel = themeViewModel, userViewModel = userViewModel)
                }
            }
        }
    }
}

@Composable
fun AppNavigation(themeViewModel: ThemeViewModel, userViewModel: UserViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "dashboard") {
        composable("dashboard") {
            DashboardView(navController)
        }
        composable("view1") {
            View1(themeViewModel)
        }
        composable("view2") {
            View2(userViewModel)
        }
    }
}