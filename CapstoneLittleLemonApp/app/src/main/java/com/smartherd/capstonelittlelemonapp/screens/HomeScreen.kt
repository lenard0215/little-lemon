package com.smartherd.capstonelittlelemonapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.smartherd.capstonelittlelemonapp.AppViewModel
import com.smartherd.capstonelittlelemonapp.appcomponents.Header
import com.smartherd.capstonelittlelemonapp.appcomponents.LowerPanel
import com.smartherd.capstonelittlelemonapp.appcomponents.UpperPanel

@Composable
fun HomeScreen( navController: NavHostController){
    val appViewModel: AppViewModel = viewModel()
    val databaseMenuItems = appViewModel.getAllDatabaseMenuItems().observeAsState(emptyList()).value
    val searchPhrase = remember {
        mutableStateOf("")
    }
    LaunchedEffect(Unit){
        appViewModel.fetchMenuDataFromDatabase()
    }
    Column {
        Header(navController)
        UpperPanel { searchPhrase.value = it }
        LowerPanel(databaseMenuItems = databaseMenuItems, search = searchPhrase)

            }
}
