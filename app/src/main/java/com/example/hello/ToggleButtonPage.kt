package com.example.hello


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.hello.ui.components.animation.AppFadeBox
import com.example.hello.ui.components.animation.AppSlideUp
import com.example.hello.ui.components.animation.AppToggleBox
import com.example.hello.ui.components.animation.AppToggleButton
import com.example.hello.ui.components.button.AppButton
import com.example.hello.ui.components.layout.AppPage
import com.example.hello.ui.theme.colors
import com.example.hello.ui.theme.titleMedium
import com.example.hello.ui.theme.titleXLarge


@Composable
fun ToggleButtonPage(modifier: Modifier = Modifier, navController: NavController) {
    AppPage(modifier = modifier) {

        Box(
            modifier = Modifier.fillMaxWidth()
            //.background(colors.danger)
        ) {
            Text(
                text = "Login",
                color = colors.primary,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .clickable { navController.navigate("login") }
            )
            Text(
                text = "Toggle Button",
                color = colors.primary,
                style = titleXLarge,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Spacer(modifier = Modifier.height(25.dp))
        Text(
            text = "Button toggle ",
            style = titleMedium
        )
        Spacer(modifier = Modifier.height(10.dp))
        AppToggleButton(
            hideText = "Click",
            showText = "Clicked",
            durationMillis = 400,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = "Toggle Box ",
            style = titleMedium
        )
        Spacer(modifier = Modifier.height(10.dp))
        AppToggleBox(
            hideText = "Visible content",
            showText = "Show content",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
        ) {
            val cardShape = RoundedCornerShape(12.dp)
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(
                        elevation = 6.dp,
                        shape = cardShape
                    ),
                shape = cardShape,
                colors = CardDefaults.cardColors(
                    containerColor = colors.backgroundCard,
                    contentColor = colors.text
                )
            ) {
                Text(
                    text = "Xin chào Compose! Đây là box text.",
                    modifier = Modifier.padding(12.dp, 30.dp)
                )
            }

        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Fade In - Fade Out",
            style = titleMedium
        )
        Spacer(modifier = Modifier.height(10.dp))
        AppFadeBox(
            showText = "Show",
            hideText = "Hide",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
        ) {
            val cardShape = RoundedCornerShape(12.dp)
            Text(
                text = "Xin chào Fade!",
                textAlign = TextAlign.Center,

                modifier = Modifier
                    .shadow(elevation = 6.dp, shape = cardShape)// đỗ bóng cả hợp
                    .fillMaxWidth()
                    .background(
                        color = colors.backgroundCard,
                        shape = cardShape,

                        )
                    .padding(12.dp, 30.dp)

            )


        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Toggle button radius",
            style = titleMedium
        )
        Spacer(modifier = Modifier.height(10.dp))
        AppToggleButton(
            hideText = "Small",
            showText = "Big",
            inactiveRadius = 25.dp,
            activeRadius = 0.dp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(15.dp))
        val playCount = remember { mutableStateOf(0) }


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min=70.dp), // min height
        ) {


        AppSlideUp(
            playKey = playCount.value,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = "Xin chào, Hong Diep!",
                style = titleMedium,
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        AppSlideUp(
            durationMillis = 700,
            delayMillis = 150,
            playKey = playCount.value,
            modifier = Modifier.align(Alignment.CenterHorizontally)

            ) {
            Text(text = "Chúc bạn một ngày học vui vẻ.")
        }
        }
        //end colunm


        Spacer(modifier = Modifier.height(25.dp))
        AppButton(
            text = "Click animation text",
            onClick = {
                playCount.value=playCount.value + 1
            },
        )

    }

}