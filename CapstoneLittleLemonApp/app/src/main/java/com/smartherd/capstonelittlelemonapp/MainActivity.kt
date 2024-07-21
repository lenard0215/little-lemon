package com.smartherd.capstonelittlelemonapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.smartherd.capstonelittlelemonapp.navigation.Navigation
import com.smartherd.capstonelittlelemonapp.ui.theme.CapstoneLittleLemonAppTheme

class MainActivity : ComponentActivity() {

    val sharedPreferences by lazy { getSharedPreferences("Little Lemon", MODE_PRIVATE) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CapstoneLittleLemonAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   val navController = rememberNavController()
                   Navigation(context = applicationContext, navController = navController)
                }
            }
        }
    }
}
