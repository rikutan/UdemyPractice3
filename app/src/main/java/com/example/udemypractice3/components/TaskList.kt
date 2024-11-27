package com.example.udemypractice3.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.udemypractice3.Task

// @Composableアノテーションを使って、Jetpack Composeで使用する関数を定義
// TaskListはタスクのリストを表示するコンポーザブル関数
@Composable
fun TaskList(
    tasks: List<Task>,                    // 表示するタスクのリスト（データソース）
    onClickRow: (Task) -> Unit,           // 行がクリックされたときの処理（ラムダ関数）
    onClickDelete: (Task) -> Unit         // 削除ボタンがクリックされたときの処理（ラムダ関数）
) {
    // LazyColumnを使用してリストを縦スクロール形式で表示
    LazyColumn {
        // itemsを使用して、タスクリストの各アイテムを1つずつ処理
        items(tasks) { task ->
            // TaskRowコンポーザブルを呼び出し、リストアイテムのUIを構築
            TaskRow(
                task = task,               // 現在のタスクデータを渡す
                onClickRow = onClickRow,   // 行クリック時の処理を渡す
                onClickDelete = onClickDelete // 削除ボタンのクリック時の処理を渡す
            )
        }
    }
}