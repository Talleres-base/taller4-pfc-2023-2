package taller1

import org.junit.runner.RunWith
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class SizeListTest extends AnyFunSuiteLike {

  test("testTamRCase1") {
      val testListA = List(1,2,3,4,5)
      val objSizeList = new SizeList()
      assert(objSizeList.tamR(testListA) == 5)
  }

  test("testTamRCase2") {
      val testListA = List(1,2,3,4,5,6,7,8,9,10)
      val objSizeList = new SizeList()
      assert(objSizeList.tamR(testListA) == 10)
  }

  test("testTamICase1") {
      val testListA = List(1,2,3,4,5)
      val objSizeList = new SizeList()
      assert(objSizeList.tamI(testListA) == 5)
  }

  test("testTamICase2") {
      val testListA = List(1,2,3,4,5,6,7,8,9,10)
      val objSizeList = new SizeList()
      assert(objSizeList.tamI(testListA) == 10)
  }

  test("testTamIAuxCase1") {
      val testListA = List(1,2,3,4,5)
      val objSizeList = new SizeList()
      assert(objSizeList.tamIAux(testListA, 0) == 5)
  }

  test ("testTamIAuxCase2") {
      val testListA = List(1,2,3,4,5,6,7,8,9,10)
      val objSizeList = new SizeList()
      assert(objSizeList.tamIAux(testListA, 4) == 14)
  }

  test ("testTamIAuxCase3") {
      val testListA = List(1,2,3,4,5,6,7,8,9,10)
      val objSizeList = new SizeList()
      assert(objSizeList.tamIAux(testListA, 10) == 20)
  }

}
