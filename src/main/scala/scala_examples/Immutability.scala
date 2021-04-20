package scala_examples

object Immutability extends App {
  var mutableVar = 0
  mutableVar = 10
  println(f"mutableVar: $mutableVar")


  val immutableVal = 0
  //  immutableVal = 10
  println(f"mutableVar: $immutableVal")
}
