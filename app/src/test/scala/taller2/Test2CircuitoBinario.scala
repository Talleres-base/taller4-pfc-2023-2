package taller2

import org.junit.runner.RunWith
import org.scalatest.funsuite.AnyFunSuiteLike

@RunWith(classOf[org.scalatestplus.junit.JUnitRunner])
class Test2CircuitoBinario extends AnyFunSuiteLike {

  test("circuitoAnd")
  {
    val circuito = new Circuitos
    val chipAnd = circuito.crearChipBinario((x,y) => x*y)
    assert(chipAnd(List(0,0)) == List(0))
    assert(chipAnd(List(0,1)) == List(0))
    assert(chipAnd(List(1,0)) == List(0))
    assert(chipAnd(List(1,1)) == List(1))
  }

  test("circuitoOr")
  {
    val circuito = new Circuitos
    val chipOr = circuito.crearChipBinario((x,y) => x+y-(x*y))
    assert(chipOr(List(0,0)) == List(0))
    assert(chipOr(List(0,1)) == List(1))
    assert(chipOr(List(1,0)) == List(1))
    assert(chipOr(List(1,1)) == List(1))
  }

  test("CircuitoXOR") {
    val circuito = new Circuitos
    val chipXor = circuito.crearChipBinario((x,y) => x+y-2*(x*y))
    assert(chipXor(List(0,0)) == List(0))
    assert(chipXor(List(0,1)) == List(1))
    assert(chipXor(List(1,0)) == List(1))
    assert(chipXor(List(1,1)) == List(0))
  }

}
