
package streams

//import streams.GameDef._

object streamsscratch {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  //val p = new Pos(2,3)
  val v = Vector(Vector(1, 2, 3), Vector(4, 5, 6), Vector(7, 8, 9))
                                                  //> v  : scala.collection.immutable.Vector[scala.collection.immutable.Vector[Int
                                                  //| ]] = Vector(Vector(1, 2, 3), Vector(4, 5, 6), Vector(7, 8, 9))
val num = 4                                       //> num  : Int = 4

val Some((posY, posX)) = v.map(_ indexOf num).zipWithIndex.find(_._1 > -1)
                                                  //> posY  : Int = 0
                                                  //| posX  : Int = 1
   for (i <- 0 until v.length; j <- 0 until v(0).length; if v(i)(j) == 2) yield (i,j)
                                                  //> res0: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((0,1))
   List(1,2,3) indexOf 2                          //> res1: Int = 1
  // v indexWhere ((_ indexOf 2) > -1)
   val level =
    """ooo-------
      |oSoooo----
      |ooooooooo-
      |-ooooooooo
      |-----ooToo
      |------ooo-""".stripMargin                  //> level  : String = ooo-------
                                                  //| oSoooo----
                                                  //| ooooooooo-
                                                  //| -ooooooooo
                                                  //| -----ooToo
                                                  //| ------ooo-
}