package com.example.myapplication.domain.repository

import androidx.room.Delete
import com.example.myapplication.domain.model.Lorem
import com.example.myapplication.domain.model.LoremEntity
import kotlinx.coroutines.flow.Flow

interface FavRepository {

    fun getAllLorem(): Flow<List<Lorem>>
    suspend fun Insert(loremEntity: LoremEntity)
    suspend fun Delete(loremEntity: LoremEntity)
}