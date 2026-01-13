package com.example.taskflowapp.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.taskflowapp.model.Task

@Composable
fun TaskItem(
    task: Task,
    onToggleComplete: () -> Unit,
    onDelete: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = task.isCompleted,
                onCheckedChange = { onToggleComplete() }
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = task.title,
                modifier = Modifier.weight(1f),
                style = MaterialTheme.typography.bodyLarge
            )

            IconButton(onClick = onDelete) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete task"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TaskItemPreview() {
    val sampleTask = Task(id = 0, title = "Sample Task", isCompleted = false)
    TaskItem(
        task = sampleTask,
        onToggleComplete = {},
        onDelete = {}
    )
}
