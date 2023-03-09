package com.example.myapplication.domain.repository

import com.example.myapplication.common.Resource
import com.example.myapplication.domain.model.Lorem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface Repository {

    fun getPosts(): Flow<Resource<List<Lorem>>>
}