package com.example.udemypractice3

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity // 下記 data class がデータベースのテーブルを表す
// データベースのテーブル定義
data class Task(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    var title: String,
    var description: String,
)
