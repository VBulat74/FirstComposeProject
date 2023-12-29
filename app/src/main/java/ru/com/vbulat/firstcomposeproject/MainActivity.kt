package ru.com.vbulat.firstcomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DismissDirection
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SwipeToDismiss
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import ru.com.vbulat.firstcomposeproject.ui.theme.FirstComposeProjectTheme
import ru.com.vbulat.firstcomposeproject.ui.theme.InstagramProfileCard

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        setContent {
            Test(viewModel = viewModel)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Test(viewModel: MainViewModel){
    FirstComposeProjectTheme() {
        Box (
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.background),
        ) {
            val models = viewModel.models.observeAsState(listOf())

            LazyColumn(
                    
            ) {
                items(
                    models.value,
                    key = { it.id }
                    ){model->

                    val dismissState = rememberDismissState()

                    if (dismissState.isDismissed(DismissDirection.EndToStart)) {
                        viewModel.delete(model)
                    }

                    SwipeToDismiss(
                        state = dismissState,
                        background = {
                            Box (
                                modifier = Modifier
                                    .padding(16.dp)
                                    .fillMaxSize()
                                    .background(Color.Red.copy(alpha = 0.5f)),
                                contentAlignment = Alignment.CenterEnd,
                            ){
                                Text(
                                    modifier = Modifier.padding(16.dp),
                                    text = "Delete Item",
                                    color = Color.White,
                                    fontSize = 24.sp
                                )
                            }
                        },
                        directions = setOf(DismissDirection.EndToStart),
                        dismissContent = {
                            InstagramProfileCard(
                                model = model,
                                onFollowedButtonClickListener = {
                                    viewModel.changeFollowingStatus(it)
                                }
                            )
                        },
                    )
                }
            }
        }
    }
}