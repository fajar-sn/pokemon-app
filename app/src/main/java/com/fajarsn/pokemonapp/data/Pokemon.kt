package com.fajarsn.pokemonapp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pokemon(
    val types: List<String>,
    val weight: Int,
    val imageUrl: String,
    val stats: List<String>,
    val name: String,
    val id: Int,
    val height: Int,
) : Parcelable
