package streams

object test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(72); 
  val a = Vector(Vector(1,2),Vector(3,4));System.out.println("""a  : scala.collection.immutable.Vector[scala.collection.immutable.Vector[Int]] = """ + $show(a ));$skip(20); val res$0 = 
  a apply 0 apply 0;System.out.println("""res0: Int = """ + $show(res$0));$skip(9); val res$1 = 
  a(0,0);System.out.println("""res1: <error> = """ + $show(res$1))}
}
