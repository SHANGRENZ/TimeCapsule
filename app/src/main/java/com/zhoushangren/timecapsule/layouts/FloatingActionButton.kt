package com.zhoushangren.timecapsule.layouts

import android.content.Intent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.zhoushangren.timecapsule.ComposeActivity

@Composable
fun ExtendedFAB() {

    val context = LocalContext.current

    ExtendedFloatingActionButton(
        onClick = {
            val intent = Intent(context, ComposeActivity::class.java)
            context.startActivity(intent)
        },
        icon = { Icon(Icons.Filled.Edit, "Extended floating action button.") },
        text = { Text(text = "Compose") },
    )
}