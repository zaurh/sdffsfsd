package com.example.myapplication.presentation.lorem_list

import com.example.myapplication.domain.model.Lorem

data class LoremState(
    val loremList: List<Lorem> = emptyList(),
    val error: String = "",
    val isLoading: Boolean = false
)
