package ru.com.vbulat.firstcomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    Box (
        modifier = Modifier
            .size(200.dp)
            .background(Color.Cyan),
    ){
        Image(
            modifier = Modifier
                .background(Color.Green)
                .padding(25.dp)
                .size(100.dp)
                .background(Color.Red)
            ,
            painter = ColorPainter(Color.Yellow),
            contentDescription = "",
            contentScale = ContentScale.FillHeight
        )
    }

}
