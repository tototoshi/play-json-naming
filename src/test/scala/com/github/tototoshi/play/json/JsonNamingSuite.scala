package com.github.tototoshi.play.json

import org.scalatest._
import play.api.libs.json._

case class Name(firstName: String, lastName: String)
case class User(id: Int, nameData: Name)

class JsonNamingSuite extends FunSuite with ShouldMatchers {

  implicit val nameFormat = JsonNaming.snakecase(Json.format[Name])
  implicit val userFormat = JsonNaming.snakecase(Json.format[User])

  val jsonString = """{"id":1,"name_data":{"first_name":"Toshiyuki","last_name":"Takahashi"}}"""

  test("read") {
    Json.parse(jsonString).validate[User].get should be(User(1, Name("Toshiyuki", "Takahashi")))
  }

  test("write") {
    Json.toJson(User(1, Name("Toshiyuki", "Takahashi"))) should be(Json.parse(jsonString))
  }

}
