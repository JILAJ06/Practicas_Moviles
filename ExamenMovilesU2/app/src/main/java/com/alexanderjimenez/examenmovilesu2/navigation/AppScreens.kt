package com.alexanderjimenez.examenmovilesu2.navigation

sealed class AppScreens(val route: String) {
    object DashboardScreen : AppScreens("dashboard_screen")
    object View1Screen : AppScreens("view1_screen")
    object View2Screen : AppScreens("view2_screen")
}