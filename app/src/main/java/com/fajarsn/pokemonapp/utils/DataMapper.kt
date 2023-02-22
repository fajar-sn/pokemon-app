package com.fajarsn.pokemonapp.utils

import com.fajarsn.pokemonapp.data.Pokemon
import com.fajarsn.pokemonapp.data.PokemonResponse

object DataMapper {
    fun mapEntitiesToDomain(input: List<PokemonResponse>) = input.map { response ->
        Pokemon(
            types = response.types.map { typesItem -> typesItem.type.name },
            weight = response.weight,
            imageUrl = response.sprites.other.officialArtwork.frontDefault,
            stats = response.stats.map { statsItem -> "${statsItem.baseStat}" },
            name = response.name,
            id = response.id,
            height = response.height
        )
    }
}