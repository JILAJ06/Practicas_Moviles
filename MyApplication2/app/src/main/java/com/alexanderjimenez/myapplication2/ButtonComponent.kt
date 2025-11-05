package com.alexanderjimenez.myapplication2

import android.widget.Button
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun NormalButton(
    text: String,
    onButtonClick: (() -> Unit)? = null
){
    if (onButtonClick != null){
        Button(
            onClick = onButtonClick,
            colors =
        ){
            Text(text)
        }
        return
    }
    Button(
        onClick ={
            println("Hola defaults")
        }
    ){

    }
}