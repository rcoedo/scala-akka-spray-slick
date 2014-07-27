package com.rcoedo.model.dao

import com.rcoedo.config.EnvironmentComponent
import com.rcoedo.model.domain.Message

trait MessageDaoComponent extends GenericDaoComponent { this: EnvironmentComponent =>
  import database.jdbcProfile.simple._

  val messageDao: MessageDao

  class Messages(tag: Tag) extends IdentifiableTable[Message](tag, "messages") {
    def data = column[String]("data")
    def * = (data, id) <> (Message.tupled, Message.unapply)
  }

  class MessageDao extends GenericDao[Messages, Message] {
    val entities = TableQuery[Messages]

    def findAll()(implicit session: Session): List[Message] = {
      entities.list()
    }
  }
}
