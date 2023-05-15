import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.{Source, Sink}
import akka.{Done, NotUsed}
import scala.concurrent.{Future, Await, ExecutionContext}
import scala.concurrent.duration._

case class Cancion(nombre: String, artista: String, duracion: Int)

object ObservablesEjemplo {
    // Función para reproducir una canción
    def reproducirCancion(cancion: Cancion): Future[Done] = {
        // Simulación de la reproducción asincrónica de una canción
        println(s"Reproduciendo '${cancion.nombre}' de '${cancion.artista}'")
        Future.successful(Done)
    }

    def main(args: Array[String]): Unit = {
        implicit val system: ActorSystem = ActorSystem("CancionesSystem")
        implicit val materializer: ActorMaterializer = ActorMaterializer()
        implicit val ec: ExecutionContext = ExecutionContext.global

        val canciones: List[Cancion] = List(
            Cancion("EAEA", "Blanca Paloma", 200),
            Cancion("Cha cha cha", "Käärijä", 180),
            Cancion("Due Vite", "Marco Megoni", 220)
        )

        // Crear un observable de canciones a partir de la lista predefinida
        def reproducirCanciones(): Future[Done] = {
            val cancionesFuente: Source[Cancion, NotUsed] = Source(canciones)
            val reproducirSink: Sink[Cancion, Future[Done]] = Sink.foreach(reproducirCancion)

            cancionesFuente.runWith(reproducirSink)
        }

        val reproduccionCompleta: Future[Done] = reproducirCanciones()

        reproduccionCompleta.onComplete { _ =>
            println("Reproducción completa")
            system.terminate() // Cerrar el sistema de actores
        }

        Await.ready(reproduccionCompleta, Duration.Inf)
    }
}
