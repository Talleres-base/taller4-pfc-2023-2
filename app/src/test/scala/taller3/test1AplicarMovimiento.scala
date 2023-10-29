/**
  * Prueba de aplicar movimiento
  */
package taller3

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class test1AplicarMovimiento extends AnyFunSuite {
  test("Prueba1") {
    val obj = new ManiobrasTrenes()
    val e1 = (List('a','b','c','d'),Nil, Nil)
    val e2 = obj.aplicarMovimiento(e1,Uno(2))
    val e3 = obj.aplicarMovimiento(e2,Dos(3))
    val e4 = obj.aplicarMovimiento(e3,Dos(-1))
    val e5 = obj.aplicarMovimiento(e4,Uno(-2))

  }
}
