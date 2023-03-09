package com.example.myapplication.presentation.fav_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.use_case.local.FavUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavViewModel @Inject constructor(
    private val favUseCases: FavUseCases
): ViewModel() {

    private val _state = mutableStateOf(FavState())
        val state: State<FavState> = _state

    init {
        getAllLorems()
    }

    private fun getAllLorems(){
        viewModelScope.launch {
            favUseCases.getFavsUseCase().collect{ result ->
                _state.value = state.value.copy(
                    favList = result
                )
            }
        }
    }
}