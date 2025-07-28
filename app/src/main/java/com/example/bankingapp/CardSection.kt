package com.example.bankingapp

import android.R.attr.x
import android.util.Log.i
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankingapp.Data.Card
import com.example.bankingapp.ui.theme.BlueEnd
import com.example.bankingapp.ui.theme.BlueStart
import com.example.bankingapp.ui.theme.GreenEnd
import com.example.bankingapp.ui.theme.GreenStart
import com.example.bankingapp.ui.theme.OrangeEnd
import com.example.bankingapp.ui.theme.OrangeStart
import com.example.bankingapp.ui.theme.PurpleEnd
import com.example.bankingapp.ui.theme.PurpleStart
import java.nio.file.WatchEvent


val cards = listOf(

    Card(
        "VISA",
        "2334 3434 9575 7565",
        "Buisness",
        45.87,
        color =getGradient(PurpleStart, PurpleEnd)

    ),

    Card(
        "MASTER CARD",
        "7676 3434 9575 7565",
        "Saving",
        50.47,
        color =getGradient(BlueStart, BlueEnd)

    ),

    Card(
        "RuPay",
        "5656 5365 9575 7565",
        "College",
        5.86,
        color =getGradient(OrangeStart, OrangeEnd)

    ),

    Card(
        "VISA",
        "8458 3434 9575 7565",
        "Vacation",
        145.876,
        color =getGradient(GreenStart, GreenEnd)

    )
)


@Preview
@Composable
fun CardSection(){
    LazyRow{
        items(cards.size){index ->
            cardItem(index)
        }
    }
}


@Composable
fun cardItem(
    index : Int
){
    val card  = cards[index]
    var lastItemPadding = 0.dp
    if(index == cards.size - 1){
        lastItemPadding = 16.dp
    }

    var image = when(card.cardType){
        "MASTER CARD" -> painterResource(id = R.drawable.ic_mastercard)
        "VISA" -> painterResource(id = R.drawable.ic_visa)
        else -> { painterResource(id = R.drawable.ig_rupay )}
    }

    Box(modifier = Modifier.
    padding(start = 16.dp, end = lastItemPadding)
    ){
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.color)
                .width(250.dp)
                .height(160.dp)
                .clickable{}
                .padding(vertical = 12.dp , horizontal = 16.dp),
                Arrangement.SpaceBetween
        ){
            Image(painter = image ,
                card.cardName,
                Modifier.width(if (card.cardType == "RuPay") 95.dp else 60.dp)
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(text = card.cardName,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(text =  "$" + card.balance.toString(),
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Text(text = card.cardNumber,
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )




        }
    }


}























fun getGradient(startColor: Color,endColor: Color): Brush{

    return Brush.horizontalGradient(
        colors = listOf(startColor,endColor)
    )
}

