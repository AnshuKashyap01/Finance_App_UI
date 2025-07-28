package com.example.bankingapp

import android.R.attr.fontWeight
import android.R.attr.text
import android.R.attr.top
import android.util.Log.i
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AttachMoney
import androidx.compose.material.icons.rounded.CurrencyFranc
import androidx.compose.material.icons.rounded.CurrencyRupee
import androidx.compose.material.icons.rounded.CurrencyYen
import androidx.compose.material.icons.rounded.CurrencyYuan
import androidx.compose.material.icons.rounded.Euro
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankingapp.Data.Currency
import com.example.bankingapp.ui.theme.BlueStart
import com.example.bankingapp.ui.theme.GreenStart
import com.example.bankingapp.ui.theme.PurpleStart
import java.nio.file.WatchEvent

val currenciesList = listOf(
    Currency(
        name ="USD",
        buy = 24.53f,
        sell =  26.98f,
        icon = Icons.Rounded.AttachMoney
    ),
    Currency(
        name ="RUP",
        buy = 12.46f,
        sell =  16.93f,
        icon = Icons.Rounded.CurrencyRupee
    ),
    Currency(
        name ="EUR",
        buy = 54.83f,
        sell =  56.38f,
        icon = Icons.Rounded.Euro
    ),
    Currency(
        name ="YEN",
        buy = 4.33f,
        sell =  10.98f,
        icon = Icons.Rounded.CurrencyYen
    ),
    Currency(
        name ="FRA",
        buy = 32.63f,
        sell =  36.75f,
        icon = Icons.Rounded.CurrencyFranc
    ),
    Currency(
        name ="YUA",
        buy = 13.54f,
        sell =  06.45f,
        icon = Icons.Rounded.CurrencyYuan
    )

)

@Preview
@Composable
fun CurrenciesSection(){

    var isVisible by remember{
        mutableStateOf(false)
    }

    var iconState by remember {
        mutableStateOf(Icons.Rounded.KeyboardArrowUp)
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(top  =  32.dp),
        contentAlignment = Alignment.BottomCenter


    ){

    Column(modifier = Modifier
            .clip(RoundedCornerShape(topEnd = 30.dp , topStart = 30.dp))
        .background(MaterialTheme.colorScheme.inverseOnSurface)
        .animateContentSize()

    ) {
        Row(modifier = Modifier
            .padding(14.dp)
            .animateContentSize()
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.secondary)
                    .clickable{
                        isVisible = !isVisible
                        if(isVisible){
                            iconState = Icons.Rounded.KeyboardArrowDown
                        }else{
                            iconState = Icons.Rounded.KeyboardArrowUp
                        }
                    }
                   ){

                Icon(
                    modifier = Modifier.size(25.dp),
                    imageVector = iconState,
                    contentDescription = "",
                    tint = MaterialTheme.colorScheme.onSecondary
                )
            }
            Spacer(modifier = Modifier.width(25.dp))

            Text(
                text =  "Currencies",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier
            .height(1.dp)
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.secondaryContainer))


if (isVisible) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
            .clip(RoundedCornerShape(topEnd = 25.dp, topStart = 25.dp))
            .background(MaterialTheme.colorScheme.background)
    ) {
        val boxWithConstraintsScope = this
        val width = boxWithConstraintsScope.maxWidth / 3

        Column(modifier = Modifier.
                      fillMaxWidth()
                    .padding(horizontal = 16.dp)
        )
        {

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {


                Text(
                    modifier = Modifier.width(width),
                    text = "Currency",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onBackground
                )

                Text(
                    modifier = Modifier.width(width),
                    text = "Buy",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onBackground,
                    textAlign = TextAlign.End
                )

                Text(
                    modifier = Modifier.width(width),
                    text = "Sell",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onBackground,
                    textAlign = TextAlign.End

                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn {
                items(currenciesList.size) { index ->
                    CurrencyItem(index, width)
                }
            }
        }
    }
}
    }
    }

}


@Composable
fun CurrencyItem(index: Int , width: Dp){
    val currency = currenciesList[index]
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Row(
            modifier = Modifier.width(width),
            verticalAlignment = Alignment.CenterVertically

            )
        {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(GreenStart)
                    .padding(4.dp)
            ) {
                Icon(
                    modifier = Modifier.size(18.dp),
                    imageVector = currency.icon,
                    contentDescription = currency.name,
                    tint = Color.White
                )
            }

            Text(
                modifier = Modifier.padding(start = 10.dp),
                text = currency.name,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground,

                )
        }
        Text(
            modifier = Modifier.width(width).padding(start =10.dp),
            text = "$"+currency.buy.toString(),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.End
        )

        Text(
            modifier = Modifier.width(width).padding(start =10.dp),
            text = "$"+currency.sell.toString(),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.End
        )

    }
}




