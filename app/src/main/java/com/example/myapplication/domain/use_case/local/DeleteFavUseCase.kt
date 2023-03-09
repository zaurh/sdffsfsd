package com.example.myapplication.domain.use_case.local

import com.example.myapplication.domain.model.LoremEntity
import com.example.myapplication.domain.repository.FavRepository
import javax.inject.Inject

class DeleteFavUseCase @Inject constructor(
    private val favRepository: FavRepository
) {

    suspend operator fun invoke(loremEntity: LoremEntity){
        favRepository.Delete(loremEntity)
    }
}