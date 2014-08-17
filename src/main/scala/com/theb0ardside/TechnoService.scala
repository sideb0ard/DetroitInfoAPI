package com.theb0ardside

import akka.actor.Actor
import spray.routing._
import spray.http._
import MediaTypes._

// we don't implement our route structure directly in the service actor because
// we want to be able to test it independently, without having to spin up an actor
class TechnoActor extends Actor with TechnoService {

  // the HttpService trait defines only one abstract member, which
  // connects the services environment to the enclosing actor or test
  def actorRefFactory = context

  // this actor only runs our route, but you could add
  // other things here, like request stream processing
  // or timeout handling
  def receive = runRoute(myRoute)
}


// this trait defines our service behavior independently from the service actor
trait TechnoService extends HttpService {

  val myRoute =
    path("") {
      get {
        complete {
          "TECHNO ARTIST INFO SERVICE::<br>Usage: [url]/artist/[id]"
        }
      }
    } ~
    path("artist" / IntNumber) { artistId =>
      get {
        complete {
          "ARTIST INFO: " + artistId
        }
      }
    }
}
