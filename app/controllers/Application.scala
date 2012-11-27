package controllers

import play.api.mvc._
import models.Comment
import play.api.data._
import play.api.data.Forms._

object Application extends Controller {
  val Home = Redirect(routes.Application.list)

  def list() = Action {
    val comments = Comment.findAll
    Ok(views.html.list(comments))
  }

  val commentForm = Form(
    tuple(
      "name" -> text,
      "comment" -> text
    )//(Comment.apply)(Comment.unapply)
  )

  def save = Action {
    implicit request =>
    commentForm.bindFromRequest
      .fold(
      formWithErrors => {
        Home.flashing("error" -> "Screw you")
      },
      comment => {
        Comment.insert(Comment(name = comment._1,comment = comment._2))
        Ok("success")
      }
    )
  }
}