package com.rcoedo.model.dao

import com.rcoedo.config.EnvironmentComponent

import scala.util.Try

trait GenericDaoComponent { this: EnvironmentComponent =>
  import database.jdbcProfile.simple._
  import scala.slick.lifted.TableQuery

  abstract class GenericDao[T <: IdentifiableTable[S], S] {
    val entities: TableQuery[T]

    def init(implicit session: Session) = {
      Try(entities.ddl.drop)
      entities.ddl.create
    }

    def find(id: Long)(implicit session: Session): Option[S] = {
      val byId = entities.findBy(_.id)
      byId(id).list.headOption
    }

    def insert(entity: S)(implicit session: Session) = {
      entities.insert(entity)
    }

    def update(id: Long, entity: S)(implicit session: Session): Boolean = {
      find(id) match {
        case Some(e) => entities.where(_.id === id).update(entity); true
        case None => false
      }
    }

    def delete(id: Long)(implicit session: Session): Boolean = {
      find(id) match {
        case Some(entity) => entities.where(_.id === id).delete; true
        case None => false
      }
    }
  }

  abstract class IdentifiableTable[T](tag: Tag, name: String) extends Table[T](tag, name) {
    def id: Column[Long] = column[Long]("id", O.PrimaryKey, O.AutoInc)
  }
}
