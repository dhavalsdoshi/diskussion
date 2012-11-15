package controllers

import play.api.mvc._
import models.Comment

object Application extends Controller {
  
  def list() = Action {
    val comments = Comment.findAll
    Ok(views.html.list(comments))
  }
  
}