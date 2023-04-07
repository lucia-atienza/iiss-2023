@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class Requerido

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class Rango(val min: Int, val max: Int)

data class Formulario(
    @Requerido
    val nombre: String,

    @Requerido
    @Rango(min = 18, max = 120)
    val edad: Int,

    @Requerido
    val email: String,

    val dni: String
)
fun validar(formulario: Formulario): List<String> {
    val errores = mutableListOf<String>()
    val fields = formulario::class.java.declaredFields
    for (field in fields) {
        field.isAccessible = true // permitir acceso a campos privados
        val value = field.get(formulario)
        if (field.isAnnotationPresent(Requerido::class.java) && (value == null || value == "")) {
            errores.add("${field.name} es un campo requerido")
        }
        if (field.isAnnotationPresent(Rango::class.java) && value is Int) {
            val rango = field.getAnnotation(Rango::class.java)
            if ((value < rango.min) || (value > rango.max)) {
                errores.add("${field.name} debe estar entre ${rango.min} y ${rango.max}")
            }
        }
    }
    return errores
}

fun main() {
    var formulario = Formulario(nombre = "Lucía", edad = 23, email = "lucia.atienzaolmo@alum.uca.es", dni = "")
    val errores = validar(formulario)
    if (errores.isNotEmpty()) {
        for (error in errores) {
            println(error)
        }
    } else {
        println("Formulario validado correctamente")
    }
    /*
    val formulario2 = Formulario(nombre = "", edad = 130, email = "lucia@gmail.com", dni = "12345678Z")
    val errores2 = validar(formulario2)
    if (errores2.isNotEmpty()) {
        for (error in errores2) {
            println(error)
        }
    } else {
        println("Formulario validado correctamente")
    }
    */
}
