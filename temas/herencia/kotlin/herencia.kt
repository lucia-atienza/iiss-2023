open class Casa(val nombre: String, val lema: String, val miembros: Int) {
    open fun conquistarTierras() {
        println("$nombre ha conquistado nuevas tierras. ")
    }
}

open class CasaNoble(nombre: String, lema: String, miembros: Int, val tierras: Int, var vasallos: Int) : Casa(nombre, lema, miembros) {
    override fun conquistarTierras() {
        super.conquistarTierras()
        println("$nombre ahora posee $tierras acres de tierra. ")
    }
    
    fun nombrarVasallo(casaMenor: CasaMenor) {
        if (vasallos > 0) {
            println("$nombre ha nombrado a ${casaMenor.nombre} como su vasallo")
            vasallos--
        } else {
            println("$nombre no tiene suficientes vasallos para nombrar a ${casaMenor.nombre}")
        }
    }
}

class CasaReal(nombre: String, lema: String, miembros: Int, tierras: Int, vasallos: Int, val tronoDeHierro: Boolean) : CasaNoble(nombre, lema, miembros, tierras, vasallos) {
    override fun conquistarTierras() {
        super.conquistarTierras()
        println("$nombre además de tener derecho a nombrar a sus propios vasallos")
    }
    
    fun sentarEnElTrono(casaNoble: CasaNoble) {
        if (tronoDeHierro) {
            println("$nombre ha sentado a ${casaNoble.nombre} en el Trono de Hierro")
        } else {
            println("$nombre no tiene derecho a sentar a ${casaNoble.nombre} en el Trono de Hierro")
        }
    }
}

class CasaMenor(nombre: String, lema: String, miembros: Int, val proteccionNoble: CasaNoble) : Casa(nombre, lema, miembros) {
    fun solicitarProteccion() {
        println("$nombre ha solicitado protección de ${proteccionNoble.nombre}")
        proteccionNoble.nombrarVasallo(this)
    }
}

fun main() {
    
    val casaTargaryen = CasaReal("Targaryen", "Fuego y sangre", 3, 1000, 10, true)
    val casaStark = CasaNoble("Stark", "Se acerca el invierno", 5, 500, 5)
    val casaKarstark = CasaMenor("Karstark", "El sol de invierno", 2, casaStark)
    
    val casas: MutableList<Casa> = mutableListOf(casaTargaryen, casaStark,casaKarstark)
    for (casa in casas) {
        casa.conquistarTierras()
    }

    casaTargaryen.sentarEnElTrono(casaStark)
    casaKarstark.solicitarProteccion()
}

