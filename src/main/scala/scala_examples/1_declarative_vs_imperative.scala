package scala_examples


object Declarative_vs_imperative extends App {

  val list_of_strings = List(
    "small",
    "alsosmall",
    "quiteabitbigger",
    "definitelytoolargetokeepattentionofreader"
  )

  val filtered_list = list_of_strings.filter(item => item.length < 10)

  println(filtered_list)

}
