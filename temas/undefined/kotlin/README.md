## Undefined en Kotlin

El código de ejemplo muestra cómo Kotlin maneja los nulls.

En Kotlin, cualquier variable o propiedad de un objeto puede ser nula o no nula. Por defecto, todas las variables y propiedades son no nulas y, por lo tanto, no pueden contener un valor nulo. Si deseas permitir que una variable o propiedad pueda ser nula, debes usar el operador `?` después del tipo de dato, lo que significa que el valor puede ser `null`.

Por ejemplo, en la definición de la clase `Computer`, la propiedad `ram` y `propietario` son opcionales y, por lo tanto, pueden ser nulas.

```kotlin

class Computer(val marca: String, val modelo: String, var ram: Int?, var propietario: String?)
```



En la creación de los objetos `miOrdenador` y `tuOrdenador`, se muestra cómo inicializar una propiedad que puede ser nula. En el caso de `tuOrdenador`, ambas propiedades son nulas.

```kotlin

val miOrdenador = Computer("Lenovo", "Ideapad 3", 3, "Lucía")
val tuOrdenador = Computer("HP", "Pavilion", null, null)
```

Cabe destacar 3 operadores para manejar valores nulos en Kotlin:

- El operador `?.`, también conocido como "operador de llamada segura", se utiliza para acceder a las propiedades y métodos de un objeto de manera segura, sin arriesgarse a lanzar una excepción `NullPointerException` en tiempo de ejecución si la variable u objeto es nulo.

- El operador `?:`, también conocido como "elvis operator", se utiliza para proporcionar un valor predeterminado o alternativo en caso de que la variable u objeto sea nulo.



- El operador `!!`, también conocido como "operador de llamada no nula" o "operador de afirmación no nula", se utiliza para indicar al compilador que una variable u objeto no es nulo y forzar su ejecución, incluso si es nulo.



A continuación, se muestran varios ejemplos de cómo se puede manejar la posibilidad de que una variable o propiedad sea nula utilizando los operadores `?.`, `?:` y `!!`. 

En la función `getRam(computer: Computer)`, se utiliza el operador `?.` para devolver el valor de la propiedad `ram` de `computer` si no es nula. Si la propiedad `ram` es nula, se devuelve el valor `0` en su lugar.

```kotlin

fun getRam(computer: Computer): Int {
    return computer.ram?.toInt() ?: 0
}
```



En la función `getPropietario(computer: Computer)`, se utiliza el operador `?.` para devolver el valor de la propiedad `propietario` en mayúsculas si no es nula. Si la propiedad `propietario` es nula, se devuelve `null`.

```kotlin

fun getPropietario(computer: Computer): String? {
    return computer.propietario?.uppercase()
}
```




En la función `getPropietarioNotNull(computer: Computer)`, se utiliza el operador `!!` para indicar que la propiedad `propietario` no es nula y forzar la ejecución del código, incluso si la propiedad es nula. Si la propiedad `propietario` es nula, se lanzará una excepción `NullPointerException`.

```kotlin

fun getPropietarioNotNull(computer: Computer): String {
    return computer.propietario!!.uppercase()
}
```

### Compilación y ejecución
```bash

kotlinc Undefined.kt -include-runtime -d Undefined.jar
java -jar Undefined.jar
```
O compilar online con https://play.kotlinlang.org/
