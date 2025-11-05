package com.alexanderjimenez.counterviewmodelsel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.alexanderjimenez.counterviewmodelsel.ui.theme.CounterViewModelSelTheme

annotation class CounterVewModel()

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val counterVewModel: CounterVewModel = CounterVewModel()
        setContent {
        enableEdgeToEdge()
        setContent {
            CounterViewModelSelTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Content(paddingValues = innerPadding)

                }
            }
        }
    }
}

@Composable
fun Content(paddingValues: PaddingValues) {
    var (_counter) = rememberSaveable {
        mutableIntStateOf(0)
    }

    Column(modifier = Modifier
        .padding(paddingValues = paddingValues)
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        Text(text = "Counter: $_counter")
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = {
            _counter++
        }) {
            Text(text = "+")
        }
    }
    }
}


