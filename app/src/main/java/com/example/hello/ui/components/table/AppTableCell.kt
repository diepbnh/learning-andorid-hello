package com.example.hello.ui.components.table


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.example.hello.ui.theme.colors
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.geometry.Size

@Composable
fun AppTableCell(
    text: String,
    modifier: Modifier=Modifier,
    isHeader: Boolean=false,
    textAlign: TextAlign=TextAlign.Start,
)
{
    //lấy màu ra trước, vì bên trong drawBehind không gọi được colors
    val verticalLineColor=if(isHeader) colors.white else colors.primary
    val bottomLineColor=colors.primary
    Text(
        text=text,
        modifier=modifier
            .fillMaxHeight()
            .background(if(isHeader) colors.primary else Color.Transparent)
            .drawBehind {


                val stroke = 1.dp.roundToPx().toFloat()

                // Cạnh phải
                drawLine(
                    color = verticalLineColor,
                    start = Offset(
                        x = size.width - stroke / 2,
                        y = 0f
                    ),
                    end = Offset(
                        x = size.width - stroke / 2,
                        y = size.height
                    ),
                    strokeWidth = stroke
                )

                // Cạnh dưới
                drawLine(
                    color = bottomLineColor,
                    start = Offset(
                        x = 0f,
                        y = size.height - stroke / 2
                    ),
                    end = Offset(
                        x = size.width,
                        y = size.height - stroke / 2
                    ),
                    strokeWidth = stroke
                )
            }
            .padding(12.dp),

        color=if(isHeader) colors.white else colors.text,
        textAlign=textAlign,
        fontWeight = if(isHeader) FontWeight.Bold else FontWeight.Normal
    )
}