package com.example.myapplication.data.repository

import com.example.myapplication.common.Resource
import com.example.myapplication.data.mapper.toLorem
import com.example.myapplication.data.remote.LoremApi
import com.example.myapplication.domain.model.Lorem
import com.example.myapplication.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val api: LoremApi
):Repository {

    override fun getPosts(): Flow<Resource<List<Lorem>>> = flow{
        try {
           emit(Resource.Loading())
           val remoteData = api.getPosts().map { it.toLorem() }
           emit(Resource.Success(remoteData))
        }
        catch (e: Exception){
            emit(Resource.Error(e.message.toString()))
        }
    }
}