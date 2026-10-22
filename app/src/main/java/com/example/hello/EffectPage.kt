package com.example.hello

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import com.example.hello.ui.components.layout.AppPage
import com.example.hello.ui.theme.titleXLarge
import androidx.compose.ui.Alignment
import com.example.hello.ui.theme.colors
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.graphics.Brush
import  androidx.compose.ui.unit.sp
import  androidx.compose.ui.text.font.FontWeight
import  androidx.compose.ui.unit.dp
import androidx.compose.material3.CardElevation
import androidx.compose.ui.draw.shadow

@Composable
fun EffectPage(modifier: Modifier = Modifier, navController: NavController) {
    AppPage(modifier = modifier, scrollable = false) {
        Text(
            text = "Effect Page",
            color = colors.primary,
            style = titleXLarge,
            modifier = Modifier.align(Alignment.CenterHorizontally),
        )
        Spacer(modifier = Modifier.height(15.dp))
        Column(
            modifier = Modifier
                //.weight(1f)
                .fillMaxSize()
            //.background(colors.danger)
        )
        {
            //call function bellow
            BoxWellcome()
            Spacer(modifier = Modifier.height(15.dp))
            ShadowCard()
            Spacer(modifier = Modifier.height(15.dp))
            ShadowCard2()

        }
    }
}

@Composable
private fun BoxWellcome() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.horizontalGradient(
                    0f to colors.primary, //0%
                    0.9f to colors.secondary //90%
                ),

                RoundedCornerShape(12.dp)
            )
            .padding(5.dp, 30.dp),

        Alignment.Center //center
    ) {
        Text(
            text = "Chào Mừng",
            color = colors.white,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
        )

    }
}

@Composable
private fun ShadowCard() {
    val cardShape = RoundedCornerShape(12.dp)//border-radius
    Card(

        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation = 6.dp,
                shape = cardShape,
            ),
        shape = cardShape,
        colors = CardDefaults.cardColors(
            containerColor = colors.white,//màu nền
            contentColor = colors.text // màu chữ
        ),
    )
    {
        Text(
            text = "Card and box-shadow \n" +
                    "Card không có padding chính nó, nếu thêm nó sẽ đẩy ra khoảng cách xa giống margin",
           modifier = Modifier.padding(24.dp)
        )

    }
}
@Composable
private fun ShadowCard2() {
    val cardShape = RoundedCornerShape(12.dp)//border-radius
    Card(

        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation = 6.dp,
                shape = cardShape,
            ),
        shape = cardShape,
        colors = CardDefaults.cardColors(
            containerColor = colors.white,//màu nền
            contentColor = colors.text // màu chữ
        ),
    )
    {
        Text(
            text = "Card and box-shadow \n" +
                    "Card không có padding chính nó, nếu thêm nó sẽ đẩy ra khoảng cách xa giống margin",
            modifier = Modifier.padding(24.dp)
        )

    }
}