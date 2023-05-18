## Lambdas en Kotlin

En Kotlin, una lambda es una función anónima que se puede pasar como argumento o asignar a una variable. En el código de ejemplo, se usan lambdas como argumentos en diferentes funciones de orden superior, como `filter`, `map`, `average`, `any`, `count` y `sortedByDescending`. Estas funciones toman una lambda como parámetro y la aplican a cada elemento de la lista.

La sintaxis general de una lambda en Kotlin es la siguiente:

```python

{ parámetros -> cuerpo de la lambda }
```



Dentro de la lambda, podemos acceder a los parámetros y escribir el código que queremos ejecutar. En el código anterior, utilizamos la variable `it` dentro de las lambdas. La variable `it` es un nombre especial que se puede utilizar cuando la lambda solo tiene un parámetro y podemos omitir la declaración explícita de ese parámetro.

Por ejemplo, en esta línea de código:

```kotlin

val olderScouts = scouts.filter { it.age > 12 }
```



La lambda `{ it.age > 12 }` se aplica a cada elemento de la lista `scouts` y devuelve aquellos elementos cuya edad es mayor que 12. Aquí, `it` representa cada elemento individual de la lista dentro de la lambda. En otras palabras, `it` se refiere a cada objeto `Scout` de la lista `scouts` mientras se ejecuta la lambda.

Es importante destacar que podemos utilizar cualquier nombre de parámetro en lugar de `it`. Por ejemplo, si quisiéramos usar un nombre de parámetro más descriptivo, podríamos escribir:

```kotlin

val olderScouts = scouts.filter { scout -> scout.age > 12 }
```



En este caso, hemos cambiado `it` por `scout` como nombre de parámetro, pero el comportamiento de la lambda seguirá siendo el mismo.
