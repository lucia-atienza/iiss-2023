# Herencia en Kotlin
En Kotlin, la herencia se logra mediante la declaración de una clase base y la creación de subclases que heredan de ella. La sintaxis para declarar una clase base es similar a la de Java:
``` kotlin
open class ClaseBase {
   // Propiedades y métodos de la clase base
}
```

Para crear una subclase que herede de `ClaseBase`, utilizamos la palabra clave `class` seguida del nombre de la subclase, seguida de `:` y el nombre de la clase base:
``` kotlin
class Subclase : ClaseBase() {
   // Propiedades y métodos de la subclase
}
```
En Kotlin, el polimorfismo de inclusión se logra mediante el uso de interfaces. Para declarar una interfaz en Kotlin, utilizamos la palabra clave `interface` seguida del nombre de la interfaz:
``` kotlin
interface Interfaz {
   // Propiedades y métodos de la interfaz
}
``` 
Y para implementar una interfaz en una clase:
``` kotlin
class Clase : Interfaz {
   // Propiedades y métodos de la clase
}
```
Cabe destacar que en versiones anteriores de Kotlin, se utilizaban los traits para definir comportamientos compartidos entre clases, pero en versiones más recientes, los traits han sido reemplazados por las interfaces.Las interfaces en Kotlin también pueden heredar de otras interfaces, lo que permite definir jerarquías de interfaces.

En el código de ejemplo se muestra la implementación de clases y funciones en Kotlin haciendo uso de herencia y polimorfismo de inclusión, utilizando para ello un mundo inspirado en Juego de Tronos. Hay una clase base llamada `Casa` que tiene tres subclases: `CasaNoble`, `CasaReal` y `CasaMenor`. Cada subclase tiene atributos adicionales (añadidos a los que ya tiene de la superclase) y métodos específicos que las distinguen de las demás.

En el método `main` se crean instancias de las diferentes casas y se agregan a una lista de tipo `Casa`. Luego, se itera sobre esta lista y se llama al método `conquistarTierras` de cada objeto, mostrando claramente el polimorfismo de inclusión antes mencionado, así como métodos específicos adicionales de las clases.


``` kotlin
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
``` 
Obteniendo el output:
``` 
Targaryen ha conquistado nuevas tierras. 
Targaryen ahora posee 1000 acres de tierra. 
Targaryen además de tener derecho a nombrar a sus propios vasallos
Stark ha conquistado nuevas tierras. 
Stark ahora posee 500 acres de tierra. 
Karstark ha conquistado nuevas tierras. 
Targaryen ha sentado a Stark en el Trono de Hierro
Karstark ha solicitado protección de Stark
Stark ha nombrado a Karstark como su vasallo
``` 
