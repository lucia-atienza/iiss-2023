package controllers

import models.Actividad

import javax.inject._
import play.api.mvc._

@Singleton
class ActividadController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {
    def empezar() = Action {
        val actividad = Actividad("Actividad de Prueba", "Baja")
        actividad.empezar()
        Ok("Inicio de la actividad realizado")
    }
}
