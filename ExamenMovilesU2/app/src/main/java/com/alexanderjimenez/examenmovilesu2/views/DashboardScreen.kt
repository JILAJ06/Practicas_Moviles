package com.alexanderjimenez.examenmovilesu2.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.alexanderjimenez.examenmovilesu2.navigation.AppScreens

@Composable
fun DashboardScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { navController.navigate(AppScreens.View1Screen.route) }) {
            Text("View 1")
        }
        Button(onClick = { navController.navigate(AppScreens.View2Screen.route) }) {
            Text("View 2")
        }
    }
}
@Composable
@Preview(showBackground = true)
fun DashboardScreenPreview() {
    DashboardScreen(navController = rememberNavController())
}