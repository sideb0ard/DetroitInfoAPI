package com.theb0ardside.detroitapi

import akka.actor.{Actor, ActorSystem, Props, ActorLogging}
import spray.routing._



class DetroitapiActor extends Actor with DetroitapiService with ActorLogging {
  def actorRefFactory = context
  def receive = runRoute(detroitapiRoute)
}

trait DetroitapiService extends HttpService {
  import Json4sSupport._
  implicit def executionContext = actorRefFactory.dispatcher

  val detroitapiRoute = {
    path("") { 
      get {
        complete{ "HOME OF TECHNO" }
      }
    } ~
    path("artist" / IntNumber) { artistID => 
      get {
        complete{ "techno:" + artistID }
      } 
    }
  }
}

