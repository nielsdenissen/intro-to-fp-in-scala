val staticList = List(1,2,3)
println(staticList)

lazy val lazyListDoubled = staticList.map(_ * 2)
println(lazyListDoubled)
