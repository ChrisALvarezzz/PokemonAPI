package mx.uacj.alumnos.pokemonapi.repositorio_api

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import mx.uacj.alumnos.pokemonapi.modelos.Pokemon
import java.util.Collections.emptyList

class AlmacenDatosPokemon(
    override val pokemones: MutableState<List<Pokemon>> = mutableStateOf(emptyList<Pokemon>())
) : RepositorioPokemones{}

interface RepositorioPokemones{
    val pokemones: MutableState<List<Pokemon>>
}