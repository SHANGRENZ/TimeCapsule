package com.zhoushangren.timecapsule.pages

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.zhoushangren.timecapsule.Conversation
import com.zhoushangren.timecapsule.data

@Composable
fun HomePage(navController: NavController) {
    Conversation(data.sampleData)
}
