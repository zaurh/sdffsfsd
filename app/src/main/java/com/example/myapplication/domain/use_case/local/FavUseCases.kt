package com.example.myapplication.domain.use_case.local

data class FavUseCases(
    val getFavsUseCase: GetFavsUseCase,
    val insertFavUseCase: InsertFavUseCase,
    val deleteFavUseCase: DeleteFavUseCase
)
