package com.prueba.marvelapp.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Series(
    val available: Int,
    val collectionURI: String,
    val items: ArrayList<Items>,
    val returned: Int
): Parcelable
