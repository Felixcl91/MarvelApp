package com.prueba.marvelapp.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Items(
    val resourceURI: String,
    val name: String,
    val type: String
): Parcelable
