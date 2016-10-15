
package streams

//import streams.GameDef._

object streamsscratch {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(113); 
  println("Welcome to the Scala worksheet");$skip(93); 
  //val p = new Pos(2,3)
  val v = Vector(Vector(1, 2, 3), Vector(4, 5, 6), Vector(7, 8, 9));System.out.println("""v  : scala.collection.immutable.Vector[scala.collection.immutable.Vector[Int]] = """ + $show(v ));$skip(12); 
val num = 4;System.out.println("""num  : Int = """ + $show(num ));$skip(76); 

val Some((posY, posX)) = v.map(_ indexOf num).zipWithIndex.find(_._1 > -1);System.out.println("""posY  : Int = """ + $show(posY ));System.out.println("""posX  : Int = """ + $show(posX ));$skip(86); val res$0 = 
   for (i <- 0 until v.length; j <- 0 until v(0).length; if v(i)(j) == 2) yield (i,j);System.out.println("""res0: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$0));$skip(25); val res$1 = 
   List(1,2,3) indexOf 2;System.out.println("""res1: Int = """ + $show(res$1))}
  // v indexWhere ((_ indexOf 2) > -1)
  
}
