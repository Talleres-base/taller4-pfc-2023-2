package taller1

import org.junit.runner.RunWith
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class SortListTestKElemento extends AnyFunSuiteLike {

  test("testK_elementoCase1") {
    val testListA = List(10,3,9,12,1,4,2)
    val objSortList = new SortList()
    assert(objSortList.k_elemento(testListA, 4) == 4)
  }

  test ("testK_elementoCase2") {
    val testListA = List(10,3,9,12,1,4,2,-1,-3,-5,-7,-9)
    val objSortList = new SortList()
    assert(objSortList.k_elemento(testListA, 1) == -9)
  }

  test ("testK_elementoCase3") {
    val testListA = List(12,3,9,10,1,4,2,-3)
    val objSortList = new SortList()
    assert(objSortList.k_elemento(testListA, 7) == 10)
  }

  test ("testK_elementoCase4") {
    val testListA = List(43,12,3,9,10,1,4,2,-3,-5,-7,-9)
    val objSortList = new SortList()
    assert(objSortList.k_elemento(testListA, 3) == -5)
  }


}
