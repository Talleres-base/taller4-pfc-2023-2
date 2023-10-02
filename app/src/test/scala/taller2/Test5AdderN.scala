package taller2

import org.junit.runner.RunWith
import org.scalatest.funsuite.AnyFunSuiteLike

@RunWith(classOf[org.scalatestplus.junit.JUnitRunner])
class Test5AdderN extends AnyFunSuiteLike {

  test("testAdderN1") {
    val circuito = new Circuitos
    val chipnAdder  = circuito.adder(1)
    assert(chipnAdder(List(0) ++ List(0)) == List(0,0))
    assert(chipnAdder(List(0) ++ List(1)) == List(0,1))
    assert(chipnAdder(List(1) ++ List(0)) == List(0,1))
    assert(chipnAdder(List(1) ++ List(1)) == List(1,0))
  }

  test ("testAdderN2") {
    val circuito = new Circuitos
    val chipnAdder = circuito.adder(2)
    assert(chipnAdder(List(0, 0) ++ List(0, 0)) == List(0, 0, 0))
    assert(chipnAdder(List(0, 0) ++ List(0, 1)) == List(0, 0, 1))
    assert(chipnAdder(List(0, 0) ++ List(1, 0)) == List(0, 1, 0))
    assert(chipnAdder(List(0, 0) ++ List(1, 1)) == List(0, 1, 1))
    assert(chipnAdder(List(0, 1) ++ List(0, 0)) == List(0, 0, 1))
    assert(chipnAdder(List(0, 1) ++ List(0, 1)) == List(0, 1, 0))
    assert(chipnAdder(List(0, 1) ++ List(1, 0)) == List(0, 1, 1))
    assert(chipnAdder(List(0, 1) ++ List(1, 1)) == List(1, 0, 0))
    assert(chipnAdder(List(1, 0) ++ List(0, 0)) == List(0, 1, 0))
    assert(chipnAdder(List(1, 0) ++ List(0, 1)) == List(0, 1, 1))
    assert(chipnAdder(List(1, 0) ++ List(1, 0)) == List(1, 0, 0))
    assert(chipnAdder(List(1, 0) ++ List(1, 1)) == List(1, 0, 1))
    assert(chipnAdder(List(1, 1) ++ List(0, 0)) == List(0, 1, 1))
    assert(chipnAdder(List(1, 1) ++ List(0, 1)) == List(1, 0, 0))
    assert(chipnAdder(List(1, 1) ++ List(1, 0)) == List(1, 0, 1))
    assert(chipnAdder(List(1, 1) ++ List(1, 1)) == List(1, 1, 0))

  }

  test("testAdderN3") {
    val circuitos = new Circuitos
    val chipnAdder = circuitos.adder(3)
    assert(chipnAdder(List(0, 0, 0) ++ List(0, 0, 0)) == List(0, 0, 0, 0))
    assert(chipnAdder(List(0, 0, 0) ++ List(0, 0, 1)) == List(0, 0, 0, 1))
    assert(chipnAdder(List(0, 0, 0) ++ List(0, 1, 0)) == List(0, 0, 1, 0))
    assert(chipnAdder(List(0, 0, 0) ++ List(0, 1, 1)) == List(0, 0, 1, 1))
    assert(chipnAdder(List(0, 0, 0) ++ List(1, 0, 0)) == List(0, 1, 0, 0))
    assert(chipnAdder(List(0, 0, 0) ++ List(1, 0, 1)) == List(0, 1, 0, 1))
    assert(chipnAdder(List(0, 0, 0) ++ List(1, 1, 0)) == List(0, 1, 1, 0))
    assert(chipnAdder(List(0, 0, 0) ++ List(1, 1, 1)) == List(0, 1, 1, 1))
    assert(chipnAdder(List(0, 0, 1) ++ List(0, 0, 0)) == List(0, 0, 0, 1))
    assert(chipnAdder(List(0, 0, 1) ++ List(0, 0, 1)) == List(0, 0, 1, 0))
    assert(chipnAdder(List(0, 0, 1) ++ List(0, 1, 0)) == List(0, 0, 1, 1))
    assert(chipnAdder(List(0, 0, 1) ++ List(0, 1, 1)) == List(0, 1, 0, 0))
    assert(chipnAdder(List(0, 0, 1) ++ List(1, 0, 0)) == List(0, 1, 0, 1))
    assert(chipnAdder(List(0, 0, 1) ++ List(1, 0, 1)) == List(0, 1, 1, 0))
    assert(chipnAdder(List(0, 0, 1) ++ List(1, 1, 0)) == List(0, 1, 1, 1))
    assert(chipnAdder(List(0, 0, 1) ++ List(1, 1, 1)) == List(1, 0, 0, 0))
    assert(chipnAdder(List(0, 1, 0) ++ List(0, 0, 0)) == List(0, 0, 1, 0))
    assert(chipnAdder(List(0, 1, 0) ++ List(0, 0, 1)) == List(0, 0, 1, 1))
    assert(chipnAdder(List(0, 1, 0) ++ List(0, 1, 0)) == List(0, 1, 0, 0))
    assert(chipnAdder(List(0, 1, 0) ++ List(0, 1, 1)) == List(0, 1, 0, 1))
    assert(chipnAdder(List(0, 1, 0) ++ List(1, 0, 0)) == List(0, 1, 1, 0))
    assert(chipnAdder(List(0, 1, 0) ++ List(1, 0, 1)) == List(0, 1, 1, 1))
    assert(chipnAdder(List(0, 1, 0) ++ List(1, 1, 0)) == List(1, 0, 0, 0))
    assert(chipnAdder(List(0, 1, 0) ++ List(1, 1, 1)) == List(1, 0, 0, 1))
    assert(chipnAdder(List(0, 1, 1) ++ List(0, 0, 0)) == List(0, 0, 1, 1))
    assert(chipnAdder(List(0, 1, 1) ++ List(0, 0, 1)) == List(0, 1, 0, 0))
    assert(chipnAdder(List(0, 1, 1) ++ List(0, 1, 0)) == List(0, 1, 0, 1))
    assert(chipnAdder(List(0, 1, 1) ++ List(0, 1, 1)) == List(0, 1, 1, 0))
    assert(chipnAdder(List(0, 1, 1) ++ List(1, 0, 0)) == List(0, 1, 1, 1))
    assert(chipnAdder(List(0, 1, 1) ++ List(1, 0, 1)) == List(1, 0, 0, 0))
    assert(chipnAdder(List(0, 1, 1) ++ List(1, 1, 0)) == List(1, 0, 0, 1))
    assert(chipnAdder(List(0, 1, 1) ++ List(1, 1, 1)) == List(1, 0, 1, 0))
    assert(chipnAdder(List(1, 0, 0) ++ List(0, 0, 0)) == List(0, 1, 0, 0))
    assert(chipnAdder(List(1, 0, 0) ++ List(0, 0, 1)) == List(0, 1, 0, 1))
    assert(chipnAdder(List(1, 0, 0) ++ List(0, 1, 0)) == List(0, 1, 1, 0))
    assert(chipnAdder(List(1, 0, 0) ++ List(0, 1, 1)) == List(0, 1, 1, 1))
    assert(chipnAdder(List(1, 0, 0) ++ List(1, 0, 0)) == List(1, 0, 0, 0))
    assert(chipnAdder(List(1, 0, 0) ++ List(1, 0, 1)) == List(1, 0, 0, 1))
    assert(chipnAdder(List(1, 0, 0) ++ List(1, 1, 0)) == List(1, 0, 1, 0))
    assert(chipnAdder(List(1, 0, 0) ++ List(1, 1, 1)) == List(1, 0, 1, 1))
    assert(chipnAdder(List(1, 0, 1) ++ List(0, 0, 0)) == List(0, 1, 0, 1))
    assert(chipnAdder(List(1, 0, 1) ++ List(0, 0, 1)) == List(0, 1, 1, 0))
    assert(chipnAdder(List(1, 0, 1) ++ List(0, 1, 0)) == List(0, 1, 1, 1))
    assert(chipnAdder(List(1, 0, 1) ++ List(0, 1, 1)) == List(1, 0, 0, 0))
    assert(chipnAdder(List(1, 0, 1) ++ List(1, 0, 0)) == List(1, 0, 0, 1))
    assert(chipnAdder(List(1, 0, 1) ++ List(1, 0, 1)) == List(1, 0, 1, 0))
    assert(chipnAdder(List(1, 0, 1) ++ List(1, 1, 0)) == List(1, 0, 1, 1))
    assert(chipnAdder(List(1, 0, 1) ++ List(1, 1, 1)) == List(1, 1, 0, 0))
    assert(chipnAdder(List(1, 1, 0) ++ List(0, 0, 0)) == List(0, 1, 1, 0))
    assert(chipnAdder(List(1, 1, 0) ++ List(0, 0, 1)) == List(0, 1, 1, 1))
    assert(chipnAdder(List(1, 1, 0) ++ List(0, 1, 0)) == List(1, 0, 0, 0))
    assert(chipnAdder(List(1, 1, 0) ++ List(0, 1, 1)) == List(1, 0, 0, 1))
    assert(chipnAdder(List(1, 1, 0) ++ List(1, 0, 0)) == List(1, 0, 1, 0))
    assert(chipnAdder(List(1, 1, 0) ++ List(1, 0, 1)) == List(1, 0, 1, 1))
    assert(chipnAdder(List(1, 1, 0) ++ List(1, 1, 0)) == List(1, 1, 0, 0))
    assert(chipnAdder(List(1, 1, 0) ++ List(1, 1, 1)) == List(1, 1, 0, 1))
    assert(chipnAdder(List(1, 1, 1) ++ List(0, 0, 0)) == List(0, 1, 1, 1))
    assert(chipnAdder(List(1, 1, 1) ++ List(0, 0, 1)) == List(1, 0, 0, 0))
    assert(chipnAdder(List(1, 1, 1) ++ List(0, 1, 0)) == List(1, 0, 0, 1))
    assert(chipnAdder(List(1, 1, 1) ++ List(0, 1, 1)) == List(1, 0, 1, 0))
    assert(chipnAdder(List(1, 1, 1) ++ List(1, 0, 0)) == List(1, 0, 1, 1))
    assert(chipnAdder(List(1, 1, 1) ++ List(1, 0, 1)) == List(1, 1, 0, 0))
    assert(chipnAdder(List(1, 1, 1) ++ List(1, 1, 0)) == List(1, 1, 0, 1))
    assert(chipnAdder(List(1, 1, 1) ++ List(1, 1, 1)) == List(1, 1, 1, 0))
  }

  test("adderN8") {
    val circuitos = new Circuitos
    val chipnAdder = circuitos.adder(8)
    assert(chipnAdder(List(0, 0, 0, 0, 0, 0, 0, 0) ++ List(0, 0, 0, 0, 0, 0, 0, 0)) == List(0, 0, 0, 0, 0, 0, 0, 0, 0))
    assert(chipnAdder(List(0, 0, 1, 1, 0, 0, 0, 1) ++ List(0, 1, 1, 0, 0, 1, 0, 1)) == List(0, 1, 0, 0, 1, 0, 1, 1, 0))
    assert(chipnAdder(List(1, 0, 1, 1, 0, 0, 0, 1) ++ List(0, 1, 1, 0, 0, 1, 0, 1)) == List(1, 0, 0, 0, 1, 0, 1, 1, 0))
    assert(chipnAdder(List(1, 0, 1, 1, 0, 0, 0, 1) ++ List(1, 1, 1, 0, 0, 1, 0, 1)) == List(1, 1, 0, 0, 1, 0, 1, 1, 0))
  }


}
