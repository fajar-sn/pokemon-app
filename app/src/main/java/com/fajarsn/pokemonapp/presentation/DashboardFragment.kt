package com.fajarsn.pokemonapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.fajarsn.pokemonapp.data.Pokemon
import com.fajarsn.pokemonapp.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {
    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = binding.pokemonListRecyclerView
        recyclerView.setHasFixedSize(true)
        val pokemonList = mutableListOf<Pokemon>()

        for (i in 0..14) {
            val pokemon =
                Pokemon(
                    imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png",
                    name = "Dinosaurus",
                    id = 1
                )

            pokemonList.add(pokemon)
        }

        recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
        recyclerView.adapter = PokemonListAdapter(pokemonList)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}