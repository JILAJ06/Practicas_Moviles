package com.alexanderjimenez.examenu2.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.alexanderjimenez.examenu2.data.User
import com.alexanderjimenez.examenu2.viewmodels.UserViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

import androidx.compose.foundation.layout.Column

@Composable
fun View2(userViewModel: UserViewModel) {
    val users by userViewModel.allUsers.collectAsState(initial = emptyList())
    var name by remember { mutableStateOf("")
    }
    var lastname by remember { mutableStateOf("")
    }
    var email by remember { mutableStateOf("")
    }
    var password by remember { mutableStateOf("")
}

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .padding(bottom = 80.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nombre del Usuario") },
            modifier = Modifier.fillMaxWidth()
            .padding(bottom = 8.dp)

        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = lastname,
            onValueChange = { lastname= it },
            label = { Text("Apellido del Usuario") },
            modifier = Modifier.fillMaxWidth()
            .padding(bottom = 8.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Correo del Usuario") },
            modifier = Modifier.fillMaxWidth()
            .padding(bottom = 8.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("contraseña del Usuario") },
            modifier = Modifier.fillMaxWidth()
            .padding(bottom = 8.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                if (name.isNotBlank()) {
                    userViewModel.insert(User(name = name, lastname = lastname, email = email, password = password))
                    name = ""
                    lastname = ""
                    email = ""
                    password = ""
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar Usuario")
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(users) { user ->
                Text(text = user.name, modifier = Modifier.padding(8.dp))
            }
        }
    }
}