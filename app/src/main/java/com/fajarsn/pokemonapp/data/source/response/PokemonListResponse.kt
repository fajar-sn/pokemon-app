package com.fajarsn.pokemonapp.data.source.response

import com.google.gson.annotations.SerializedName

data class PokemonListResponse(

	@field:SerializedName("results")
	val results: List<PokemonResultsItem>
)

data class PokemonResultsItem(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)
