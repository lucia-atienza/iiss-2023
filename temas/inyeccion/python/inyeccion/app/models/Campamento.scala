package models

import javax.inject.Inject
case class Campamento @Inject()(equipo: Equipo, actividades: Seq[Actividad]) {
  def prepararActividades(): Unit = {
    println(s"Estamos preparando actividades para el equipo ${equipo.nombre}:")
    equipo.presentarse()

    for (actividad <- actividades) {
      println(s"- $actividad")
      actividad.empezar()
    }
  }
}
