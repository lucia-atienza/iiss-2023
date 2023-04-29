package models

import javax.inject.Inject

case class Equipo @Inject()(nombre: String, lider: String) {
  def presentarse(): Unit = {
    println(s"Se presenta el equipo $nombre y nuestro líder es $lider. Scouts siempre listos!")
  }
}
