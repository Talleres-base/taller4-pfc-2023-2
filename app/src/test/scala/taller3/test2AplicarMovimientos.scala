/**
  * Prueba de aplicar movimiento
  */
package taller3

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class test2AplicarMovimientos extends AnyFunSuite {
  test("Prueba1") {
    val obj = new ManiobrasTrenes()
    val e = (List('a','b'),List('c'),List('d'))
    val movs = List(Uno(1),Dos(1),Uno(-2))
    val res = obj.aplicarMovimientos(e,movs)
  }
}
