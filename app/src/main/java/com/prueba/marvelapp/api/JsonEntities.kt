package com.prueba.marvelapp.api

import com.prueba.marvelapp.models.Character

data class Response(
    val copyright: String,
    val attributionText: String,
    val data: Data
)

data class Data(
    val results: ArrayList<Character>
)