package com.theb0ardside.detroitapi

import akka.actor.{Actor, ActorSystem, Props, ActorLogging}
import akka.actor.ActorDSL._
import akka.io.IO
import spray.can.Http
import spray.routing._
import spray.util._
import akka.io.Tcp._

object DetroitapiApp extends App {
  implicit val system = ActorSystem("detroitapi-system")

  /* Spray Service */
  val service= system.actorOf(Props[DetroitapiActor], "detroitapi-service")

  val ioListener = actor("ioListener")(new Act with ActorLogging {
    become {
      case b @ Bound(connection) => log.info(b.toString)
    }
  })


  IO(Http).tell(Http.Bind(service, DetroitapiConfig.HttpConfig.interface, DetroitapiConfig.HttpConfig.port), ioListener)

}
