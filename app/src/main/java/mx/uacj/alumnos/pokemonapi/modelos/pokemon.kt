package mx.uacj.alumnos.pokemonapi.modelos

data class Pokemon(
    val id: Int,
    val name: String,
    val types: List<Tipos>,
    val base_experience: Int,
    val height: Int,
    val is_default: Boolean,
    val order: Int,
    val weight: Int,
    val abilities: List<Habilidad>,

    val sprite: Sprite,

    val cries: Aullido,

    val stats: List<EstadisticaBase>
)

/*
    "types": [
    {
        "slot": 1,
        "type": {
        "name": "fairy",
        "url": "https://pokeapi.co/api/v2/type/18/"
    }
    }*/
