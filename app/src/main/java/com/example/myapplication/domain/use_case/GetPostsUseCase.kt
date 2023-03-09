package com.example.myapplication.domain.use_case

import com.example.myapplication.common.Resource
import com.example.myapplication.domain.model.Lorem
import com.example.myapplication.domain.repository.Repository
import kotlinx.coroutines.flow.Flow

import javax.inject.Inject

class GetPostsUseCase @Inject constructor(
    private val repository: Repository
) {

    operator fun invoke() : Flow<Resource<List<Lorem>>> {
        return repository.getPosts()
    }
}