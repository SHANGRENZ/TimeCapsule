package com.example.timecapsule

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.timecapsule.ui.theme.TimeCapsuleTheme

import androidx.compose.material3.Text

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.navigation.NavController
import androidx.navigation.compose.*



import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.remember


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue

// lastly

import com.example.timecapsule.ExtendedFAB


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
            ExtendedFAB {  }
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
fun BottomNavigationBar(navController: NavController) {

    var selectedItem by remember { mutableIntStateOf(0) }
    val items = listOf("Home", "Settings")
    val itemsRoutes = listOf("home", "settings")
    val selectedIcons = listOf(Icons.Filled.Home, Icons.Filled.Settings)
    val unselectedIcons =
        listOf(Icons.Outlined.Home, Icons.Outlined.Settings)

    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        if (selectedItem == index) selectedIcons[index] else unselectedIcons[index],
                        contentDescription = item
                    )
                },
                label = { Text(item) },
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    navController.navigate(itemsRoutes[index])
                }
            )
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
fun HomePage(navController: NavController) {
    Conversation(data.sampleData)
}

@Composable
fun SettingsPage(navController: NavController) {
    Text("This is my page")
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