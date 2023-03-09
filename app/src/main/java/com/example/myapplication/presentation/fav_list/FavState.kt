package com.example.myapplication.presentation.fav_list

import com.example.myapplication.domain.model.Lorem
import com.example.myapplication.domain.model.LoremEntity

data class FavState(
    val favList: List<Lorem> = emptyList()
)
