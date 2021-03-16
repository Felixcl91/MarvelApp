package com.prueba.marvelapp.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Character(
    val id: Int,
    val name: String,
    val description: String,
    val modified: String,
    val thumbnail: Thumbnail,
    val resourceURI: String,
    val comics: Comics,
    val series: Series,
    val stories: Stories,
    val events: Events,
    val urls: ArrayList<Urls>
): Parcelable, Comparable<Character> {
    override fun compareTo(o: Character): Int {
        val a: String = name
        val b: String = name
        return a.compareTo(b)
    }
}