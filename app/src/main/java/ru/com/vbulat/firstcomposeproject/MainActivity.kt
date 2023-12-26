package ru.com.vbulat.firstcomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
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
