package mx.uacj.alumnos.pokemonapi.viewmodels

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import mx.uacj.alumnos.pokemonapi.modelos.Pokemon
import mx.uacj.alumnos.pokemonapi.repositorio_api.RepositorioPokemones
import mx.uacj.alumnos.pokemonapi.repositorio_api.api_conexion.InterfazPokemonAPI
import javax.inject.Inject

@HiltViewModel
class PokemonesViewModel @Inject constructor(
    private val repositorio: RepositorioPokemones,
    private val conexion_server: InterfazPokemonAPI
): ViewModel(){
    private val estado = mutableStateOf("cargando")
    val pokemones : State<List<Pokemon>> = repositorio.pokemones

    init {
        for(indice_pokemon in 1..100){
            descargar_pokemon(indice_pokemon)
        }

        Log.v("Lista Pokemones", "La cantidad de elementos es ${repositorio.pokemones.value.size}")
    }

    fun descargar_pokemon(id: Int){
        var pokemon: Pokemon? = null

        viewModelScope.launch{
            pokemon = conexion_server.descargar_pokemon(id)
            //pokemon_cache = mutableStateOf(pokemon_descargado)
            val lista = repositorio.pokemones.value.toMutableStateList()

            if(pokemon != null){
                lista.add(pokemon!!)
            }
            repositorio.pokemones.value = lista
        }
    }
}