package com.github.tototoshi.play.json

import play.api.libs.json._

object JsonNaming {

  private def mapKeys[A, B, C](m: Seq[(A, B)])(f: A => C): Seq[(C, B)] =
    m.map { case (k, v) => (f(k), v) }

  private def snakecaseReads[T](parentReads: JsValue => JsResult[T]): Reads[T] = new Reads[T] {
    def reads(json: JsValue): JsResult[T] = {
      parentReads(json match {
        case obj: JsObject => JsObject(mapKeys(obj.fields)(StringUtil.camelcase))
        case x => x
      })
    }
  }

  private def snakecaseWrites[T](parentWrites: T => JsValue): Writes[T] = new Writes[T] {
    def writes(o: T): JsValue = {
      parentWrites(o) match {
        case obj: JsObject => JsObject(mapKeys(obj.fields)(StringUtil.snakecase))
        case x => x
      }
    }
  }

  def snakecase[T](reads: Reads[T]): Reads[T] = snakecaseReads(reads.reads)

  def snakecase[T](writes: Writes[T]): Writes[T] = snakecaseWrites(writes.writes)

  def snakecase[T](format: Format[T]): Format[T] = Format(snakecaseReads(format.reads), snakecaseWrites(format.writes))
}
