## Delegación con Kotlin
La delegación y la composición son dos mecanismos fundamentales en la programación orientada a objetos que permiten crear clases y objetos complejos a partir de otros más simples.

La delegación permite a un objeto invocar métodos de otro objeto para realizar una tarea específica, en lugar de implementar la funcionalidad directamente en el objeto original. Esto ayuda a separar las responsabilidades y mejorar la modularidad del código, ya que los objetos delegados pueden ser intercambiados y reutilizados sin afectar al objeto que los invoca.

La composición, por otro lado, implica la creación de un objeto complejo a partir de otros objetos más simples, combinando sus funcionalidades para lograr un comportamiento más complejo. La composición se basa en la idea de que un objeto puede tener referencias a otros objetos como atributos, y utilizar sus métodos y propiedades para lograr su propia funcionalidad.

En Kotlin, la delegación se puede lograr a través de interfaces, donde una clase implementa una o varias interfaces que definen los métodos que debe proporcionar. Luego, un objeto de esta clase se puede pasar a otro objeto como un objeto de la interfaz, lo que permite al objeto receptor invocar los métodos de la interfaz a través del objeto delegado. En el código de ejemplo, se definen las interfaces `RaspberryPiDevice`, `RaspberryPiSensor` y `RaspberryPiActuator` que representan diferentes tipos de dispositivos que pueden ser conectados a una Raspberry Pi. Las clases `RaspberryPiTemperatureSensor`, `RaspberryPiLED` y `RaspberryPiRelay` implementan estas interfaces y proporcionan la implementación concreta de las operaciones `bootUp()`, `shutDown()` y `readSensorData()` o `setActuatorState()`, dependiendo de la interfaz que implementan.

Por otro lado, la composición en Kotlin se puede lograr a través de la creación de objetos como atributos de una clase, lo que permite que la clase utilice los métodos y propiedades del objeto atributo para lograr su propia funcionalidad. 

El código está diseñado para representar una Raspberry Pi compuesta por diferentes dispositivos, como sensores, LEDs y relés, todos conectados a puertos GPIO de la Raspberry Pi. En el programa principal, se crea una lista de dispositivos que incluye un sensor de temperatura, un LED y un relé, todos ellos instancias de las clases definidas previamente.

 ``` kotlin
 
fun main() {
    val devices = listOf(
        RaspberryPiTemperatureSensor(18),
        RaspberryPiLED(23),
        RaspberryPiRelay(24)
    )

    for (device in devices) {
        device.bootUp()

        when (device) {
            is RaspberryPiTemperatureSensor -> {
                val temperature = device.readSensorData()
                println("Temperatura leída: $temperature")
            }
            is RaspberryPiActuator -> {
                device.setActuatorState(true)
                Thread.sleep(1000)
                device.setActuatorState(false)
            }
        }

        device.shutDown()
    }
}
```
Este código tiene como output lo siguiente:
```
Sensor de temperatura está arrancando
Leyendo temperatura del sensor en el puerto GPIO 18
Temperatura leída: 25.0
Sensor de temperatura está apagándose
LED está arrancando
Configurando el estado del LED en el puerto GPIO 23 a true
Configurando el estado del LED en el puerto GPIO 23 a false
LED está apagándose
Relé está arrancando
Configurando el estado del relé en el puerto GPIO 24 a true
Configurando el estado del relé en el puerto GPIO 24 a false
Relé está apagándose
```
