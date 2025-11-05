package com.danielflores.navigationarepeticion.presentation.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

/***
 * Project: NavigationARepeticion
 * Package: com.danielflores.navigationarepeticion.presentation.views
 * Created by Kevin Daniel Flores Nataren
 * File created at 10/October/2025 at 13:37
 * All rights reserved 2025.
 **/

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsView(navController: NavController, id: Long){
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Details")
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {
                        Icon(imageVector = Icons.AutoMirrored.Default.ArrowBack, contentDescription = "")
                    }
                }
            )
        }
    ) {
        DetailsContent(it, id)
    }
}

@Composable
fun DetailsContent(paddingValues: PaddingValues, id: Long){
    Column(
        modifier = Modifier
            .padding(paddingValues)
    ) {
        Text("Hola mundo ${id}")
    }
}