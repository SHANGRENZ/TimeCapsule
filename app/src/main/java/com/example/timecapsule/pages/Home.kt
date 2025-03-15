package com.example.timecapsule.pages

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.timecapsule.Conversation
import com.example.timecapsule.data

@Composable
fun HomePage(navController: NavController) {
    Conversation(data.sampleData)
}
