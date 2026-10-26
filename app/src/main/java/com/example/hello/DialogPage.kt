package com.example.hello

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.hello.ui.components.button.AppButton
import com.example.hello.ui.components.layout.AppPage
import com.example.hello.ui.theme.colors
import com.example.hello.ui.theme.titleXLarge
import androidx.compose.material3.AlertDialog
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.window.DialogWindowProvider
import androidx.compose.ui.window.Dialog
import com.example.hello.ui.components.dialog.AppDialog
import com.example.hello.ui.theme.titleMedium
import com.example.hello.ui.components.dialog.AppDialogBottom

@Composable
fun DialogDimAmount(amount: Float) { //set giảm màu nền co dialog
    val view = LocalView.current
    SideEffect {
        val window = (view.parent as? DialogWindowProvider)?.window
        window?.setDimAmount(amount)
        window?.setWindowAnimations(0)

    }

}

@Composable
fun DialogPage(modifier: Modifier = Modifier, navController: NavController) {
    var showAlert by remember { mutableStateOf(false) }
    var showDialog by remember { mutableStateOf(false) }
    var showDialogCustom by remember { mutableStateOf(false) }
    var showDialogBottom by remember { mutableStateOf(false) }
    val dialogShape = RoundedCornerShape(15.dp) //border-radius

    AppPage(modifier = modifier) {
        Box(
            modifier = Modifier.fillMaxWidth()
            //.background(colors.danger)
        ) {
            Text(
                text = "Template",
                color = colors.primary,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .clickable( // dòng dưới là xóa bỏ hiệu ứng click
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    )
                    { navController.navigate("template") }
            )
            Text(
                text = "Dialog",
                color = colors.primary,
                style = titleXLarge,
                modifier = Modifier.align(Alignment.Center)
            )
        }
        Spacer(modifier = Modifier.height(25.dp))

        AppButton(
            text = "Alert Dialog",
            onClick = { showAlert = true },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(15.dp))
        AppButton(
            text = "Dialog",
            onClick = { showDialog = true },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(15.dp))
        AppButton(
            text = "Dialog custom",
            onClick = { showDialogCustom = true },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(15.dp))
        AppButton(
            text = "Dialog bottom",
            onClick = { showDialogBottom = true },
            modifier = Modifier.fillMaxWidth()
        )
    }

// dialog
    if (showAlert) {
        AlertDialog(
            onDismissRequest = { showAlert = false },
            title = {
                DialogDimAmount(0.2f)
                Text(text = "Title")
            },
            text = {
                Text(
                    text = "Trong lập trình Android, \n\n" +
                            "AlertDialog là lớp hộp thoại dùng để hiển thị thông báo quan trọng, câu hỏi xác nhận hoặc danh sách lựa chọn cho người dùng"
                )
            },


            confirmButton = {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    AppButton(
                        text = "Cancel",
                        backgroundColor = colors.danger,
                        onClick = { showAlert = false },
                        modifier = Modifier.weight(1f)
                    )
                    AppButton(
                        text = "OK",
                        onClick = { showAlert = false },
                        modifier = Modifier.weight(1f)
                    )

                }

            },
            containerColor = colors.backgroundCard,
            shape = dialogShape,
            titleContentColor = colors.text,
            textContentColor = colors.text,
        )

    }
    if (showDialog) {
        Dialog(onDismissRequest = { showDialog = false }) {
            DialogDimAmount(0.2f) //set giảm màu nền gọi thẳng, không cần mượn ô title

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(colors.backgroundCard, dialogShape) // tự vẽ nền + bo góc
                    .padding(20.dp)
            ) {
                Text(
                    text = "Are you sure?",
                    style = titleXLarge,
                )
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = "Do you want to log out?"
                )
                Spacer(modifier = Modifier.height(15.dp))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    AppButton(
                        text = "Cancel",
                        backgroundColor = colors.danger,
                        onClick = { showDialog = false },
                        modifier = Modifier.weight(1f)
                    )
                    AppButton(
                        text = "Ok",
                        onClick = { showDialog = false },
                        modifier = Modifier.weight(1f)
                    )

                }

            }

        }
    }
    if (showDialogCustom) {
        AppDialog(onDismissRequest = { showDialogCustom = false })
        { close ->

            Text(
                text = "Dialog Custom",
                style = titleXLarge,
                color = colors.text,
                modifier = Modifier.align(Alignment.CenterHorizontally)  // nhờ

            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "(Dialog, AlertDialog, Bottom Sheet)",
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "Bài này gom tất cả dialog vào một trang"
            )
            Spacer(modifier = Modifier.height(35.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.End),
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Cancel",
                    style = titleMedium,
                    color = colors.primary,
                    modifier = Modifier.clickable { close() }
                )
                Text(
                    text = "Submit",
                    style = titleMedium,
                    color = colors.primary,
                )
            }

        }
    }
    if (showDialogBottom){
        AppDialogBottom(onDismissRequest = { showDialogBottom = false }){
            close->
            Text(
                text = "Dialog Bottom",
                style = titleXLarge,
                color = colors.text
            )
        }
    }
}

