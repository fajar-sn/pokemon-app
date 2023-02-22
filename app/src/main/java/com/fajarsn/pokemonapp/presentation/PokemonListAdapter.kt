package com.fajarsn.pokemonapp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fajarsn.pokemonapp.data.Pokemon
import com.fajarsn.pokemonapp.databinding.ItemPokemonBinding

class PokemonListAdapter(private val pokemonList: List<Pokemon>) : RecyclerView.Adapter<PokemonListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = pokemonList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pokemon = pokemonList[position]
        holder.binding.idListTextView.text = "${pokemon.id}"
        holder.binding.nameListTextView.text = pokemon.name

        Glide.with(holder.itemView.context)
            .load(pokemon.imageUrl)
            .into(holder.binding.pokemonListImageView)
    }

    class ViewHolder(val binding: ItemPokemonBinding) : RecyclerView.ViewHolder(binding.root)
}