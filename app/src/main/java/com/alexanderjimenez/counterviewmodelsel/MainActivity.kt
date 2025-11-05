package com.alexanderjimenez.counterviewmodelsel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.alexanderjimenez.counterviewmodelsel.viewModels.counterVewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val counterViewModel: counterVewModel by viewModels()
        setContent {
            MaterialTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Content(innerPadding, counterViewModel)
                }
            }
        }
    }
}

@Composable
fun Content(paddingValues: PaddingValues, counterViewModel: counterVewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .wrapContentSize(Alignment.Center)
    ) {
        Text("Counter: ${counterViewModel.counter.intValue}")
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = {
                counterViewModel.add()
            }
        ) {
            Text("Add")
        }
    }
}
