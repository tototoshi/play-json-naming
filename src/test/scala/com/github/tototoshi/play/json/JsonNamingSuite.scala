package com.github.tototoshi.play.json

import org.scalatest._
import play.api.libs.json._

case class Name(firstName: String, lastName: String)
case class User(id: Int, nameData: Name)

class JsonNamingSuite extends FunSuite with Matchers {

  val jsonString = """{"id":1,"name_data":{"first_name":"Toshiyuki","last_name":"Takahashi"}}"""

  test("read") {
    implicit val nameReads = JsonNaming.snakecase(Json.reads[Name])
    implicit val userReads = JsonNaming.snakecase(Json.reads[User])

    Json.parse(jsonString).validate[User].get should be(User(1, Name("Toshiyuki", "Takahashi")))
  }

  test("write") {
    implicit val nameWrites = JsonNaming.snakecase(Json.writes[Name])
    implicit val userWrites = JsonNaming.snakecase(Json.writes[User])

    Json.toJson(User(1, Name("Toshiyuki", "Takahashi"))) should be(Json.parse(jsonString))
  }

  test("format") {
    implicit val nameFormat = JsonNaming.snakecase(Json.format[Name])
    implicit val userFormat = JsonNaming.snakecase(Json.format[User])

    Json.parse(jsonString).validate[User].get should be(User(1, Name("Toshiyuki", "Takahashi")))

    Json.toJson(User(1, Name("Toshiyuki", "Takahashi"))) should be(Json.parse(jsonString))
  }

}
