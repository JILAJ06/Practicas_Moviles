package com.danielflores.navigaton4c.presentation.navManager

import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavArgument
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.danielflores.navigationarepeticion.presentation.views.DetailsView
import com.danielflores.navigationarepeticion.presentation.views.HomeView

/***
 * Project: Navigaton4c
 * Package: com.danielflores.navigaton4c.presentation.navManager
 * Created by Kevin Daniel Flores Nataren
 * File created at 10/October/2025 at 14:49
 * All rights reserved 2025.
 **/

@Composable
fun NavManager(){
    val navController = rememberNavController()
    NavHost(
        navController,
        startDestination = "Home"
    ){
        composable("Home") {
            HomeView(navController)
        }
        composable("Details/{id}", arguments = listOf(
            navArgument(name="id"){
                type = NavType.LongType
            }
        )) {
            val id = it.arguments?.getLong("id") ?: 0
            DetailsView(navController, id)
        }
    }
}