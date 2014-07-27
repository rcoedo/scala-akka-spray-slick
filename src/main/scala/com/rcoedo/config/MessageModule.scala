package com.rcoedo.config

import com.rcoedo.model.dao.MessageDaoComponent
import com.rcoedo.model.service.MessageServiceComponent

trait MessageModule extends MessageServiceComponent with MessageDaoComponent with EnvironmentModule {
  val messageDao = new MessageDao
  val messageService = new MessageService
}
