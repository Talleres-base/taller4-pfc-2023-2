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
    val e1 = (List('a','b','c','d'),List(), List())
    val e2 = obj.aplicarMovimiento(e1,Uno(2))
    assert(e2 == (List('a','b'),List('c','d'),List()))
    val e3 = obj.aplicarMovimiento(e2,Dos(3))
    assert(e3 == (List(), List('c','d'),List('a','b')))
    val e4 = obj.aplicarMovimiento(e3,Dos(-1))
    assert(e4 == (List('a'),List('c','d'),List('b')))
    val e5 = obj.aplicarMovimiento(e4,Uno(-2))
    assert(e5 == (List('a','c','d'),List(),List('b')))
  }

  test("Prueba2") {
    val obj = new ManiobrasTrenes()
    val e1 = (List('a','b','c','d','e','f','g'),List(), List())
    val e2 = obj.aplicarMovimiento(e1,Uno(2))
    assert(e2 == (List('a','b','c','d','e'),List('f','g'),List()))
    val e3 = obj.aplicarMovimiento(e2,Dos(3))
    assert(e3 == (List('a','b'), List('f','g'),List('c','d','e')))
    val e4 = obj.aplicarMovimiento(e3,Dos(-1))
    assert(e4 == (List('a','b','c'),List('f','g'),List('d','e')))
    val e5 = obj.aplicarMovimiento(e4,Uno(-2))
    assert(e5 == (List('a','b','c','f','g'),List(),List('d','e')))
    val e6 = obj.aplicarMovimiento(e5,Uno(1))
    assert(e6 == (List('a','b','c','f'),List('g'),List('d','e')))
  }
}
