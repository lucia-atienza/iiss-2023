import java.util.*

data class Scout(val name: String, val age: Int)

fun main() {
    val scouts = listOf(
        Scout("Lucia", 12),
        Scout("Antonio", 14),
        Scout("Pepe", 13),
        Scout("Sofia", 15),
        Scout("Miguel", 11)
    )

    // filtrar los scouts que tienen más de 12 años
    val olderScouts = scouts.filter { it.age > 12 }
    println("Scouts mayores de 12 años: $olderScouts")

    // obtener los nombres de los scouts en mayúsculas
    val scoutNames = scouts.map { it.name.uppercase(Locale.getDefault()) }
    println("Nombres de scouts en mayúsculas: $scoutNames")

    // calcular el promedio de edad de los scouts
    val averageAge = scouts.map { it.age }.average()
    println("Promedio de edad de los scouts: $averageAge")

    // verificar si hay algún scout con edad igual a 11 años
    val hasElevenYearOld = scouts.any { it.age == 11 }
    println("¿Hay algún scout de 11 años? $hasElevenYearOld")

    // contar la cantidad de scouts que tienen nombres con más de 4 caracteres
    val countScoutsWithLongNames = scouts.count { it.name.length > 4 }
    println("Cantidad de scouts con nombres con mas de 4 caracteres: $countScoutsWithLongNames")

    // ordenar los scouts por edad de forma descendente
    val sortedScouts = scouts.sortedByDescending { it.age }
    println("Scouts ordenados por edad descendente: $sortedScouts")


    val scoutSkills = mapOf(
        "Lucia" to "Acampar",
        "Antonio" to "Orientación",
        "Pepe" to "Nudos",
        "Sofia" to "Primeros auxilios",
        "Miguel" to "Senderismo"
    )
    scoutSkills.forEach { (_, value) -> println("$value!") }

    val sum = scouts.filter { it.age > 0 }.sumOf { it.age }
    println("Suma de las edades de los scouts mayores a 0: $sum")
}
