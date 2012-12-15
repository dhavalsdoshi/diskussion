package models

import play.api.Play.current
import com.novus.salat.dao._
import com.mongodb.casbah.Imports._
import se.radley.plugin.salat._
import mongoContext._

case class Comment(id: ObjectId = new ObjectId,username: String,text: String, pageId:String, clientId: String)

object Comment extends ModelCompanion[Comment,ObjectId]{
  val dao = new SalatDAO[Comment, ObjectId](collection = mongoCollection("comments")) {}
}
