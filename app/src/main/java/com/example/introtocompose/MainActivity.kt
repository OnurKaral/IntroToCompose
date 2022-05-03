package com.example.introtocompose

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.introtocompose.ui.theme.IntroToComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntroToComposeTheme {
                // A surface container using the 'background' color from the theme

                MyApp()
            }
        }
    }
}

@Composable
fun MyApp(){
    var money = remember {
        mutableStateOf(0)
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF546E7A)){

        Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally ) {
                Text(text = "$${money.value}",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.ExtraBold
                )
                )
            Spacer(modifier = Modifier.height(10.dp))
                CreateCircle(money = money.value ){ newMoney ->
                        money.value = newMoney
                }

        }
    }
}


@Composable
fun CreateCircle(money: Int, updateMoney: (Int) -> Unit){

    Card(
        modifier = Modifier
            .padding(3.dp)
            .size(145.dp)
            .clickable {
                       updateMoney(money+1)
            },
            shape = CircleShape,
            elevation = 4.dp,
    ){

        Box(contentAlignment = Alignment.Center){
            Text(text = "Tap $money", modifier = Modifier)

            
        }

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    IntroToComposeTheme {
            MyApp()

    }
}