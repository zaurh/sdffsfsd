package com.example.myapplication.presentation.lorem_list.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.myapplication.presentation.lorem_list.LoremViewModel

@Composable
fun LoremView(
    navController: NavController,
    loremViewModel: LoremViewModel = hiltViewModel()
) {
    val state = loremViewModel.state.value

    Box(modifier = Modifier.fillMaxSize()){
        LazyColumn{
            items(state.loremList){ lorem ->
                LoremItem(lorem = lorem,navController)
            }
        }
    }
}