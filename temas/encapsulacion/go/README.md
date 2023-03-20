# Encapsulación con Go
Go no tiene clases en el sentido tradicional de la Programación Orientada a Objetos. Sin embargo, Go tiene estructuras (structs) que se pueden utilizar para definir tipos de datos personalizados y agrupar datos relacionados en una sola entidad.

Para lograr la encapsulación de datos en Go, se utiliza una convención de nomenclatura en la que los campos de una estructura se escriben con la primera letra en minúscula si se desea que sean privados y con la primera letra en mayúscula si se desea que sean públicos.

```golang
type Scout struct {
    name        string      // nombre del scout 
    rank        string      // rango del scout 
    patrol      string      // patrulla del scout 
    meritBadges []string    // distintivos de mérito del scout 
}
```
Este código define una estructura Scout que encapsula los datos de un scout, como su nombre, rango, patrulla y distintivos de mérito. Como hemos mencionado anteriormente, al estar los campos de la estructura escritos con la primera letra en minúscula, se entiende que son privados y no pueden ser accedidos directamente desde fuera de la estructura.

En Go, no existe una construcción de lenguaje llamada "constructor" como en otros lenguajes orientados a objetos como Java o C#. En cambio, se utiliza una función común que devuelve una nueva instancia de una estructura.

Por convención, se llama a esta función New\<NombreDeLaEstructura\> y devuelve un puntero a una nueva instancia de la estructura. Aquí hay un ejemplo de cómo se podría definir un constructor para la estructura Scout:
```golang
func NewScout(name, rank, patrol string) *Scout {
    return &Scout{
        name:        name,
        rank:        rank,
        patrol:      patrol,
        meritBadges: []string{},
    }
}
```
Además, Go utiliza el principio de ocultación de la implementación para garantizar que los datos privados de una estructura no puedan ser accedidos directamente desde fuera de la estructura. En su lugar, se utilizan métodos para acceder y modificar los datos privados.
```golang

func (s *Scout) Name() string {
    return s.name
}

func (s *Scout) Rank() string {
    return s.rank
}

func (s *Scout) SetRank(rank string) {
    s.rank = rank
}

func (s *Scout) Patrol() string {
    return s.patrol
}

func (s *Scout) SetPatrol(patrol string) {
    s.patrol = patrol
}

func (s *Scout) MeritBadges() []string {
    // Devuelve una copia de los distintivos de mérito (uso del principio de inmutabilidad del estado)
    return append([]string{}, s.meritBadges...)
}

```
En el código proporcionado, los métodos públicos Name(), Rank(), Patrol() y MeritBadges() proporcionan acceso a los campos de name, rank, patrol y meritBadges, respectivamente. De esta manera, los campos se pueden leer (acceder) sin necesidad de exponerlos directamente, lo que asegura que los datos estén protegidos y encapsulados.

Por ejemplo, si se quiere acceder al nombre de un objeto Scout, se puede llamar al método Name(). De esta manera, el método Name() actúa como una interfaz pública para acceder al campo privado name de la estructura Scout.

Para definir métodos que modifiquen el valor de un campo, se pueden crear métodos con un nombre que empiece por "Set" seguido del nombre del campo que se quiere modificar en mayúscula. Por ejemplo, si tenemos un campo llamado "patrol" en la estructura Scout, podríamos definir un método SetPatrol que modifique el valor de este campo:
```golang

func (s *Scout) SetPatrol(patrol string) {
    s.patrol = patrol
}
```
Este método, al ser definido en la estructura Scout, tiene acceso al campo "patrol" y lo modifica directamente. De esta forma, se sigue el principio de acceso uniforme y se asegura que cualquier modificación del campo "patrol" se haga a través de un método de la estructura Scout, manteniendo la encapsulación de los datos.



Por último, Go también aplica el principio de acceso uniforme, lo que significa que el acceso a los campos públicos y privados de una estructura se hace de la misma manera, a través de métodos públicos que acceden a los campos internos de la estructura.

