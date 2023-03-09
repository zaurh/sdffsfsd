package com.example.myapplication.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LoremEntity(
    val body: String,
    @PrimaryKey val id: Int,
    val title: String,
    val userId: Int
)
