package com.example.myapplication.presentation.lorem_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.common.Resource
import com.example.myapplication.domain.model.Lorem
import com.example.myapplication.domain.model.LoremEntity
import com.example.myapplication.domain.use_case.GetPostsUseCase
import com.example.myapplication.domain.use_case.local.FavUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoremViewModel @Inject constructor(
    private val getPostsUseCase: GetPostsUseCase,
    private val favUseCases: FavUseCases
): ViewModel() {

    private val _state = mutableStateOf(LoremState())
        val state: State<LoremState> = _state

    init {
        getPosts()
    }

    fun getPosts(){
        getPostsUseCase().onEach { result ->
            when(result){
                is Resource.Success -> {
                    _state.value = state.value.copy(
                        loremList = result.data?: emptyList()
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

    fun insertFav(loremEntity: LoremEntity){
        viewModelScope.launch {
            favUseCases.insertFavUseCase(loremEntity)
        }
    }

    fun deleteFav(loremEntity: LoremEntity){
        viewModelScope.launch {
            favUseCases.deleteFavUseCase(loremEntity)
        }
    }
}