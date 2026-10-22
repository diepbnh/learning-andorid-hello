package com.example.hello

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.draw.alpha

import androidx.compose.ui.graphics.Brush
import  androidx.compose.ui.unit.sp
import  androidx.compose.ui.text.font.FontWeight
import  androidx.compose.ui.unit.dp
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import com.example.hello.ui.theme.boxShadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign

@Composable
fun EffectPage(modifier: Modifier = Modifier, navController: NavController) {
    AppPage(modifier = modifier, scrollable = true) {
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
            ImageWithTextCard()
            Spacer(modifier = Modifier.height(15.dp))
            ShadowCard()
            Spacer(modifier = Modifier.height(15.dp))
            ShadowCard2()
            Spacer(modifier = Modifier.height(15.dp))
            ShadowCard3()
            Spacer(modifier = Modifier.height(15.dp))
            AlphaModifyText()
            Spacer(modifier = Modifier.height(15.dp))
            AlphaCopyText()


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
            text = "Welcome",
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
            text = "Card sử dụng shadow mặc định.\n" +
                    "Card không có padding chính nó, nếu thêm nó sẽ đẩy ra khoảng cách xa giống margin",
            modifier = Modifier.padding(24.dp),
            lineHeight = 28.sp
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
                ambientColor = colors.primary,//viền mờ đều xung quanh
                spotColor = colors.primary//bóng đậm phía dưới
            ),
        shape = cardShape,
        colors = CardDefaults.cardColors(
            containerColor = colors.white,//màu nền
            contentColor = colors.text // màu chữ
        ),
    )
    {
        Text(
            text = "Card 2  \n" +
                    "Card sử dụng shadow đỗ màu xanh",
            modifier = Modifier.padding(24.dp)
        )

    }
}

@Composable
private fun ShadowCard3() {
    val cardShape = RoundedCornerShape(28.dp)//border-radius
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .boxShadow(
                color = colors.danger,
                x = 5.dp,
                y = 4.dp,
                blur = 6.dp,
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
            text = "Card 3 \n" +
                    "Card sử dụng shadow custom riêng và được truyền tham số tùy thích",
            modifier = Modifier.padding(24.dp)
        )

    }
}

@Composable
private fun ImageWithTextCard() {
    val cardShape = RoundedCornerShape(15.dp)
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .border(1.dp, colors.secondary, cardShape)
            .clip(cardShape)//bo góc gọi lại
        //.background(colors.primary)
    )
    {
        Image(
            painter = painterResource(R.drawable.banner),
            contentDescription = "Cover Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .matchParentSize() //độ lớn bằng cha
                .background(colors.white.copy(alpha = 0.5f)) //rgba(255,255,255,0.5)
        )
        Text(
            text = "Banner Image",
            fontWeight = FontWeight.Bold,
            //textAlign = TextAlign.End,
            fontSize = 20.sp,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(20.dp)
        )

    }
}

@Composable
private fun AlphaModifyText() {
    Column() {
        Text(
            text = "Modifier.alpha (mờ cả chữ)",
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(5.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp), //khoảng cách giữa các box
        ) {
            //gọi lại AlphaBox, tự truyền text + alpha
            AlphaBox(text = "100%", alpha = 1f, modifier = Modifier.weight(1f))
            AlphaBox(text = "60%", alpha = 0.6f, modifier = Modifier.weight(1f))
            AlphaBox(text = "30%", alpha = 0.3f, modifier = Modifier.weight(1f))
        }
    }
}

//box dùng chung cho AlphaDemoRow
@Composable
private fun AlphaBox(
    text: String, //chữ hiển thị
    alpha: Float = 1f, //độ mờ, mặc định không mờ
    modifier: Modifier = Modifier, //weight truyền từ Row vào
) {
    Box(
        modifier = modifier
            .height(40.dp)
            .clip(RoundedCornerShape(10.dp))
            .alpha(alpha)
            .background(colors.primary),
        contentAlignment = Alignment.Center //giữa ngang + giữa dọc
    ) {
        Text(
            text = text,
            color = colors.white,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
private fun AlphaCopyText() {
    Column() {
        Text(
            text = "colo.copy (alpha) (chữ vẫn rõ)",
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(5.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp), //khoảng cách giữa các box
        ) {
            //gọi lại AlphaBox, tự truyền text + alpha
            ColorAlPhaBox(text = "100%", textAlPha = 1f, modifier = Modifier.weight(1f))
            ColorAlPhaBox(text = "60%", textAlPha = 0.6f, modifier = Modifier.weight(1f))
            ColorAlPhaBox(text = "30%", textAlPha = 0.3f, modifier = Modifier.weight(1f))
        }
    }
}

//Box chữ mờ nhưng nền rõ dung copy(alpha)
@Composable
private fun ColorAlPhaBox(
    text: String, // chữ truyền vào
    textAlPha: Float = 1f, // độ mờ của chữ
    backgroundAlpha: Float = 1f, // độ mờ của nền
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(40.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(colors.primary.copy(alpha = backgroundAlpha)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = colors.white.copy(alpha = textAlPha),
            fontWeight = FontWeight.Medium
        )
    }

}
