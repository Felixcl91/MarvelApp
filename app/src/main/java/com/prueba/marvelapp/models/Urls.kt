package com.prueba.marvelapp.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Urls(
    val type: String,
    val url: String
): Parcelable
