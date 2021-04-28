package scala_examples

object FunctionalComposition extends App {

  // --------------------------------- Part 1 - Composition of a greeting ---------------------------------
  println("------------ Part 1 ------------\n")

  val addGreeting = (name: String) => s"Hello, my name is $name"
  val toUpperCase = (text: String) => text.toUpperCase

  // Scala supports compose and andThen to combine functions, the only difference is the order of applying
  val loudGreeting = addGreeting.andThen(toUpperCase)
  print(loudGreeting("Tom"))


  // --------------------------------- Part 2 - Passing functions around ---------------------------------
  println("\n------------ Part 2 ------------\n")

  // First we create a generic divisible_by function
  val divisibleBy = (y: Int) => (x: Int) => x % y == 0

  // We can now create a divisible_by_2 function using divisible_by
  // Notice divisible_by_2 is another function that returns a function
  val divisibleBy2 = divisibleBy(2)
  println("Result of divisibleBy2(4)=" + divisibleBy2(4))
  println("Result of divisibleBy2(5)=" + divisibleBy2(5))
}
