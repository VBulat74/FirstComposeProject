package ru.com.vbulat.firstcomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UserInfo(name = "Jon", age = "25")
        }
    }
}

@Composable
fun UserInfo(name: String, age:String){
    Column {
        for (i in 0..10)
            Text(text = "Hello $name! You are $age years old!")
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
)
@Composable
fun UserInfoPreview() {
    UserInfo(name = "Jon", age = "25")
}

