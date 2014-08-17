package com.theb0ardside.detroitapi

import com.typesafe.config.ConfigFactory

object DetroitapiConfig {
  private val config = ConfigFactory.load()

  object HttpConfig {
    private val httpConfig = config.getConfig("http")
    lazy val interface = httpConfig.getString("interface")
    lazy val port = httpConfig.getInt("port")
  }
  //Config Settings
}
