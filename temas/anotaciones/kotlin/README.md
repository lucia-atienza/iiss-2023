## Anotaciones en Kotlin
Las anotaciones son medios para adjuntar metadatos al código. Para declarar una anotación, es necesario poner el modificador `annotation` delante de una clase:
``` kotlin
annotation class NombreAnotacion
```
Además, pueden especificarse atributos adicionales anotando la clase de anotación con meta-anotaciones. 

Un ejemplo sencillo para entender cómo funcionan las anotaciones en Kotlin es su uso en la documentación de código. Las anotaciones de documentación son aquellas que se utilizan para proporcionar información adicional sobre el código, como su propósito, uso, autor y más. Estas anotaciones se pueden utilizar para generar documentación automática, como javadoc en Java o dokka en Kotlin.

``` kotlin
/**
 * Esta función imprime un mensaje [n] veces.
 * @param mensaje El mensaje a imprimir.
 * @param n El número de veces que se debe imprimir el mensaje.
 */
fun imprimirMensaje(mensaje: String, n: Int) {
    for (i in 1..n) {
        println(mensaje)
    }
}
```


Otro ejemplo de uso sería, por ejemplo, usar anotaciones en Kotlin para marcar una función como "obsoleta" y proporcionar una advertencia al desarrollador que la utiliza:

``` kotlin
@Deprecated("Esta función está obsoleta. Utilice otra función en su lugar.")
fun funcionObsoleta() {
    print("Hola!")
}

fun main() {
    funcionObsoleta()
}
```
Al utilizar la función `funcionObsoleta()` en el `main()`, el IDE o la consola de depuración mostrará una advertencia que indica que se trata de una función obsoleta y sugiere utilizar otra función en su lugar. Esto ayuda a los desarrolladores a evitar el uso de funciones obsoletas y a mantener el código actualizado con las últimas mejores prácticas y funcionalidades disponibles.

![width:600 center](anotaciones.png)


Cabe destacar que Kotlin es un lenguaje interoperable con Java. De este modo, las anotaciones definidas en Kotlin pueden ser utilizadas en código Java de la misma manera que se utilizan las anotaciones definidas en Java. Además, existe el paquete kotlin.jvm que contiene anotaciones y funciones específicas para Java.


En este ejemplo, se definen dos anotaciones:

- `@Requerido`: Esta anotación se utiliza para indicar que un campo es requerido, lo cual significa que debe tener un valor asignado antes de que se pueda usar en el código. La anotación se aplica a los campos mediante la etiqueta `AnnotationTarget.FIELD`, y se mantiene durante la ejecución mediante la etiqueta `AnnotationRetention.RUNTIME`.

- `@Rango`: Esta anotación se utiliza para definir un rango de valores válidos para un campo. La anotación incluye dos parámetros: "min" y "max", que especifican el valor mínimo y máximo permitido para el campo. Al igual que la anotación `@Requerido`, esta anotación se aplica a los campos mediante la etiqueta `AnnotationTarget.FIELD`, y se mantiene durante la ejecución mediante la etiqueta `AnnotationRetention.RUNTIME`.


