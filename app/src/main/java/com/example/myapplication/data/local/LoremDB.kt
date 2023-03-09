package com.example.myapplication.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.domain.model.LoremEntity

@Database(
    entities = [LoremEntity::class],
    version = 1)
abstract class LoremDB: RoomDatabase() {
    abstract fun loremDao(): LoremDAO

}