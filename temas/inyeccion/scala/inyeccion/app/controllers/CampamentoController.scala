package controllers

import javax.inject._
import play.api.mvc._
import models.{Actividad, Equipo, Campamento}


@Singleton
class CampamentoController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {
    def prepararActividades() = Action {
        val equipo_scouts = Equipo("Scouts de Andalucia", "Lucia")
        val actividades_scouts = Seq(
            Actividad("Senderismo", "media"),
            Actividad("Acampada", "alta"),
            Actividad("Construcciones", "baja")
        )

        val campamento_scouts = Campamento(equipo_scouts, actividades_scouts)

        campamento_scouts.prepararActividades()

        Ok("Actividades preparadas")
    }
}
