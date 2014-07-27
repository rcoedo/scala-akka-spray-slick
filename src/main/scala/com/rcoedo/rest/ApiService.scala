package com.rcoedo.rest

import akka.actor.Actor
import com.rcoedo.config.{EnvironmentModule, MessageModule}
import com.rcoedo.model.service.{MessageServiceComponent}
import spray.routing.HttpService
import spray.httpx.Json4sSupport
import spray.http.MediaTypes.`application/json`
import org.json4s.native.Serialization.formats
import org.json4s.NoTypeHints

trait ApiService extends HttpService with Json4sSupport { this: MessageServiceComponent =>
  implicit val json4sFormats = formats(NoTypeHints)

  val ApiRoute =
    pathPrefix("api") {
      pathPrefix("messages") {
        pathEndOrSingleSlash {
          complete(messageService.findAllMessages())
        }
      } ~
      pathPrefix("message" / LongNumber) {
        id => respondWithMediaType(`application/json`) {
          complete(messageService.findMessage(id))
        }
      }
    }
}

class ApiServiceActor extends Actor with ApiService with MessageModule with EnvironmentModule {
  def actorRefFactory = context
  def receive = runRoute(ApiRoute)
}
