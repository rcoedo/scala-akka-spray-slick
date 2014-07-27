package com.rcoedo.config

import scala.slick.driver.{MySQLDriver, JdbcProfile}

trait EnvironmentComponent {
  val profile: String
  val database: AbstractDatabase
  val host: String
  val port: Int

  abstract class AbstractDatabase {
    val jdbcProfile: JdbcProfile
    import jdbcProfile.simple._
    def getDatabase: Database
  }

  class DevDatabase extends AbstractDatabase {
    val jdbcProfile = MySQLDriver
    import jdbcProfile.simple._
    def getDatabase = {
      Database.forURL("jdbc:mysql://127.0.0.1/sassrest", "sassuser", "sasspw", null, "com.mysql.jdbc.Driver")
    }
  }

  class TestDatabase extends AbstractDatabase {
    val jdbcProfile = MySQLDriver
    import jdbcProfile.simple._
    def getDatabase = {
      Database.forURL("jdbc:mysql://127.0.0.1/testsassrest", "testsassuser", "sasspw", null, "com.mysql.jdbc.Driver")
    }
  }
}
