package scala_examples

import scala.util.{Failure, Success, Try}

object FunctionalProgrammingConcepts extends App {

  // --------------------------------- Part 1 - Map ---------------------------------
  println("------------ Part 1 - Map ------------\n")

  val multiplyBy2 = (in: Int) => in * 2

  // Using map we can execute a function on all elements in a functor (e.g. a list)
  val multipliedList = List(1, 2, 3, 4).map(multiplyBy2)
  println(multipliedList)


  // --------------------------------- Part 2 - Option ---------------------------------
  println("\n------------ Part 2 - Option ------------\n")

  // Let's look at a function that extracts an element from a list based on its index

  // We could implement this by returning null when the element doesn't exist
  def getElementFromListWithNull(someList: List[String], index: Int): String = {
    if (index < someList.length) someList(index)
    else null
  }

  // We can also use an Option to reflect that a function might return an empty value
  // This method actually exists in scala as lift (e.g. List(1,2).lift(2))
  def getElementFromListWithOption(someList: List[String], index: Int): Option[String] = {
    if (index < someList.length) Some(someList(index))
    else None
  }

  // The benefit of using an Option is that it's clear at compile time that the value might be empty
  println(s"Using null: ${getElementFromListWithNull(List("one","two"), 3)}")
  println(s"Using Option: ${getElementFromListWithOption(List("one","two"), 3)} \n")

  // We can easily unpack an Option using pattern matching
  getElementFromListWithOption(List("one","two"), 1) match {
    case Some(value) => println(s"Pattern Matching found a value: $value")
    case None => println("Pattern Matching found nothing")
  }

  // --------------------------------- Part 3 - Try ---------------------------------
  println("\n------------ Part 3 - Try ------------\n")

  // Another way to implement this is by throwing an exception when the element doesn't exist
  def getElementFromListWithException(someList: List[String], index: Int): String = {
    if (index < someList.length) someList(index)
    else throw new Exception(s"Index $index didn't exist")
  }

  // We can also use a Try to reflect that a function might return a exception
  def getElementFromListWithTry(someList: List[String], index: Int): Try[String] = {
    Try(getElementFromListWithException(someList, index))
  }

  // The benefit of using a Try is that it's clear at compile time that the value might be empty
  // println(s"Using exception: ${getElementFromListWithException(List("one","two"), 3)}")
  println(s"Using Try: ${getElementFromListWithTry(List("one","two"), 3)} \n")

  // We can easily unpack a Try using pattern matching
  getElementFromListWithTry(List("one","two"), 3) match {
    case Success(value) => println(s"Pattern Matching found a value: $value")
    case Failure(exception) => println(s"Pattern Matching found exception: $exception")
  }

  // --------------------------------- Part 4 - Either ---------------------------------
  println("\n------------ Part 4 - Either ------------\n")

  // Let's look at a function that parses a string to an integer

  // Using Either we can create a function that returns an integer when possible, or otherwise keeps the string
  def toInt(input: String): Either[Int, String] = {
    input.toIntOption match {
      case Some(parsedInteger) => Left(parsedInteger)
      case None => Right(input)
    }
  }

  println(s"Using Either: ${List("1", "two").map(toInt)} \n")

  // Again we can easily unpack an Either using pattern matching
  toInt("1") match {
    case Left(intValue) => println(s"Pattern Matching found an Integer: $intValue")
    case Right(stringValue) => println(s"Pattern Matching found a String: $stringValue")
  }
}
