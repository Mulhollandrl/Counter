package com.mulholland.stitchcounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mulholland.stitchcounter.ui.theme.AccentDark
import com.mulholland.stitchcounter.ui.theme.PrimaryLight
import com.mulholland.stitchcounter.ui.theme.StitchCounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StitchCounterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    Title()
                    Counter()
                }
            }
        }
    }
}

@Composable
fun Title() {
    Text(
        text = "Counter",
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(vertical = 36.dp),
        style = TextStyle(
            fontSize = 64.sp,
            shadow = Shadow(AccentDark, Offset(5.0f, 10.0f), 3f)
        )
    )
}

@Composable
fun Counter() {
    var currentCount by remember {
        mutableStateOf(0)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "$currentCount",
            fontSize = 48.sp,
            color = Color.White
        )
        
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { if (currentCount > 0) {currentCount--} },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = AccentDark
                )
            ) {
                Text(text = "-")
            }
            Button(
                onClick = { currentCount = 0 },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = AccentDark
                )
            ) {
                Text(text = "RESET")
            }
            Button(
                onClick = { currentCount++ },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = AccentDark
                )
            ) {
                Text(text = "+")
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF855C26)
@Composable
fun TitlePreview() {
    StitchCounterTheme {
        Title()
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF855C26)
@Composable
fun CounterPreview() {
    StitchCounterTheme {
        Counter()
    }
}