package scala_examples

object PatternMatching extends App {

  // Using a trait and inheritance we can create a variety of shapes
  sealed trait Shape
  case class Square(size: Int) extends Shape
  case class Rectangle(width: Int, height: Int) extends Shape
  case class Circle(radius: Int) extends Shape

  val area = (shape: Shape) => shape match {
    case Square(size) => size * size
    case Rectangle(width, height) => width * height
    case Circle(radius) => Math.PI * Math.pow(radius, 2)
  }

  println(s"Area of a Square(4): ${area(Square(4))}")
  println(s"Area of a Rectangle(2,3): ${area(Rectangle(2,3))}")
  println(s"Area of a Circle(2): ${area(Circle(2))}")
}
