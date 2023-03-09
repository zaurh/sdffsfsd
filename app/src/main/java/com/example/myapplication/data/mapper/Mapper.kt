package com.example.myapplication.data.mapper

import com.example.myapplication.data.remote.dto.LoremDTO
import com.example.myapplication.domain.model.Lorem
import com.example.myapplication.domain.model.LoremEntity

fun Lorem.toLoremEntity() = LoremEntity(body, id, title, userId)

fun LoremEntity.toLorem() = Lorem(body, id, title, userId)

fun LoremDTO.toLoremEntity() = LoremEntity(body, id, title, userId)
fun LoremDTO.toLorem() = Lorem(body, id, title, userId)