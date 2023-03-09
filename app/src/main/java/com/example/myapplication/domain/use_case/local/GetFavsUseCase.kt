package com.example.myapplication.domain.use_case.local

import com.example.myapplication.domain.model.Lorem
import com.example.myapplication.domain.repository.FavRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavsUseCase @Inject constructor(
    private val favRepository: FavRepository
) {

    operator fun invoke(): Flow<List<Lorem>>{
        return favRepository.getAllLorem()
    }
}