// Clase base que representa un dispositivo de Raspberry Pi
interface RaspberryPiDevice {
    fun bootUp()
    fun shutDown()
}

// Clase que representa un sensor conectado a un puerto GPIO de la Raspberry Pi
interface RaspberryPiSensor : RaspberryPiDevice {
    fun readSensorData(): Double
}

// Clase que representa un sensor de temperatura conectado a un puerto GPIO de la Raspberry Pi
class RaspberryPiTemperatureSensor(private val gpioPin: Int) : RaspberryPiSensor {
    override fun bootUp() {
        println("Sensor de temperatura está arrancando")
    }

    override fun shutDown() {
        println("Sensor de temperatura está apagándose")
    }

    override fun readSensorData(): Double {
        // Código para leer la temperatura del sensor conectado al puerto GPIO
        println("Leyendo temperatura del sensor en el puerto GPIO $gpioPin")
        return 25.0
    }
}

// Clase que representa un actuador conectado a un puerto GPIO de la Raspberry Pi
interface RaspberryPiActuator : RaspberryPiDevice {
    fun setActuatorState(state: Boolean)
}

// Clase que representa un LED conectado a un puerto GPIO de la Raspberry Pi
class RaspberryPiLED(private val gpioPin: Int) : RaspberryPiActuator {
    override fun bootUp() {
        println("LED está arrancando")
    }

    override fun shutDown() {
        println("LED está apagándose")
    }

    override fun setActuatorState(state: Boolean) {
        // Código para configurar el estado del LED conectado al puerto GPIO
        println("Configurando el estado del LED en el puerto GPIO $gpioPin a $state")
    }
}

// Clase que representa un relé conectado a un puerto GPIO de la Raspberry Pi
class RaspberryPiRelay(private val gpioPin: Int) : RaspberryPiActuator {
    override fun bootUp() {
        println("Relé está arrancando")
    }

    override fun shutDown() {
        println("Relé está apagándose")
    }

    override fun setActuatorState(state: Boolean) {
        // Código para configurar el estado del relé conectado al puerto GPIO
        println("Configurando el estado del relé en el puerto GPIO $gpioPin a $state")
    }
}
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
