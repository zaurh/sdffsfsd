package com.example.myapplication.presentation.fav_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.myapplication.presentation.lorem_list.components.LoremItem

@Composable
fun FavView(
    viewModel: FavViewModel = hiltViewModel(),
    navController: NavController
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()){
        Column(Modifier.fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally) {
            if (state.favList.isNotEmpty()){
                LazyColumn{
                    items(state.favList){ fav ->
                        LoremItem(lorem = fav, navController = navController)
                    }
                }
            }
            else{
                Text(text = "Fav boshdur", fontSize = 25.sp)
            }
        }

        

    }
}