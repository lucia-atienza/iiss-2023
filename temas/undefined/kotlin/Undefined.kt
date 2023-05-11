// compilar online con: https://play.kotlinlang.org/
class Computer(val marca: String, val modelo: String, var ram: Int?, var propietario: String?)

fun main() {
    val miOrdenador = Computer("Lenovo", "Ideapad 3", 3, "Lucía")
    val tuOrdenador = Computer("HP", "Pavilion", null, null)
    println("Marca: ${tuOrdenador.marca}, Modelo: ${tuOrdenador.modelo}, RAM: ${tuOrdenador.ram}, Propietario: ${tuOrdenador.propietario}")
    println("Marca: ${miOrdenador.marca}, Modelo: ${miOrdenador.modelo}, RAM: ${miOrdenador.ram}, Propietario: ${miOrdenador.propietario}")

    // usando el operador ?. y el Elvis operator ?: dentro de la función getPrecio, podemos evitar lanzar un NPE y devolver un valor distinto a null
    fun getRam(computer: Computer): Int {
        return computer.ram?.toInt() ?: 0
    }
    println("Precio: ${getRam(tuOrdenador)}")

    // usando solo el operador ?, podemos evitar lanzar un NPE, pero podemos devolver null si la propiedad propietario es null
    fun getPropietario(computer: Computer): String? {
        return computer.propietario?.uppercase()
    }
    println("Propietario: ${getPropietario(tuOrdenador)}")

    // usando el operador !!, podemos lanzar un NPE en caso de que la propiedad propietario sea null
    fun getPropietarioNotNull(computer: Computer): String {
        return computer.propietario!!.uppercase()
    }
    //println("Propietario: ${getPropietarioNotNull(tuOrdenador)}") // si descomentamos esta línea, se lanzará un NPE ya que propietario es null

    // aquí no hay problema
    println("Propietario: ${getPropietarioNotNull(miOrdenador)}") 

}
