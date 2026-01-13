package com.example.taskflowapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.taskflowapp.components.TaskItem
import com.example.taskflowapp.model.Task

@Composable
fun HomeScreen(navController: NavController) {
    var tasks by remember { mutableStateOf(listOf<Task>()) }
    var taskId by remember { mutableStateOf(0) }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("addTask")
                }
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add Task")
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {
            Text(
                text = "My Tasks",
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn {
                items(tasks) { task ->
                    TaskItem(
                        task = task,
                        onToggleComplete = {
                            tasks = tasks.map {
                                if (it.id == task.id)
                                    it.copy(isCompleted = !it.isCompleted)
                                else it
                            }
                        },
                        onDelete = {
                            tasks = tasks.filterNot { it.id == task.id }
                        }
                    )
                }
            }
        }
    }

    val newTaskTitle =
        navController.currentBackStackEntry
            ?.savedStateHandle
            ?.get<String>("taskTitle")

    newTaskTitle?.let {
        tasks = tasks + Task(taskId++, it)
        navController.currentBackStackEntry
            ?.savedStateHandle
            ?.remove<String>("taskTitle")
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    val navController = rememberNavController()

    HomeScreen(navController = navController)
}
