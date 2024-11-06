package com.example.udemypractice3

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TaskDao {

    // データベースに保存するメソッドだと認識させる
    @Insert
    fun insertTask(task: Task)

    // DB からデータを全件取得するメソッド
    @Query("select * from Task")
    fun loadAllTasks(): List<Task>

    // DB に保存されているタスクを更新する
    @Update
    fun updateTask(task: Task)

    // DB からタスクを削除する
    @Delete
    fun deleteTask(task: Task)

}