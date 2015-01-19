# play-json-naming

Custom naming convention for play-json to map snake_case json to camelCase case classes.

## Setup

```scala
resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

libraryDependencies += "com.github.tototoshi" %% "play-json-naming" % "0.1.0-SNAPSHOT"
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
