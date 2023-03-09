package com.example.myapplication.data.repository

import com.example.myapplication.data.local.LoremDAO
import com.example.myapplication.data.mapper.toLorem
import com.example.myapplication.domain.model.Lorem
import com.example.myapplication.domain.model.LoremEntity
import com.example.myapplication.domain.repository.FavRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FavRepositoryImpl @Inject constructor(
    private val dao: LoremDAO
): FavRepository {

    override fun getAllLorem(): Flow<List<Lorem>> = flow{
        dao.getAllLorem().collect{ fav ->
            emit(fav.map { it.toLorem() })
        }
    }

    override suspend fun Insert(loremEntity: LoremEntity) {
        dao.Insert(loremEntity)
    }

    override suspend fun Delete(loremEntity: LoremEntity) {
        dao.Delete(loremEntity)
    }
}