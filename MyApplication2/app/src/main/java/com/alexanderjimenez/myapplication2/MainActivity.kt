package com.alexanderjimenez.myapplication2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alexanderjimenez.myapplication2.ui.theme.MyApplication2Theme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold (
                modifier = Modifier
                    .fillMaxSize(),
                topBar = {
                    TopAppBar(
                        title = {
                            Text("Cuarto C")
                        },
                    )
                }
            ){
                Content(it)
            }
        }
    }
}

/*
 modifiers (modificadores)
 De posicionamiento width, height
 De funcionalidad click, scrool
 De apariencia: Background, padding, borders
 De escucha (Listenings)
*/
@Composable
fun Content(inerPadding : PaddingValues){
    var likes by remember { mutableIntStateOf(0) }
    Column(
        modifier = Modifier
            .padding(inerPadding)
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)

    ) {
//        Text(
//            modifier = Modifier.clickable(onClick = {
//                println("Es de chill");
//            }),
//            text= "Los de 4c son mejores amigos de mijangos")
//        )

        Box(
            modifier = Modifier

                //Dp es una unidad similar a px de web, por lo generar se usan dp porque es espeficio para movil
                .width(500.dp)
                .background(color = Color.Red)
                .padding(40.dp)

        ){

            Column(
               NormalButton("Holis")

            }

        }


    }

}