package taller2

import org.junit.runner.RunWith
import org.scalatest.funsuite.AnyFunSuiteLike

@RunWith(classOf[org.scalatestplus.junit.JUnitRunner])
class Test1CircuitoUnarioTest extends AnyFunSuiteLike {

  test("testCrearChipUnario") {
    val circuitos = new Circuitos
    val chip = circuitos.crearChipUnario(x => 1 - x)
    assert(chip(List(1)) == List(0))
    assert(chip(List(0)) == List(1))
  }

}
