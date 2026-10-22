package com.example.hello

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.hello.ui.components.layout.AppPage
import androidx.compose.material3.Text
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import com.example.hello.ui.theme.colors
import com.example.hello.ui.theme.titleXLarge
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.sp
import com.example.hello.ui.components.avatar.AppAvatar
import com.example.hello.ui.theme.titleMedium
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.IconButton

import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import com.example.hello.ui.components.animation.AppGrassButterfly


@Composable
fun ProfilePage(modifier: Modifier = Modifier, navController: NavController) {

    AppPage(modifier = modifier) {
        Box(
            modifier = Modifier.fillMaxWidth()
                //.background(colors.danger)
        ) {
            IconButton(
                onClick = {
                    navController.popBackStack()//về trước đó
                },
                modifier = Modifier.align(Alignment.CenterStart)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = colors.primary
                )
            }

            Text(
                text = "Profile Page",
                color = colors.primary,
                style = titleXLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()//width 100%
                    .align(Alignment.Center) // text center middle
            )
        }
        Spacer(modifier = Modifier.height(15.dp))

        //banner <div> bao ảnh lại
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .clip(RoundedCornerShape(10.dp))
        ) {
            Image(
                painter = painterResource(R.drawable.banner),
                contentDescription = "Cover Image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
        //hongdiep
        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = "Hong Diep",
            style = titleMedium,//style font weight đã định nghĩa sẵn
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "Frontend Developer",
            fontSize = 15.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(15.dp))

        //component avatar
        AppAvatar(
            imageRes = R.drawable.diep,
            borderWidth = 3.dp,
            borderColor = colors.white,
            shadowElevation = 20.dp,
            modifier = Modifier.align(Alignment.CenterHorizontally) //căn giữa
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            //cột home
            Column(
                modifier = Modifier
                    .weight(2f)
                    //.background(colors.secondary)
                    .padding(5.dp),
                horizontalAlignment = Alignment.CenterHorizontally//căn giữa tất cả con bên trong

            ) {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home",
                    tint = colors.primary,
                    // modifier = Modifier.align(Alignment.CenterHorizontally)

                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "Home",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium
                )
            }
            //cột home
            Column(
                modifier = Modifier
                    .weight(2f)
                    .padding(5.dp),
                horizontalAlignment = Alignment.CenterHorizontally//căn giữa tất cả con bên trong

            ) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Favorite",
                    tint = colors.danger,
                    modifier = Modifier.align(Alignment.CenterHorizontally)

                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "Favorite",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium
                )
            }
            //cột home
            Column(
                modifier = Modifier
                    .weight(2f)
                    .padding(5.dp),
                horizontalAlignment = Alignment.CenterHorizontally//căn giữa tất cả con bên trong

            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Profile",
                    tint = colors.primary,
                    modifier = Modifier.align(Alignment.CenterHorizontally)

                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "Profile",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
        //end row
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = buildAnnotatedString {
                append("Xin chào ! \nMình là ")
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("Hồng Điệp")
                }
                append(" Mình đang học lập trình Android với Jetpack Compose")
                append(
                    ". Mục tiêu cuối là dựng được giao diện người dùng trên thiết bị di động. " +
                            "Nhiêu đó thôi cũng đã đủ mệt roài.......ahihi..."
                )
            },

            )
        Spacer(modifier = Modifier.height(20.dp))
        //component grass butterfly
        AppGrassButterfly()

    }
}
