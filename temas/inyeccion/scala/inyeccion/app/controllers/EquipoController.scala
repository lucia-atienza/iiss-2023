package controllers

import models.Equipo

import javax.inject._
import play.api.mvc._

@Singleton
class EquipoController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {
    def presentarse() = Action {
        val equipo = Equipo("Equipo de Prueba", "Lider de Prueba")
        equipo.presentarse()
        Ok("Presentación del equipo realizada")
    }
}
