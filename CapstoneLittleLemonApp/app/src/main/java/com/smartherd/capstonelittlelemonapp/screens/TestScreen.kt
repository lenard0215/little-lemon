package com.smartherd.capstonelittlelemonapp.screens

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.smartherd.capstonelittlelemonapp.appcomponents.TextFieldComponent


@Composable
fun TestScreen(context: Context, navController: NavHostController) {
Box(
modifier = Modifier.fillMaxSize(),
contentAlignment = Alignment.Center
) {
    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)) {
        Column {
            TextFieldComponent(labelValue = "text", onTextSelected = {})
            Spacer(modifier = Modifier.height(10.dp))
                    }
        }
    }
}