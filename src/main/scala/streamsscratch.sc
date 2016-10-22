
package streams

import streams.GameDef

object streamsscratch {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  //val gd = new GameDef {
  //    def newPos(x: Int, y: Int): Pos = new Pos(x, y)
  // }
  val b = Vector()                                //> b  : scala.collection.immutable.Vector[Nothing] = Vector()
  b(2)                                            //> java.lang.IndexOutOfBoundsException: 2
                                                  //| 	at scala.collection.immutable.Vector.checkRangeConvert(Vector.scala:132)
                                                  //| 
                                                  //| 	at scala.collection.immutable.Vector.apply(Vector.scala:122)
                                                  //| 	at streams.streamsscratch$$anonfun$main$1.apply$mcV$sp(streams.streamssc
                                                  //| ratch.scala:13)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at streams.streamsscratch$.main(streams.streamsscratch.scala:6)
                                                  //| 	at streams.streamsscratch.main(streams.streamsscratch.scala)

  val l = List("a", "b", "c")
  l.lift(1)
  l.lift(1) == "b"
  l.lift(1) == Some("b")

  val v = Vector(Vector(1, 2, 3), Vector(4, 5, 6), Vector(7, 8, 9))
  val num = 4

  val Some((posY, posX)) = v.map(_ indexOf num).zipWithIndex.find(_._1 > -1)
  for (i <- 0 until v.length; j <- 0 until v(0).length; if v(i)(j) == 2) yield (i, j)
  List(1, 2, 3) indexOf 2
  // v indexWhere ((_ indexOf 2) > -1)
  val level =
    """ooo-------
      |oSoooo----
      |ooooooooo-
      |-ooooooooo
      |-----ooToo
      |------ooo-""".stripMargin
  val x = List(('a', 2), ('b', 4))
  for ((p, q) <- x) yield p

}