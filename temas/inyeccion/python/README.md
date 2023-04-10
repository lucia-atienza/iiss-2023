## Inyección de dependencias en Python
La inyección de dependencia es un técnica de desarrollo que nos permite escribir código con un alto nivel de cohesión y un bajo nivel de dependencia. Tenemos, principalmente, 3 tipos de inyección de dependencias.
- Constructor injection.
- Property injection.
- Method injection.

En el código se utilizan tres clases: `Equipo`, `Actividad` y `Campamento`. La inyección de dependencias ocurre en el constructor de la clase `Campamento`, tratándose de un ejemplo del primer caso antes mencionado. En lugar de crear una instancia de `Equipo` y una lista de `Actividad` dentro de la clase `Campamento`, se inyectan como parámetros en el constructor. 

De esta manera, la clase `Campamento` no tiene ninguna dependencia directa de las clases `Equipo` y `Actividad`, lo que la hace más flexible y fácil de mantener en el futuro. Además, esto permite que se puedan utilizar diferentes instancias de `Equipo` y listas de `Actividad` en diferentes instancias de `Campamento`.

Luego, en la función `preparar_actividades()` de la clase `Campamento`, se utilizan las funciones `presentarse()` y `empezar()` de las clases `Equipo` y `Actividad`, respectivamente. 

Si tenemos en cuenta el código, obtenemos por pantalla el siguiente output:
```
Se presenta el equipo Scouts de Andalucía y nuestr@ líder es Lucía. ¡Scouts siempre listos!
Estamos preparando actividades para el equipo Scouts de Andalucía (Lucía):
- Senderismo (dificultad: media)
¡Vamos a empezar la actividad Senderismo!
- Acampada (dificultad: alta)
¡Vamos a empezar la actividad Acampada!
- Construcciones (dificultad: baja)
¡Vamos a empezar la actividad Construcciones!
```
