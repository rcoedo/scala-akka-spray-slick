package com.rcoedo.boot

import akka.actor.{ActorSystem, Props}
import akka.io.IO
import com.rcoedo.rest.ApiServiceActor
import com.rcoedo.config.{EnvironmentModule, MessageModule}
import spray.can.Http

object Boot extends App with EnvironmentModule with MessageModule {
  database.getDatabase withSession { implicit session =>
    profile match {
      case "prod" => Unit
      case _ => messageDao.init
    }
  }

  messageService.createMessage("Howdy, world!")
  messageService.createMessage("How are we today?")

  implicit val system = ActorSystem("spray-api-service")
  val service = system.actorOf(Props[ApiServiceActor], "spray-service")
  IO(Http) ! Http.Bind(service, host, port)
}
