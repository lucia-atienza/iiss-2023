package main
import "fmt" // Para poder hacer uso de print...

// Definimos una estructura Scout para encapsular los datos del scout
type Scout struct {
    name        string      // nombre del scout 
    rank        string      // rango del scout 
    patrol      string      // patrulla del scout 
    meritBadges []string    // distintivos de mérito del scout 
}

// Creamos un constructor para la estructura Scout que toma los valores iniciales y devuelve un puntero a un nuevo objeto Scout
func NewScout(name, rank, patrol string) *Scout {
    return &Scout{
        name:        name,
        rank:        rank,
        patrol:      patrol,
        meritBadges: []string{},
    }
}

// Definimos métodos públicos para acceder a los campos de Scout (uso del principio de acceso uniforme)
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

// Definimos métodos públicos para modificar los campos de Scout (uso del principio de ocultación de la implementación)
func (s *Scout) AddMeritBadge(badge string) {
    s.meritBadges = append(s.meritBadges, badge)
}

func (s *Scout) RemoveMeritBadge(badge string) {
    for i, mb := range s.meritBadges {
        if mb == badge {
            s.meritBadges = append(s.meritBadges[:i], s.meritBadges[i+1:]...)
            break
        }
    }
}

// Definimos métodos públicos para realizar operaciones adicionales en Scout (uso del principio de encapsulación)
func (s *Scout) Clone() *Scout {
    // Devuelve una copia inmutable de Scout
    return &Scout{
        name:        s.name,
        rank:        s.rank,
        patrol:      s.patrol,
        meritBadges: append([]string{}, s.meritBadges...),
    }
}

func (s *Scout) IsEqualTo(other *Scout) bool {
    // Compara dos scouts para determinar si son iguales en términos de sus valores de campo
    if s.name != other.name {
        return false
    }
    if s.rank != other.rank {
        return false
    }
    if s.patrol != other.patrol {
        return false
    }
    if len(s.meritBadges) != len(other.meritBadges) {
        return false
    }
    for i, mb := range s.meritBadges {
        if mb != other.meritBadges[i] {
            return false
        }
    }
    return true
}


func main() {
    lucia := NewScout("Lucía", "Explorador", "Abeja")

    // Añadimos un distintivo de mérito a lucia
    lucia.AddMeritBadge("Campismo")

    // Mostramos el nombre y los distintivos de mérito de lucia
    fmt.Printf("%s tiene los siguientes distintivos de mérito: %v\n", lucia.Name(), lucia.MeritBadges())

    // Creamos una copia inmutable de lucia
    luciaCopy := lucia.Clone()

    // Cambiamos el rango de lucia
    lucia.SetRank("Scout")

    // Comparamos a lucia con su copia para ver si son iguales
    if lucia.IsEqualTo(luciaCopy) {
        fmt.Printf("%s y su copia son iguales", lucia.Name())
    } else {
        fmt.Printf("%s y su copia son diferentes", lucia.Name())
    }
}
