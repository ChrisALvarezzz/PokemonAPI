package mx.uacj.alumnos.pokemonapi.ui.controladores

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import mx.uacj.alumnos.pokemonapi.ui.pantallas.PantallaPokemon
import mx.uacj.alumnos.pokemonapi.ui.pantallas.PantallaPrincipal

data class OpcionesMenu(
    val titulo: String,
    val icono: String,
    val ruta: String
)

@Composable
fun OpcionesMenuInferior(
    opciones: List<OpcionesMenu>,
    ruta_actual: String,
    al_pushopicar: () -> Unit
){
    BottomAppBar {
        Row(horizontalArrangement = Arrangement.SpaceAround){
            for(opcion in opciones){
                Text("${opcion.titulo}", modifier = Modifier.clickable {
                    Log.v("NavegacionInferior", "${opcion.titulo}")
                })
            }
        }
        
    }
}

@Composable
fun MenuPrincipal(){
    val lista_opciones_menu by remember {   mutableStateOf(
        mutableStateListOf(
            OpcionesMenu("Pokemones", "icono", "PantallaPokemon"),
            OpcionesMenu("Ubicaciones", "icono", "PantallaPokemon"),
            OpcionesMenu("Maquinas", "icono", "PantallaPokemon")
    ))}

    Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = {
                OpcionesMenuInferior(
                    lista_opciones_menu,
                    ruta_actual = "TODO",
                ) { }
                Text("Pulsar")
            }
        ) { innerPadding ->
        PantallaPrincipal(modificador = Modifier.padding(innerPadding))
    }
}
