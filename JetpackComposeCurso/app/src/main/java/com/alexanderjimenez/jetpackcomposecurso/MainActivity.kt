package com.alexanderjimenez.jetpackcomposecurso

import android.R.style.Theme
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alexanderjimenez.jetpackcomposecurso.ui.theme.JetpackComposeCursoTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeCursoTheme() {
                MyComponent()
            }

        }
    }
}
@Composable
fun MyComponent(){
    Row(modifier = Modifier
        .background(MaterialTheme.colorScheme.background)
        .padding(8.dp)


    ) {
        MyImage()
        MyTexts()
    }
}
@Composable
fun MyImage(){
    Image(
        painterResource(R.drawable.ic_launcher_foreground),
        "Mi imagen de prueba", Modifier
            .size(64.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary)
    )
}
@Composable
fun MyTexts() {
    Column(modifier = Modifier
        .padding(start = 8.dp)
    ) {
        MyText("Hello World",
            MaterialTheme.colorScheme.primary,
            MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp))
        MyText("¿Cómo están?",
            MaterialTheme.colorScheme.onBackground,
            MaterialTheme.typography.titleMedium
        )
    }
}
@Composable
fun MyText(text: String, color: Color, style: TextStyle) {
    Text(text, color = color, style = style)
}
@Preview(showSystemUi = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun PreviewMyComposable() {
    JetpackComposeCursoTheme {
        MyComponent()
    }
}