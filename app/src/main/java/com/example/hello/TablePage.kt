package com.example.hello


import com.example.hello.ui.theme.colors
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider

import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import com.example.hello.ui.components.table.AppTableCell

@Composable
fun TablePage(modifier: Modifier = Modifier, navController: NavController) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()//true khi đang nhấn

    Scaffold(modifier, containerColor = Color.Transparent)
    { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
                .padding(32.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, colors.primary)//viền ngoài table
            ) {
                //header
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(IntrinsicSize.Min)//hàng cao bằng ô cao nhất
                        .background(colors.primary)
                ) {
                    Text(
                        "Product",
                        color = colors.white,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .weight(1.5f)
                            .padding(15.dp)

                    )
                    VerticalDivider(thickness = 1.dp, color = colors.white)
                    Text(
                        "Number",
                        color = colors.white,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.End,
                        modifier = Modifier
                            .weight(1f)
                            .padding(15.dp)
                    )
                    VerticalDivider(thickness = 1.dp, color = colors.white)
                    Text(
                        "Price",
                        color = colors.white,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .weight(1f)
                            .padding(15.dp)

                    )
                }
                //dong 1 table cell
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(IntrinsicSize.Min)//đường dọc cao bằng dòng
                ) {
                    Text(
                        text = "Car 01",
                        modifier = Modifier
                            .weight(1.5f)
                            .padding(15.dp)
                    )
                    VerticalDivider(thickness = 1.dp, color = colors.primary)//đường kẻ dọc
                    Text(
                        "12",
                        textAlign = TextAlign.End,
                        modifier = Modifier
                            .weight(1f)
                            .padding(15.dp)
                    )
                    VerticalDivider(thickness = 1.dp, color = colors.primary)
                    Text(
                        "200$",
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .weight(1f)
                            .padding(15.dp)
                    )
                }
                //dong 2
                HorizontalDivider(thickness = 1.dp, color = colors.primary) //đường kẻ ngang
                Row(
                    Modifier
                        .height(IntrinsicSize.Min)
                        .fillMaxWidth()

                ) {
                    Text(
                        "Car 01 dummy dummy",
                        modifier = Modifier
                            .weight(1.5f)
                            .padding(15.dp)

                    )
                    VerticalDivider(thickness = 1.dp, color = colors.primary)
                    Text(
                        "12",
                        textAlign = TextAlign.End,
                        modifier = Modifier
                            .weight(1f)
                            .padding(15.dp)
                    )
                    VerticalDivider(thickness = 1.dp, color = colors.primary)
                    Text(
                        "200$",
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .weight(1f)
                            .padding(15.dp)
                    )
                }
                //dòng 3

                HorizontalDivider(thickness = 1.dp, color = colors.primary)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(IntrinsicSize.Min)//đường dọc cao bằng dòng
                ) {
                    Text(
                        "Car 01",
                        modifier = Modifier
                            .weight(1.5f)
                            .padding(15.dp)

                    )
                    VerticalDivider(thickness = 1.dp, color = colors.primary)
                    Text(
                        "12",
                        textAlign = TextAlign.End,
                        modifier = Modifier
                            .weight(1f)
                            .padding(15.dp)
                    )
                    VerticalDivider(thickness = 1.dp, color = colors.primary)
                    Text(
                        "200$",
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .weight(1f)
                            .padding(15.dp)
                    )
                }
                HorizontalDivider(thickness = 1.dp, color = colors.primary)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(IntrinsicSize.Min)//đường dọc cao bằng dòng
                ) {
                    Text(
                        "Car 01",
                        modifier = Modifier
                            .weight(1.5f)
                            .padding(15.dp)

                    )
                    VerticalDivider(thickness = 1.dp, color = colors.primary)
                    Text(
                        "12",
                        textAlign = TextAlign.End,
                        modifier = Modifier
                            .weight(1f)
                            .padding(15.dp)
                    )
                    VerticalDivider(thickness = 1.dp, color = colors.primary)
                    Text(
                        "200$",
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .weight(1f)
                            .padding(15.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "Back",
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline,
                color = if (isPressed) colors.secondary else colors.primary,//đang nhấn -> secondary
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null//tắt hiệu ứng gợn sóng mặc định
                    ) {
                        navController.popBackStack()//quay lại trang trước
                    }
            )
            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "Table thứ 2: dùng tableCell",
            )
            Spacer(modifier = Modifier.height(15.dp))



            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, colors.primary)
            ) {
                Row(
                    Modifier.height(IntrinsicSize.Min)

                ) {
                    AppTableCell(
                        "Product",
                        isHeader = true,
                        modifier = Modifier.weight(1.5f)
                    )
                    AppTableCell(
                        "Number",
                        isHeader = true,
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.End
                    )
                    AppTableCell(
                        "Price",
                        isHeader = true,
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.End
                    )
                }
                Row(
                    Modifier.height(IntrinsicSize.Min)
                ) {
                    AppTableCell(
                        text = "Car 01 ",
                        modifier = Modifier.weight(1.5f)
                    )
                    AppTableCell(
                        text = "Car 01",
                        modifier = Modifier.weight(1f)
                    )
                    AppTableCell(
                        text = "Car 01",
                        modifier = Modifier.weight(1f)
                    )
                }
                Row(
                    Modifier.height(IntrinsicSize.Min)
                ) {
                    AppTableCell(
                        text = "Car 01 ",
                        modifier = Modifier.weight(1.5f)
                    )
                    AppTableCell(
                        text = "Car 01",
                        modifier = Modifier.weight(1f)
                    )
                    AppTableCell(
                        text = "Car 01",
                        modifier = Modifier.weight(1f)
                    )
                }
                Row(
                    Modifier.height(IntrinsicSize.Min)
                ) {
                    AppTableCell(
                        text = "Car 01 ",
                        modifier = Modifier.weight(1.5f)
                    )
                    AppTableCell(
                        text = "Car 01",
                        modifier = Modifier.weight(1f)
                    )
                    AppTableCell(
                        text = "Car 01",
                        modifier = Modifier.weight(1f)
                    )
                }
                Row(
                    Modifier.height(IntrinsicSize.Min)
                ) {
                    AppTableCell(
                        text = "Car 01 ",
                        modifier = Modifier.weight(1.5f)
                    )
                    AppTableCell(
                        text = "Car 01",
                        modifier = Modifier.weight(2f)
                    )

                }
            }
        }
    }
}

