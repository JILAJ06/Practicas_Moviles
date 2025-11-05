package com.alexanderjimenez.examenmovilesu2.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.alexanderjimenez.examenmovilesu2.views.DashboardScreen
import com.alexanderjimenez.examenmovilesu2.views.View1Screen
import com.alexanderjimenez.examenmovilesu2.views.View2Screen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.DashboardScreen.route) {
        composable(AppScreens.DashboardScreen.route) {
            DashboardScreen(navController)
        }
        composable(AppScreens.View1Screen.route) {
            View1Screen()
        }
        composable(AppScreens.View2Screen.route) {
            View2Screen()
        }
    }
}