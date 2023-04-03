package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}

@Composable
fun LemonadeApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        var step by remember {
            mutableStateOf(1)
        }
        var random = (1..5).random()

        val imageResource = when (step) {
            1 -> R.drawable.lemon_tree
            3 -> R.drawable.lemon_drink
            4 -> R.drawable.lemon_restart
            else -> R.drawable.lemon_squeeze
        }
        val stringResource = when (step) {
            1 -> R.string.select_lemon
            3 -> R.string.drink_lemonade
            4 -> R.string.start_again
            else -> R.string.squeeze_lemon
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {

            Text(
                text = stringResource(stringResource),
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = stringResource(R.string.lemon_tree),
                modifier = Modifier
                    .border(
                        2.dp,
                        Color(105, 205, 216),
                        RoundedCornerShape(5.dp)
                    )
                    .clickable {
                        when (step) {
                            1, 3 -> {
                                step++
                            }
                            2 -> {
                                println(random)
                                random--
                                println(random)
                                if (random == 0) {
                                    step++
                                }

                            }
                            else -> {
                                step = 1
                            }
                        }


                    }
            )

        }

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        LemonadeApp()
    }
}