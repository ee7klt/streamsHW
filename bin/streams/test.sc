package streams

object test {
  val a = Vector(Vector(1,2),Vector(3,4))
  a apply 0 apply 0
  a(0,0)
}