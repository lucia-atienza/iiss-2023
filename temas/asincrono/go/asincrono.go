package main

import (
	"fmt"
	"time"
)

// Una función que realiza una operación de larga duración y devuelve un entero
func myFunction() int {
	time.Sleep(time.Second)
	return 1
}

// La función principal que inicia la goroutine y espera el resultado
func main() {
	// Crear un canal para comunicarse entre la goroutine y la función principal
	resultChan := make(chan int)

	// Iniciar la goroutine que ejecutará la función asíncronamente
	go func() {
		result := myFunction()
		// Envía el resultado a través del canal
		resultChan <- result
	}()

	fmt.Println("Esperando el resultado...")
	// Esperar a que se reciba el resultado a través del canal
	result := <-resultChan
	fmt.Println("Resultado:", result+1)
}
