// Clase base que representa un dispositivo de Raspberry Pi
open class RaspberryPiDevice(val id: Int, val name: String) {
    fun bootUp() {
        println("$name $id está arrancando")
    }

    fun shutDown() {
        println("$name $id está apagándose")
    }
}

// Clase que representa un sensor conectado a un puerto GPIO de la Raspberry Pi
open class RaspberryPiSensor(id: Int, name: String, val gpioPin: Int) : RaspberryPiDevice(id, name) {
    open fun readSensorData(): Double {
        println("$name $id leyendo datos del sensor en el puerto GPIO $gpioPin")
        return 0.0
    }
}

// Clase que representa un sensor de temperatura conectado a un puerto GPIO de la Raspberry Pi
class RaspberryPiTemperatureSensor(id: Int, name: String, gpioPin: Int) : RaspberryPiSensor(id, name, gpioPin) {
    override fun readSensorData(): Double {
        // Código para leer la temperatura del sensor conectado al puerto GPIO
        println("$name $id leyendo temperatura del sensor en el puerto GPIO $gpioPin")
        return 25.0
    }
}
// Clase que representa un actuador conectado a un puerto GPIO de la Raspberry Pi
open class RaspberryPiActuator(id: Int, name: String, val gpioPin: Int) : RaspberryPiDevice(id, name) {
    open fun setActuatorState(state: Boolean) {
        println("$name $id configurando el estado del actuador en el puerto GPIO $gpioPin a $state")
    }
}

// Clase que representa un LED conectado a un puerto GPIO de la Raspberry Pi
class RaspberryPiLED(id: Int, name: String, gpioPin: Int) : RaspberryPiActuator(id, name, gpioPin) {
    override fun setActuatorState(state: Boolean) {
        // Código para configurar el estado del LED conectado al puerto GPIO
        println("$name $id configurando el estado del LED en el puerto GPIO $gpioPin a $state")
    }
}

// Clase que representa un relé conectado a un puerto GPIO de la Raspberry Pi
class RaspberryPiRelay(id: Int, name: String, gpioPin: Int) : RaspberryPiActuator(id, name, gpioPin) {
    override fun setActuatorState(state: Boolean) {
        // Código para configurar el estado del relé conectado al puerto GPIO
        println("$name $id configurando el estado del relé en el puerto GPIO $gpioPin a $state")
    }
}

fun interactWithRaspberryPiDevice(device: RaspberryPiDevice) {
    device.bootUp()
    device.shutDown()
}

fun readRaspberryPiSensorData(sensor: RaspberryPiSensor) {
    sensor.readSensorData()
}

fun setRaspberryPiActuatorState(actuator: RaspberryPiActuator, state: Boolean) {
    actuator.setActuatorState(state)
}

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
