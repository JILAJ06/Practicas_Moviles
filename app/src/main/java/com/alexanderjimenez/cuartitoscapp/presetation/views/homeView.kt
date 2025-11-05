package com.alexanderjimenez.cuartitoscapp.presetation.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.alexanderjimenez.cuartitoscapp.data.Students

private val Int.name: Any

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(navController: NavController){
    var students = listOf<Students>(
        Students(1, "Emilia", "Es la jefa de grupo", ),
        Students(2, "Nadia", "Es la amiga de Emilia"),
        Students(3L, "Luis", "Es el amigo de  la amiga de Emilia"),
        Students(4L, "Antonio", "Es el amigo del amigo  de  la amiga de Emilia"),
        Students(5L, "Angel", "Es el amigo del amigo del amigo  de  la amiga de Emilia"),
        Students(7L, "Juan", "Descripción"),
        Students(8L, "Pedro", "Descripción"),
        Students(9L, "María", "Descripción"),
        Students(10L, "Ana", "Descripción"),
        Students(11L, "Laura", "Descripción"),
        Students(12L, "Carlos", "Descripción"),
        Students(13L, "Lucía", "Descripción"),
        Students(14L, "Pablo", "Descripción"),
        Students(15L, "Marta", "Descripción"),
    )
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Dashboard")
                }
            )
        }
    ) {
        Content(it, students, navController)
    }
}

@Composable
fun Content(paddingValues: PaddingValues, students: List<Students>, navController: NavController){
    LazyColumn (
        modifier = Modifier
            .padding(paddingValues)
            .padding(horizontal = 10.dp)
    ) {
        items(students){ student ->
            Box(
                modifier = Modifier
                    .clickable {
                        navController.navigate("Details/${student.id}")
                    }
                    .size(150.dp)
                    .background(color = Color.Yellow, CircleShape)
                    .wrapContentSize(Alignment.Center)
            ){
                Text(student.name, color = Color.Black)
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}