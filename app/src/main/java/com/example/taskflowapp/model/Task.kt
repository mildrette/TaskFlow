package com.example.taskflowapp.model

data class Task(
    val id: Int,
    val title: String,
    val isCompleted: Boolean = false
)
