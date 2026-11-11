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
import androidx.compose.ui.Alignment
import com.example.hello.ui.theme.colors
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import com.example.hello.ui.theme.boxShadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.material3.Icon
import com.example.hello.ui.components.layout.AppTopBar


@Composable
fun CardPage(modifier: Modifier = Modifier, navController: NavController) {
    AppPage(
        modifier = modifier,
        scrollable = true,
        topBar = {
            AppTopBar(
                title = "Card",
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }

                }
            )
        }

    ) {

        Column(
            modifier = Modifier
                //.weight(1f)
                .fillMaxSize()
            //.background(colors.danger)
        )
        {
            //call function bellow
            BoxWelcome()
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
private fun BoxWelcome() {
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
            containerColor = colors.backgroundCard,//background color
            contentColor = colors.text // text color
        ),
    )
    {
        Text(
            text = "Card using the default shadow.\n" +
                    "Card has no padding of its own; adding it pushes spacing out like margin",
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
                ambientColor = colors.primary,//soft glow all around
                spotColor = colors.primary//darker shadow below
            ),
        shape = cardShape,
        colors = CardDefaults.cardColors(
            containerColor = colors.backgroundCard,//background color
            contentColor = colors.text // text color
        ),
    )
    {
        Text(
            text = "Card 2  \n" +
                    "Card using a blue shadow",
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
            containerColor = colors.backgroundCard,//background color
            contentColor = colors.text // text color
        ),
    )
    {
        Text(
            text = "Card 3 \n" +
                    "Card using a custom shadow with any parameters you like",
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
            .clip(cardShape)//reuse rounded corners
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
                .matchParentSize() //same size as parent
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
    Column {
        Text(
            text = "Modifier.alpha (text faded too)",
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(5.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp), //gap between boxes
        ) {
            //reuse AlphaBox, pass text + alpha
            AlphaBox(text = "100%", alpha = 1f, modifier = Modifier.weight(1f))
            AlphaBox(text = "60%", alpha = 0.6f, modifier = Modifier.weight(1f))
            AlphaBox(text = "30%", alpha = 0.3f, modifier = Modifier.weight(1f))
        }
    }
}

//shared box for AlphaDemoRow
@Composable
private fun AlphaBox(
    modifier: Modifier = Modifier, //weight passed in from Row
    text: String, //display text
    alpha: Float = 1f, //opacity, default fully opaque
) {
    Box(
        modifier = modifier
            .height(40.dp)
            .clip(RoundedCornerShape(10.dp))
            .alpha(alpha)
            .background(colors.primary),
        contentAlignment = Alignment.Center //center horizontally + vertically
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
    Column {
        Text(
            text = "color.copy (alpha) (text stays clear)",
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(5.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp), //gap between boxes
        ) {
            //reuse AlphaBox, pass text + alpha
            ColorAlPhaBox(text = "100%", backgroundAlpha = 1f, modifier = Modifier.weight(1f))
            ColorAlPhaBox(text = "60%", backgroundAlpha = 0.6f, modifier = Modifier.weight(1f))
            ColorAlPhaBox(text = "30%", backgroundAlpha = 0.2f, modifier = Modifier.weight(1f))
        }
    }
}

//Box with faded text but clear background using copy(alpha)
@Composable
private fun ColorAlPhaBox(
    modifier: Modifier = Modifier,
    text: String, // text passed in
    textAlPha: Float = 1f, // text opacity
    backgroundAlpha: Float = 1f, // background opacity

) {
    Box(
        modifier = modifier
            .height(40.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(colors.danger.copy(alpha = backgroundAlpha)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = colors.white.copy(alpha = textAlPha),
            fontWeight = FontWeight.Medium
        )
    }

}
