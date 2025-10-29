package mx.uacj.alumnos.pokemonapi.ui.pantallas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mx.uacj.alumnos.pokemonapi.modelos.Pokemon

@Composable
fun PantallaPokemon(modificador: Modifier = Modifier, pokemon: Pokemon){
    Column (modifier = modificador){
        Text("Nombre: ${pokemon.name}")
        //Text("Estadisticas: ${pokemon.stats}")
        for(tipos in pokemon.types){
            Text("Tipo: ${tipos.type.name}")
        }

        for(estadistica in pokemon.stats){
            //Text("Estadistica: ${estadistica}", modifier = Modifier.padding(5.dp))
            Row {
                Text("${estadistica.stat.name}")
                //Spacer(Modifier.weight(0.8f))
                Text("Base: ${estadistica.base_stat}")
                Text("Esfuerzo: ${estadistica.effort}")
            }

        }
    }
}

@Preview
@Composable
fun previsualizacion_PantallaPokemon(){
    //PantallaPokemon()
}