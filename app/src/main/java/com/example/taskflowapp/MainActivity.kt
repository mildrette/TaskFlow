package com.example.taskflowapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.taskflowapp.navigation.NavGraph
import com.example.taskflowapp.ui.theme.TaskflowAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskflowAppTheme {
                    NavGraph()
            }
        }
    }
}

