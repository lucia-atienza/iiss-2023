interface Casa {
    val lema: String
    fun presentarse()
}

class Stark(override val lema: String = "Se acerca el invierno") : Casa {
    override fun presentarse() {
        println("Soy de la casa Stark, nuestro lema es: $lema")
    }
}

class Lannister(override val lema: String = "Oye mi rugido") : Casa {
    override fun presentarse() {
        println("Soy de la casa Lannister, nuestro lema es: $lema")
    }
}

class Targaryen(override val lema: String = "Fuego y sangre") : Casa {
    override fun presentarse() {
        println("Soy de la casa Targaryen, nuestro lema es: $lema")
    }
}

class Personaje(val nombre: String, casa: Casa) : Casa by casa, Comparable<Personaje> {
    override fun compareTo(other: Personaje): Int {
        return nombre.compareTo(other.nombre)
    }

    fun presentarseConNombre() {
        println("Soy $nombre de la casa ${javaClass.simpleName}, nuestro lema es: $lema")
    }
}

fun main() {
    val stark = Stark()
    val lannister = Lannister()
    val targaryen = Targaryen()

    val arya = Personaje("Arya Stark", stark)
    val jaime = Personaje("Jaime Lannister", lannister)
    val daenerys = Personaje("Daenerys Targaryen", targaryen)

    val personajes = listOf(arya, jaime, daenerys)
    personajes.sorted().forEach { it.presentarseConNombre() }
}
