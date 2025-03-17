package com.example.timecapsule.pages


import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController

@Composable
fun ComposePage(navController: NavController) {
    var title by remember { mutableStateOf("") }

    OutlinedTextField(
        value = title,
        onValueChange = { title = it },
        label = { Text("Title") }
    )

}
