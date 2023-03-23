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

En el código de ejemplo se muestra la implementación de clases y funciones en Kotlin para interactuar con dispositivos de Raspberry Pi (sensores y actuadores). Se define una clase base llamada `RaspberryPiDevice` que representa un dispositivo de Raspberry Pi y dos subclases que heredan de ella, `RaspberryPiSensor` y `RaspberryPiActuator`. Las subclases a su vez tienen subclases específicas que representan sensores de temperatura, LEDs y relés. Cada subclase implementa métodos específicos que permiten interactuar con el dispositivo correspondiente, como leer datos del sensor o configurar el estado del actuador.

Además, se definen varias funciones que permiten interactuar con los dispositivos. En la función main, se crean instancias de cada uno de los dispositivos y se llaman a las funciones correspondientes para interactuar con ellos. 
``` kotlin
fun main() {
    val temperatureSensor = RaspberryPiTemperatureSensor(1, "Sensor de Temperatura", 4)
    val led = RaspberryPiLED(2, "LED", 17)
    val relay = RaspberryPiRelay(3, "Relé", 27)

    interactWithRaspberryPiDevice(temperatureSensor)
    readRaspberryPiSensorData(temperatureSensor)

    interactWithRaspberryPiDevice(led)
    setRaspberryPiActuatorState(led, true)

    interactWithRaspberryPiDevice(relay)
    setRaspberryPiActuatorState(relay, false)
}
```
Dando como resultado el siguiente output:
``` 
Sensor de Temperatura 1 está arrancando
Sensor de Temperatura 1 está apagándose
Sensor de Temperatura 1 leyendo temperatura del sensor en el puerto GPIO 4
LED 2 está arrancando
LED 2 está apagándose
LED 2 configurando el estado del LED en el puerto GPIO 17 a true
Relé 3 está arrancando
Relé 3 está apagándose
Relé 3 configurando el estado del relé en el puerto GPIO 27 a false
```
