package com.smartherd.capstonelittlelemonapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.smartherd.capstonelittlelemonapp.data.AppUIState
import com.smartherd.capstonelittlelemonapp.data.OnBoardAction

class AppViewModel2 : ViewModel() {
   var  appUIState by mutableStateOf(AppUIState())
    private set

    fun onEvent(event: OnBoardAction){

        when(event){
            is OnBoardAction.EmailChanged -> {
                appUIState = appUIState.copy(
                email = event.email
            )}
            is OnBoardAction.FirstNameChanged ->{
                appUIState = appUIState.copy(
                    firstName = event.firstName
                )}
            is OnBoardAction.LastNameChanged ->{
                appUIState = appUIState.copy(
                    email = event.lastName
        )}
        }
    }
}