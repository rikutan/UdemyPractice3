package com.example.udemypractice3

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    // 非同期ワンショットクエリ：suspend を fun の前に付ける

    // データベースに保存するメソッドだと認識させる
    @Insert
    suspend fun insertTask(task: Task)

    // DB からデータを全件取得するメソッド
    @Query("select * from Task")
    fun loadAllTasks(): Flow<List<Task>>

    // DB に保存されているタスクを更新する
    @Update
    suspend fun updateTask(task: Task)

    // DB からタスクを削除する
    @Delete
    suspend fun deleteTask(task: Task)

}