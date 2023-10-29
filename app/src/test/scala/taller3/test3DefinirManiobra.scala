/**
  * Prueba de aplicar movimiento
  */
package taller3

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class test3DefinirManiobras extends AnyFunSuite {
  test("Prueba1") {
    val obj = new ManiobrasTrenes()
    val t1 = List('a','b','c','d')
    val t2 = List('d','b','c','a')
    val res = obj.definirManiobra(t1,t2)
    val resA = List(Uno(4),Uno(-3),Dos(3),Uno(-1),Dos(-1),Uno(1),Dos(-1),Uno(-1))
  }
}
