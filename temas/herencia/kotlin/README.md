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

