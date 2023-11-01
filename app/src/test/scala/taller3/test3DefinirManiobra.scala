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
    val movs = obj.definirManiobra(t1,t2)
    val ei = (t1,List(),List())
    val tf = obj.aplicarMovimientos(ei,movs).last //Estado final obtenido
    val ef = (t2,List(),List()) //Estado final esperado
    assert(tf == ef)
  }

  test("Prueba2") {
    val obj = new ManiobrasTrenes()
    val t1 = List('a','b','c','d','e','f','g','h','i','j')
    val t2 = List('j','h','i','g','e','f','d','c','a','b')
    val movs = obj.definirManiobra(t1,t2)
    val ei = (t1,List(),List())
    val tf = obj.aplicarMovimientos(ei,movs).last //Estado final obtenido
    val ef = (t2,List(),List()) //Estado final esperado
    assert(tf == ef)
  }
}
