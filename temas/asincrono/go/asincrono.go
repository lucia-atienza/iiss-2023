// ejecución online: https://go.dev/play/, https://www.tutorialspoint.com/execute_golang_online.php
package main

import (
	"fmt"
	"math/rand"
	"time"
)

// recibe una lista de números enteros y devuelve la suma total
func sum(numbers []int) int {
	result := 0
	for _, number := range numbers {
		result += number
	}
	return result
}

// iniciamos las goroutines y espera los resultados
func main() {
	// creamos un canal para comunicarse entre las goroutines y la función principal
	resultChan := make(chan int)

	// lista de nums. aleatorios
	rand.Seed(time.Now().Unix())
	numbers := make([]int, 1000)
	for i := 0; i < len(numbers); i++ {
		numbers[i] = rand.Intn(10)
	}

	// dividimos la anterior lista en 4 para ejecuciones paralelas
	chunkSize := len(numbers) / 4
	chunks := make([][]int, 4)
	for i := 0; i < 4; i++ {
		chunks[i] = numbers[i*chunkSize : (i+1)*chunkSize]
	}
	// inicio goroutines
	for _, chunk := range chunks {
		go func(chunk []int) {
			result := sum(chunk)
			resultChan <- result
		}(chunk)
	}

	// se reciben los datos y se suman
	total := 0
	for i := 0; i < 4; i++ {
		result := <-resultChan
		total += result
	}

	fmt.Println("La suma total es:", total)
}
