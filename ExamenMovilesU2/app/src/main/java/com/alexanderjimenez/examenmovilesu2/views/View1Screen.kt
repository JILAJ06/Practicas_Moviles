package com.alexanderjimenez.examenmovilesu2.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.alexanderjimenez.examenmovilesu2.data.AppDatabase
import com.alexanderjimenez.examenmovilesu2.viewModel.UserViewModel
import com.alexanderjimenez.examenmovilesu2.viewModel.UserViewModelFactory

@Composable
fun View1Screen() {
    val context = LocalContext.current
    val database = AppDatabase.getDatabase(context)
    val userViewModel: UserViewModel = viewModel(factory = UserViewModelFactory(database.userDao()))
    val users by userViewModel.allUsers.collectAsState()
    var newUserName by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Row(modifier = Modifier.fillMaxWidth()) {
            TextField(
                value = newUserName,
                onValueChange = { newUserName = it },
                label = { Text("New user name") },
                modifier = Modifier.weight(1f)
            )
            Button(onClick = { 
                if (newUserName.isNotBlank()) {
                    userViewModel.addUser(newUserName)
                    newUserName = ""
                }
            }) {
                Text("Add")
            }
        }

        LazyColumn {
            items(users) { user ->
                Text(text = user.name, modifier = Modifier.padding(8.dp))
            }
        }
    }
}
@Preview
@Composable
fun View1ScreenPreview() {
    View1Screen()
}