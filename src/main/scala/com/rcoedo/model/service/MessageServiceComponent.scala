package com.rcoedo.model.service

import com.rcoedo.config.EnvironmentComponent
import com.rcoedo.model.dao.MessageDaoComponent
import com.rcoedo.model.domain.Message

trait MessageServiceComponent { this: MessageDaoComponent with EnvironmentComponent =>
  val messageService:  MessageService

  class MessageService {
    def findMessage(id: Long): Option[Message] = database.getDatabase withSession { implicit session =>
      messageDao.find(id)
    }

    def findAllMessages(): List[Message] = database.getDatabase withSession { implicit session =>
      messageDao.findAll()
    }

    def createMessage(message: String) = database.getDatabase withSession { implicit session =>
      messageDao.insert(Message(message))
    }
  }
}
