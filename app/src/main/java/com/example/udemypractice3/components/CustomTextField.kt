package com.example.udemypractice3.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.udemypractice3.ui.theme.BackgroundColor1
import com.example.udemypractice3.ui.theme.LabelPlaceholderColor
import com.example.udemypractice3.ui.theme.TextBorderColor

@Composable
fun CustomTextField(
    text: String,
    placeholder: String,
    value: String,
    onValueChange: (String) -> Unit,
) {
    Column {
        Text(text = text, fontSize = 15.sp, color = TextBorderColor)

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = placeholder, color = LabelPlaceholderColor) },
            shape = RoundedCornerShape(15.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = BackgroundColor1,
                unfocusedContainerColor = BackgroundColor1,
            ),
            value = value,
            onValueChange = onValueChange,
            singleLine = true,
        )
    }
}