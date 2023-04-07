## Anotaciones en Kotlin
Las anotaciones son medios para adjuntar metadatos al código. Para declarar una anotación, ponga el modificador annotation delante de una clase:
``` kotlin
annotation class NombreAnotacion
```
Además, pueden especificarse atributos adicionales anotando la clase de anotación con meta-anotaciones. 

Cabe destacar que Kotlin es un lenguaje interoperable con Java. De este modo, as anotaciones definidas en Kotlin pueden ser utilizadas en código Java de la misma manera que se utilizan las anotaciones definidas en Java. Además, existe el paquete kotlin.jvm que contiene anotaciones y funciones específicas para Java.

