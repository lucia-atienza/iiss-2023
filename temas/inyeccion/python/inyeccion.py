class Equipo:
    def __init__(self, nombre, lider):
        self.nombre = nombre
        self.lider = lider

    def __str__(self):
        return f"{self.nombre} ({self.lider})"

    def presentarse(self):
        print(f"Se presenta el equipo {self.nombre} y nuestr@ líder es {self.lider}. ¡Scouts siempre listos!")

class Actividad:
    def __init__(self, nombre, dificultad):
        self.nombre = nombre
        self.dificultad = dificultad

    def __str__(self):
        return f"{self.nombre} (dificultad: {self.dificultad})"

    def empezar(self):
        print(f"¡Vamos a empezar la actividad {self.nombre}!")

class Campamento:
    def __init__(self, equipo, actividades):
        self.equipo = equipo
        self.actividades = actividades

    def preparar_actividades(self):
        print(f"Estamos preparando actividades para el equipo {self.equipo}:")
        self.equipo.presentarse()  

        for actividad in self.actividades:
            print(f"- {actividad}")
            actividad.empezar() 

equipo_scouts = Equipo("Scouts de Andalucía", "Lucía")
actividades_scouts = [
    Actividad("Senderismo", "media"),
    Actividad("Acampada", "alta"),
    Actividad("Construcciones", "baja")
]

campamento_scouts = Campamento(equipo_scouts, actividades_scouts)

campamento_scouts.preparar_actividades()
