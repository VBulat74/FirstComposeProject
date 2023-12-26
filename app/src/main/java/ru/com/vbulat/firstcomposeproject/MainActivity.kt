package ru.com.vbulat.firstcomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import ru.com.vbulat.firstcomposeproject.ui.theme.FirstComposeProjectTheme
import ru.com.vbulat.firstcomposeproject.ui.theme.InstagramProfileCard

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstComposeProjectTheme() {
                Box (
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = MaterialTheme.colorScheme.background),
                ) {
                    InstagramProfileCard()
                }
            }
        }
    }
}

@Preview
@Composable
fun TestText(){
    Text(
        text = "Hello world!",
        fontSize = 24.sp,
        fontWeight = FontWeight.ExtraBold,
        fontFamily = FontFamily.Serif,
        textDecoration = TextDecoration.Underline
    )
}
