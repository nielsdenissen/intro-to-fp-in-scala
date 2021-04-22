package scala_examples

object FunctionalComposition extends App {
  val addGreeting = (name: String) => s"Hello, my name is $name"
  val toUpperCase = (text: String) => text.toUpperCase

  // Scala supports compose and andThen to combine functions, the only difference is the order of applying
  val loudGreeting = addGreeting.andThen(toUpperCase)
  print(loudGreeting("Tom"))
}
