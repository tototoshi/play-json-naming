package com.github.tototoshi.play.json

import play.api.libs.json._

object JsonNaming {

  private def mapKeys[A, B](m: Seq[(A, B)])(f: A => A): Seq[(A, B)] =
    m.map { case (k, v) => (f(k), v) }

  def snakecase[T](format: Format[T]): Format[T] = new Format[T] {
    def reads(json: JsValue): JsResult[T] = {
      format.reads(json match {
        case obj: JsObject => JsObject(mapKeys(obj.fields)(StringUtil.camelcase))
        case x => x
      })
    }

    def writes(o: T): JsValue = {
      format.writes(o) match {
        case obj: JsObject => JsObject(mapKeys(obj.fields)(StringUtil.snakecase))
        case x => x
      }
    }
  }
}
