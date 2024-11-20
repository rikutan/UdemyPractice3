package com.example.udemypractice3.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.udemypractice3.Task

@Composable
fun TaskList(
    tasks: List<Task>,
    onClickRow:(Task) -> Unit,
    onClickDelete:(Task) -> Unit,
) {
    LazyColumn {
        items(tasks){ task ->
            TaskRow(
                task = task,
                onClickRow = onClickRow,
                onClickDelete = onClickDelete,
            )
        }
    }
}