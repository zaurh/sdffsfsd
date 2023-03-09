package com.example.myapplication.domain.use_case.local

import androidx.room.Insert
import com.example.myapplication.domain.model.LoremEntity
import com.example.myapplication.domain.repository.FavRepository
import javax.inject.Inject

class InsertFavUseCase @Inject constructor(
    private val favRepository: FavRepository
) {

    suspend operator fun invoke(loremEntity: LoremEntity){
        favRepository.Insert(loremEntity)
    }
}