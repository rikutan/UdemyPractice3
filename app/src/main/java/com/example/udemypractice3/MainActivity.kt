package com.example.udemypractice3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.udemypractice3.components.EditDialog
import com.example.udemypractice3.components.TaskList
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize().padding(top = 40.dp),
            ) {
                MainContent()
            }
        }
    }
}

@Composable
fun MainContent(viewModel: MainViewModel = hiltViewModel()) {
    if (viewModel.isShowDialog) {
        EditDialog()
    }

    // アプリ画面の基本レイアウトを作成するための構造。
    // トップバーやボトムバー、メインコンテンツ、FABなどを簡単に配置できる。
    Scaffold(
        floatingActionButton = {
        FloatingActionButton(onClick = { viewModel.isShowDialog = true }) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "新規作成")
        }
    }) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues))
        val tasks by viewModel.tasks.collectAsState(initial = emptyList())

        TaskList(
            tasks = tasks,
            onClickRow = {
                viewModel.setEditTask(it)
                viewModel.isShowDialog = true
            },
            onClickDelete ={ viewModel.deleteTask(it) },
        )
    }
}


@Preview(showBackground = true)
@Composable
fun MainPreview() {

    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        MainContent()
    }
}