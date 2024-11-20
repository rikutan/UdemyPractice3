package com.example.udemypractice3.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.udemypractice3.MainViewModel
import com.example.udemypractice3.ui.theme.BackgroundColor1
import com.example.udemypractice3.ui.theme.TextBorderColor


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditDialog(viewModel: MainViewModel = hiltViewModel()) {
    BasicAlertDialog(

        // ダイアログが閉じられるときの処理を指定
        onDismissRequest = { viewModel.isShowDialog = false },

        // ダイアログの動作を設定。今回は、外側クリックで閉じない
        //properties = DialogProperties(dismissOnClickOutside = false),

        // ダイアログ内に表示するカスタムコンテンツを指定。自由にレイアウト構築可能。
        content = {
            Box(modifier = Modifier.background(BackgroundColor1)) {
                Column(modifier = Modifier.padding(20.dp)) {

                    Text(
                        text = "タスク新規作成",
                        color = TextBorderColor,
                        textAlign = TextAlign.Center,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(20.dp))


                    // テキストフィールドの関数
                    CustomTextField(
                        text = "タイトル",
                        placeholder = "タイトル",
                        value = viewModel.title,
                        onValueChange = { viewModel.title = it }
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    CustomTextField(
                        text = "詳細",
                        placeholder = "詳細",
                        value = viewModel.description,
                        onValueChange = { viewModel.description = it }
                    )
                    Spacer(modifier = Modifier.height(20.dp))


                    // ボタンの関数
                    Row(
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .fillMaxWidth()
                    ) {
                        Button(onClick = {
                            viewModel.isShowDialog = false
                            viewModel.title = ""
                            viewModel.description = ""
                        }) {
                            Text(text = "キャンセル")
                        }
                        Spacer(modifier = Modifier.width(20.dp))

                        Button(
                            onClick = {
                                viewModel.isShowDialog = false
                                viewModel.createTask()
                            }, modifier = Modifier.width(200.dp)
                        ) {
                            Text(text = "決定")
                        }
                    }


                }
            }
        })
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun EditPreview(
    modifier: Modifier = Modifier
) {
    BasicAlertDialog(

        // ダイアログが閉じられるときの処理を指定
        onDismissRequest = {},

        // ダイアログの動作を設定。今回は、外側クリックで閉じない
        properties = DialogProperties(dismissOnClickOutside = false),

        // ダイアログ内に表示するカスタムコンテンツを指定。自由にレイアウト構築可能。
        content = {
            Box(modifier = Modifier.background(BackgroundColor1)) {
                Column(modifier = Modifier.padding(20.dp)) {

                    Text(
                        text = "タスク新規作成",
                        color = TextBorderColor,
                        textAlign = TextAlign.Center,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(20.dp))


                    // 入力欄
                    CustomTextField(text = "メールアドレス",
                        placeholder = "例）xxxxxx@exaple.com",
                        value = "",
                        onValueChange = {})
                    Spacer(modifier = Modifier.height(10.dp))

                    CustomTextField(text = "メールアドレス",
                        placeholder = "例）xxxxxx@exaple.com",
                        value = "",
                        onValueChange = {})
                    Spacer(modifier = Modifier.height(20.dp))

                    Row(
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .fillMaxWidth()
                    ) {
                        Button(onClick = {}) {
                            Text(text = "キャンセル")
                        }
                        Spacer(modifier = Modifier.width(20.dp))

                        Button(
                            onClick = {}, modifier = Modifier.width(200.dp)
                        ) {
                            Text(text = "決定")
                        }
                    }


                }
            }
        })

}