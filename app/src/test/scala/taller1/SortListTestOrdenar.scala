package taller1

import org.junit.runner.RunWith
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class SortListTestOrdenar extends AnyFunSuiteLike {

  test("testOrdenarCase1") {
    val testListA = List(10,3,9,12,1,4,2)
    val objSortList = new SortList()
    assert(objSortList.ordenar(testListA) == List(1,2,3,4,9,10,12))
  }

  test ("testOrdenarCase2") {
    val testListA = List(10,2,9,12,1,4,3,5,6,7,8,15,-1)
    val objSortList = new SortList()
    assert(objSortList.ordenar(testListA) == List(-1,1,2,3,4,5,6,7,8,9,10,12,15))
  }

  test ("testOrdenarCase3") {
    val testListA = List(3,7,1,0,-1,-4,-5,10,13,22,2)
    val objSortList = new SortList()
    assert(objSortList.ordenar(testListA) == List(-5,-4,-1,0,1,2,3,7,10,13,22))
  }

  test ("testOrdenarCase4") {
    val testListA = List(10,-3,9,12,1,4,3,0,5,6,7,8,15,-1,11,13,14,16,17,18,19,2)
    val objSortList = new SortList()
    assert(objSortList.ordenar(testListA) == List(-3,-1,0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19))
  }

}
