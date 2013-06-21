package controllers

import play.api.mvc._
import models.Comment
import play.api.data._
import play.api.data.Forms._
import com.mongodb.casbah.commons.MongoDBObject

object Application extends Controller {
  val Home = Redirect(routes.Application.list)

  def list() = Action {
    implicit request =>
      newCommentForm.bindFromRequest.fold(
        formWithErrors => {
          BadRequest("Insufficient Parameters. Please mention clientId & pageId ")
        },
        newCommentForm => {
          val comments = Comment.find(MongoDBObject("pageId" -> newCommentForm._2, "clientId" -> newCommentForm._1))
          Ok(views.html.list(comments,newCommentForm._1,newCommentForm._2))
        }
      )
  }

  val newCommentForm = Form(
    tuple(
      "clientId" -> text,
      "pageId" -> text
    )
  )

  val commentForm = Form(
    tuple(
      "username" -> text,
      "text" -> text,
      "clientId" -> text,
      "pageId" -> text
    )//(Comment.apply)(Comment.unapply)
  )

  def save = Action {
    implicit request =>
    commentForm.bindFromRequest
      .fold(
      formWithErrors => {
        BadRequest("as")
      },
      comment => {
        Comment.insert(Comment(username = comment._1,text = comment._2,clientId = comment._3,pageId = comment._4))
        Ok("success")
      }
    )
  }
}