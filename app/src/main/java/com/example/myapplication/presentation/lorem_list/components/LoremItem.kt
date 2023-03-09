package com.example.myapplication.presentation.lorem_list.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.myapplication.data.mapper.toLoremEntity
import com.example.myapplication.domain.model.Lorem
import com.example.myapplication.presentation.fav_list.FavViewModel
import com.example.myapplication.presentation.lorem_list.LoremViewModel

@Composable
fun LoremItem(
    lorem: Lorem,
    navController: NavController,
    viewModel: LoremViewModel = hiltViewModel()
) {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp)){
        Column {
            Text(text = lorem.id.toString())
            Text(text = lorem.title)
            Button(onClick = {
                viewModel.insertFav(lorem.toLoremEntity())
            }) {
                Text(text = "Add to Fav")
            }

            Button(onClick = {
                viewModel.deleteFav(lorem.toLoremEntity())
            }) {
                Text(text = "Delete from Fav")
            }

            Button(onClick = {
                navController.navigate("fav")
            }) {
                Text(text = "My favs")
            }
        }
    }
}