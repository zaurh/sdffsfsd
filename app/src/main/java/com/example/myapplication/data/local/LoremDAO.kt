package com.example.myapplication.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.domain.model.LoremEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface LoremDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun Insert(loremEntity: LoremEntity)

    @Delete
    suspend fun Delete(loremEntity: LoremEntity)

    @Query("select * from lorementity")
    fun getAllLorem(): Flow<List<LoremEntity>>
}