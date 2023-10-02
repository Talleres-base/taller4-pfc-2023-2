package taller2

import org.junit.runner.RunWith
import org.scalatest.funsuite.AnyFunSuiteLike

@RunWith(classOf[org.scalatestplus.junit.JUnitRunner])
class Test3HalfAdder extends AnyFunSuiteLike {

  test("testHalfAdder") {
    val circuito = new Circuitos
    val chipHalfAdder = circuito.halfAdder
    assert(chipHalfAdder(List(0,0)) == List(0,0))
    assert(chipHalfAdder(List(0,1)) == List(0,1))
    assert(chipHalfAdder(List(1,0)) == List(0,1))
    assert(chipHalfAdder(List(1,1)) == List(1,0))
  }

}
