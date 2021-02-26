package com.github.tototoshi.play.json

import org.scalatest._
import play.api.libs.json._
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class StringUtilSuite extends AnyFunSuite with Matchers {

  test("camelCase -> snake_case") {
    StringUtil.snakecase("play") should be("play")
    StringUtil.snakecase("playJson") should be("play_json")
  }

  test("snake_case -> camelCase") {
    StringUtil.camelcase("play") should be("play")
    StringUtil.camelcase("play_json") should be("playJson")
  }

}
