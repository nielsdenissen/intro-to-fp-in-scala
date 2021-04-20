package scala_examples

object Immutability extends App {
  // In Scala, to adjust an entry in a map we copy the previous along with the altered entry to create a new object
  // as it's immutable

  val original_map = Map(
    "one" -> "value",
    "another" -> "entry"
  )
  println(original_map)

  val new_map = original_map + ("one" -> "some_other_value")
  println(new_map)
}
