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
    val esperado = List((List('a', 'b'), List('c'), List('d')), (List('a'), List('b', 'c'), List('d')), (List(), List('b', 'c'), List('a', 'd')), (List('b', 'c'), List(), List('a', 'd')))
    assert(esperado == res) 
  }

  test("Prueba2") {
    val obj = new ManiobrasTrenes()
    val e = (List('a','b','c'),List('e','f'),List('g','h','j'))
    val movs = List(Uno(1),Dos(3),Uno(-3),Dos(-1),Uno(1),Dos(1),Uno(-1),Dos(2),Uno(2))
    val res = obj.aplicarMovimientos(e,movs)
    val esperado = List((List('a', 'b', 'c'), List('e', 'f'), List('g', 'h', 'j')), (List('a', 'b'), List('c', 'e', 'f'), List('g', 'h', 'j')), (List(), List('c', 'e', 'f'), List('a', 'b', 'g', 'h', 'j')), (List('c', 'e', 'f'), List(), List('a', 'b', 'g', 'h', 'j')), (List('c', 'e', 'f', 'a'), List(), List('b', 'g', 'h', 'j')), (List('c', 'e', 'f'), List('a'), List('b', 'g', 'h', 'j')), (List('c', 'e'), List('a'), List('f', 'b', 'g', 'h', 'j')), (List('c', 'e', 'a'), List(), List('f', 'b', 'g', 'h', 'j')), (List('c'), List(), List('e', 'a', 'f', 'b', 'g', 'h', 'j')), (List(), List('c'), List('e', 'a', 'f', 'b', 'g', 'h', 'j')))
    assert(esperado == res)
  }

}
