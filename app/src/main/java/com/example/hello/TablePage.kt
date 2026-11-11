package com.example.hello

import com.example.hello.ui.theme.colors
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.style.TextAlign
import com.example.hello.ui.components.table.AppTableCell
import androidx.compose.material3.TextButton
import com.example.hello.ui.components.layout.AppPage
import com.example.hello.ui.components.layout.AppTopBar


data class Product(
    val name: String,
    val number: String,
    val price: String
)

val products = listOf(
    Product("Car 01", "12", "200$"),
    Product("Car 02", "12", "200$"),
    Product("Car 03", "12", "200$"),
    Product("Car 04", "12", "200$"),
)

@Composable
fun TablePage(modifier: Modifier = Modifier, navController: NavController) {
    AppPage(
        modifier = modifier,
        topBar = {
            AppTopBar(
                title = "Table",
                navigationIcon = {

                    IconButton(
                        onClick = { navController.popBackStack() },
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                actions = {
                    TextButton(
                        onClick = { navController.navigate("template") },
                    ) {
                        Text(
                            text = "Template",
                            color = colors.white,
                        )
                    }
                }

            )
        }
    )
    {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, colors.primary)//table outer border
        ) {
            //table
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)//row height = tallest cell
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
            //row 1 table cell
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)//vertical line matches row height
            ) {
                Text(
                    text = "Car 01",
                    modifier = Modifier
                        .weight(1.5f)
                        .padding(15.dp)
                )
                VerticalDivider(thickness = 1.dp, color = colors.primary)//vertical divider
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
            //row 2
            HorizontalDivider(thickness = 1.dp, color = colors.primary) //horizontal divider
            Row(
                Modifier
                    .height(IntrinsicSize.Min)
                    .fillMaxWidth()
                    .background(colors.light)

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
            //row 3

            HorizontalDivider(thickness = 1.dp, color = colors.primary)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)//vertical line matches row height
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
                    .height(IntrinsicSize.Min)//vertical line matches row height
                    .background(colors.light)
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


        Spacer(
            modifier = Modifier.height(25.dp)
        )

        Text(
            text = "Table 2: using tableCell",
        )
        Spacer(modifier = Modifier.height(15.dp))


        //table 2
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
                Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
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
                Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
            ) {
                AppTableCell(
                    text = "Car 01 ",
                    modifier = Modifier.weight(3f)
                )
                AppTableCell(
                    text = "Car 01",
                    modifier = Modifier.weight(4f)
                )

            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        //table 3
        Text(
            text = "Table 3: using tableCell",
        )
        Spacer(modifier = Modifier.height(8.dp))
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
            products.forEachIndexed { index, product ->
                Row(
                    Modifier
                        .fillMaxWidth()
                        .height(IntrinsicSize.Min)
                        .background(
                            if (index % 2 == 0) Color.Transparent   // even
                            else colors.light                       // odd
                        )

                ) {
                    AppTableCell(product.name, modifier = Modifier.weight(1.5f))
                    AppTableCell(
                        product.number,
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.End
                    )
                    AppTableCell(
                        product.price,
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.End
                    )
                }
            }
        }

    }
}


