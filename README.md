# play-json-naming

[![Build Status](https://travis-ci.org/tototoshi/play-json-naming.png)](https://travis-ci.org/tototoshi/play-json-naming)


Custom naming convention for play-json to map snake_case json to camelCase case classes.

# Releases

For Play 2.6, I recommend to use [play.api.libs.json.JsonNaming](https://www.playframework.com/documentation/2.6.x/ScalaJsonAutomated#Custom-Naming-Strategies)

| play-json-naming version | Play version     |
|--------------------------|------------------|
| 1.3.0                    | 2.7.x            |
| 1.2.0                    | 2.6.x            |
| 1.1.0                    | 2.5.x            |
| 1.0.0                    | 2.4.x            |
| 0.2.0                    | 2.3.x            |

## Setup

```scala
libraryDependencies += "com.github.tototoshi" %% "play-json-naming" % "1.3.0"
```

## Usage

```scala
import com.github.tototoshi.play.json.JsonNaming

case class Name(firstName: String, lastName: String)
case class User(id: Int, nameData: Name)

implicit val nameFormat = JsonNaming.snakecase(Json.format[Name])
implicit val userFormat = JsonNaming.snakecase(Json.format[User])

val jsonString = """{"id":1,"name_data":{"first_name":"Toshiyuki","last_name":"Takahashi"}}"""

Json.parse(jsonString).validate[User]
Json.toJson(User(1, Name("Toshiyuki", "Takahashi")))
```
