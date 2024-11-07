package com.example.udemypractice3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.udemypractice3.components.EditDialog
import com.example.udemypractice3.ui.theme.Purple40
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Purple40
            ) {
                MainContent()
            }
        }
    }
}

@Composable
fun MainContent() {
    val isShowDialog = remember { mutableStateOf(false) }
    if (isShowDialog.value) {
        EditDialog(isShowDialog)
    }

    // アプリ画面の基本レイアウトを作成するための構造。
    // トップバーやボトムバー、メインコンテンツ、FABなどを簡単に配置できる。
    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = { isShowDialog.value = true }) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "新規作成")
        }
    }) {

    }
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Purple40
    ) {
        MainContent()
    }
}