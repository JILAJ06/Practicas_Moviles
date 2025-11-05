package com.danielflores.navigaton4c

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.danielflores.navigationarepeticion.presentation.views.HomeView
import com.danielflores.navigaton4c.presentation.navManager.NavManager
import com.danielflores.navigaton4c.ui.theme.Navigaton4cTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Navigaton4cTheme {
                NavManager()
            }
        }
    }
}