package com.example.udemypractice3

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject


// HiltでViewModelを定義＆テキストフィールドの入力保持ViewModel
@HiltViewModel
class MainViewModel @Inject constructor(private val taskDao: TaskDao) : ViewModel() {
    var title by mutableStateOf("")
    var description by mutableStateOf("")

    var isShowDialog by mutableStateOf(false)

    // データベースからタスクを取得
    var tasks = taskDao.loadAllTasks().distinctUntilChanged()

    private var editingTask: Task? = null
    val isEditing: Boolean
        get() = editingTask != null


    fun setEditTask(task: Task) {
        editingTask = task
        title = task.title
        description = task.description
    }

    // タスクを新規追加するメソッド
    fun createTask() {
        viewModelScope.launch {
            val newTask = Task(title = title, description = description)
            taskDao.insertTask(newTask)
            Log.d(MainViewModel::class.simpleName, "createTask")
        }
    }

    //　タスクを削除するメソッド
    fun deleteTask(task: Task) {
        viewModelScope.launch {
            taskDao.deleteTask(task)
        }
    }

    // タスクを更新するメソッド
    fun updateTask() {
        editingTask?.let { task ->
            viewModelScope.launch {
                task.title = title
                task.description = description
                taskDao.updateTask(task)
            }
        }
    }

    fun resetProperties() {
        editingTask = null
        title = ""
        description = ""
    }

}