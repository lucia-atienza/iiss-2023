## Programación asíncrona en Golang

Go es un lenguaje de programación que tiene características nativas para la programación asincrónica. Algunas de estas características son: 
1. Goroutines: Las goroutines son funciones que se ejecutan en segundo plano de manera asíncrona a otras goroutines y a la función principal. Permiten que múltiples tareas se ejecuten simultáneamente sin bloquear el programa. 
2. Canales: Los canales son una forma de comunicación entre goroutines y la función principal, que permiten enviar y recibir datos de manera asíncrona. Los canales pueden ser utilizados para sincronizar el comportamiento de las goroutines y evitar condiciones de carrera. 
3. Select statement
4. WaitGroups
5. Contexts

Similar a muchos ejercicios que se realizan en PCTR, dividimos el trabajo en varias partes para finalmente agrupar el resultado. En concreto, este programa en Go implementa la programación asincrónica mediante el uso de goroutines y canales explicados en el punto anterior.

En líneas generales, se crea una lista de números aleatorios y se divide en 4 trozos de tamaño similar. Se lanza una goroutine para cada trozo de la lista, donde cada goroutine calcula la suma del trozo utilizando la función sum() y envía el resultado a través del canal resultChan. La función principal espera a recibir los resultados de cada goroutine desde el canal y los va sumando hasta obtener el resultado total. Debido a que los números generados son aleatorios, el resultado final variará cada vez que se ejecute el programa.

La programación asincrónica en este programa se da en el hecho de que cada goroutine se ejecuta de manera independiente y simultánea a las otras, sin esperar a que finalicen antes de continuar con la siguiente. Además, el canal de comunicación se utiliza para enviar y recibir datos de manera asíncrona entre las goroutines y la función principal, sin necesidad de bloquear la ejecución del programa.
