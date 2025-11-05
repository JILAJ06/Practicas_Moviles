package com.alexanderjimenez.navegation.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

/***
 * Project: CuartoA2
 * Package: com.danielflores.cuartoa2.presentation.views
 * Created by Kevin Daniel Flores Nataren
 * File created at 10/October/2025 at 14:26
 * All rights reserved 2025.
 **/

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsView(navController: NavController){
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {Text("Details A")},
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "")
                    }
                }
            )
        }
    ) {
        DetailsContent(it)
    }
}

@Composable
fun DetailsContent(innerPaddingValues: PaddingValues){
    Column(
        modifier = Modifier
            .padding(innerPaddingValues)
    ) {
        Text("Hola mundo")
    }
}