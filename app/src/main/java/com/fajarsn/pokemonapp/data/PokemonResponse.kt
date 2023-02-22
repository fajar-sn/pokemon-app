package com.fajarsn.pokemonapp.data

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

// region pokemon response
@Parcelize
data class PokemonResponse(
	@field:SerializedName("types")
	val types: List<TypesItem>,

	@field:SerializedName("weight")
	val weight: Int,

	@field:SerializedName("sprites")
	val sprites: Sprites,

	@field:SerializedName("stats")
	val stats: List<StatsItem>,

	@field:SerializedName("moves")
	val moves: List<MovesItem>,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("height")
	val height: Int,
) : Parcelable
// endregion

// region pokemon type
@Parcelize
data class TypesItem(

	@field:SerializedName("slot")
	val slot: Int,

	@field:SerializedName("type")
	val type: Type
) : Parcelable

@Parcelize
data class Type(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
) : Parcelable
// endregion

// region pokemon image
@Parcelize
data class Sprites(
	@field:SerializedName("other")
	val other: Other,
) : Parcelable

@Parcelize
data class Other(
	@field:SerializedName("official-artwork")
	val officialArtwork: OfficialArtwork,
) : Parcelable

@Parcelize
data class OfficialArtwork(

	@field:SerializedName("front_default")
	val frontDefault: String,

	@field:SerializedName("front_shiny")
	val frontShiny: String
) : Parcelable
// endregion

// region pokemon stats
@Parcelize
data class StatsItem(

	@field:SerializedName("stat")
	val stat: Stat,

	@field:SerializedName("base_stat")
	val baseStat: Int,

	@field:SerializedName("effort")
	val effort: Int
) : Parcelable

@Parcelize
data class Stat(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
) : Parcelable
// endregion

// region pokemon moves
@Parcelize
data class MovesItem(
	@field:SerializedName("move")
	val move: Move
) : Parcelable

@Parcelize
data class Move(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
) : Parcelable
// endregion
