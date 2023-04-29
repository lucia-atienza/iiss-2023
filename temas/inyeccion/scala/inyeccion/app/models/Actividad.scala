package models

import javax.inject.Inject

case class Actividad @Inject() (nombre: String, dificultad: String) {
  def empezar(): Unit = {
    println(s"Vamos a empezar la actividad $nombre!")
  }
}
