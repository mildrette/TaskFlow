package com.example.taskflowapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import androidx.navigation.compose.NavHost
import com.example.taskflowapp.screens.AddTaskScreen
import com.example.taskflowapp.screens.HomeScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(navController)
        }
        composable("addTask") {
            AddTaskScreen(navController)
        }
    }
}
