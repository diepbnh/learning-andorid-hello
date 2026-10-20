package com.example.hello

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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


@Composable
fun ProfilePage(modifier: Modifier = Modifier, navController: NavController) {

    AppPage(modifier = modifier) {
        Text(
            text = "Profile Page",
            color = colors.primary,
            style = titleXLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()//width 100%
        );
        Spacer(modifier=Modifier.height(15.dp))

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
            style = titleMedium,
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
            imageRes = R.drawable.avatar01,
            borderWidth = 2.dp,
            borderColor = colors.white,
            modifier = Modifier.align(Alignment.CenterHorizontally) //căn giữa
        )

        Row(
            modifier=Modifier.fillMaxWidth(),
        ) {
            //cột home
            Column(
                modifier = Modifier.weight(1f),
            ) {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home",
                    tint = colors.primary,
                    modifier = Modifier.align(Alignment.CenterHorizontally)

                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Home",
                    fontSize = 13.sp
                )
            }
        }
    }

}
