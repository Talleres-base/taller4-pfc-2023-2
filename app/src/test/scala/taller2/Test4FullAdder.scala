package taller2

import org.junit.runner.RunWith
import org.scalatest.funsuite.AnyFunSuiteLike

@RunWith(classOf[org.scalatestplus.junit.JUnitRunner])
class Test4FullAdder extends AnyFunSuiteLike {

  test("testFullAdder") {
    val circuito = new Circuitos
    val chipFullAdder = circuito.fullAdder
    assert(chipFullAdder(List(0,0,0)) == List(0,0))
    assert(chipFullAdder(List(0,0,1)) == List(0,1))
    assert(chipFullAdder(List(0,1,0)) == List(0,1))
    assert(chipFullAdder(List(0,1,1)) == List(1,0))
    assert(chipFullAdder(List(1,0,0)) == List(0,1))
    assert(chipFullAdder(List(1,0,1)) == List(1,0))
    assert(chipFullAdder(List(1,1,0)) == List(1,0))
    assert(chipFullAdder(List(1,1,1)) == List(1,1))
  }

}
