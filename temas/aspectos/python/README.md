## Aspectos en Python

La librería Aspectlib es una herramienta en Python que permite la programación orientada a aspectos. Proporciona una sintaxis sencilla para definir aspectos, que son funciones o clases que se ejecutan en un punto específico de la ejecución de un programa. Estos puntos de ejecución se llaman puntos de corte (join points) y pueden ser métodos, funciones, llamadas a funciones, excepciones, etc.

Aspectlib utiliza la técnica de tejido (weaving) para combinar los aspectos con el código original. Esto se realiza en tiempo de ejecución, lo que significa que los aspectos no afectan el código original y sólo se ejecutan cuando se cumplen las condiciones establecidas en el punto de corte.

El código de ejemplo utiliza aspectos para validar el saldo inicial de una cuenta bancaria antes de agregarla a la lista de cuentas del banco. El aspecto `validar_saldo_inicial` se encarga de verificar que el saldo inicial de la cuenta sea mayor o igual a 30 euros. Si el saldo inicial cumple con esta condición, el aspecto permite que la función `agregar_cuenta` continúe su ejecución y agrega la cuenta a la lista del banco. Si el saldo inicial no cumple con la condición, el aspecto interrumpe la ejecución de la función y muestra un mensaje de error.
