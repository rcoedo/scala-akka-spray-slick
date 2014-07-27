package com.rcoedo.config

trait EnvironmentModule extends EnvironmentComponent {
  val database = new DevDatabase
  val host = "localhost"
  val port = 8080
  val profile = "dev"
}
