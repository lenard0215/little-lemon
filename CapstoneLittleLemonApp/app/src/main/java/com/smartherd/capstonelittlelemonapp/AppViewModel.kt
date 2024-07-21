package com.smartherd.capstonelittlelemonapp

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.smartherd.capstonelittlelemonapp.data.AppUIState
import com.smartherd.capstonelittlelemonapp.data.OnBoardAction
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AppViewModel(application: Application) : AndroidViewModel(application) {

   private val database: AppDatabase

    init {
        database = Room.databaseBuilder(
            application,
            AppDatabase::class.java,
            "database"
        ).build()
    }
    fun getAllDatabaseMenuItems(): LiveData<List<MenuItemRoom>> {
        return database.menuItemDao().getAll()
    }

    fun fetchMenuDataFromDatabase(){
        viewModelScope.launch (Dispatchers.IO){
            if(database.menuItemDao().isEmpty())
                saveMenuToDatabase(database, fetchMenu(
                    "https://raw.githubusercontent.com/Meta-Mobile-Developer-PC/Working-With-Data-API/main/menu.json"))
                }
            }
        }


