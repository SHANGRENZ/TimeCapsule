package com.zhoushangren.timecapsule

// lastly

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.zhoushangren.timecapsule.layouts.BottomNavigationBar
import com.zhoushangren.timecapsule.layouts.ExtendedFAB
import com.zhoushangren.timecapsule.pages.HomePage
import com.zhoushangren.timecapsule.pages.SettingsPage
import com.zhoushangren.timecapsule.ui.theme.TimeCapsuleTheme


data class Message(val author: String, val body: String)
object data {
    val sampleData = listOf(
        Message("Doge", "Hello everyone!"),
        Message("Cat", "Yo whats up?\nExcited!")
    )

}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TimeCapsule()
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimeCapsule() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) },
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Time Capsule")
                }
            )
        },
        floatingActionButton = {
            ExtendedFAB()
        }
    ) { innerPadding ->
        NavHost(navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)) {
            composable("home") { HomePage(navController) }
            composable("settings") { SettingsPage(navController) }
        }
    }
}


@Composable
fun MessageCard(msg: Message) {
    Row {
        Text(text = "ICON ")
        Column {
            Text(text = msg.author)
            Text(text = msg.body)
        }
    }

}

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) {
            message -> MessageCard(message)
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TimeCapsuleTheme {
        Conversation(data.sampleData)
    }
}