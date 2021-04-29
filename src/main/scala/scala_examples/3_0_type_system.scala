package scala_examples

object TypeSystem extends App {
  val listOfStrings = List("1", "9", "11", "100")

  // Parse strings to integers
  val listOfIntegers = listOfStrings.map(i => i.toInt)

  // Filtering the list of integers works fine
  listOfIntegers.filter(i => i < 10).foreach(println)

  // Filtering the list of strings does not compile
  // TODO: uncomment; below code raises a compilation error
  // listOfStrings.filter(i => i < 10).foreach(println)
}
