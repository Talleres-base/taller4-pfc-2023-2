package taller1

import org.junit.runner.RunWith
import org.scalatest.funsuite.AnyFunSuiteLike
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class SortListTestMayoresMenores extends AnyFunSuiteLike {

  test("testMayoresQueCase1") {
    val testListA = List(10,3,9,12,1,4,3)
    val objSortList = new SortList()
    assert(objSortList.mayoresQue(testListA, 5).toSet == Set(10,9,12))
  }

  test ("testMayoresQueCase2") {
    val testListA = List(10,3,9,12,1,4,3)
    val objSortList = new SortList()
    assert(objSortList.mayoresQue(testListA, 0).toSet == Set(10,3,9,12,1,4,3))
  }

  test ("testMayoresQueCase3") {
    val testListA = List(10,3,9,12,1,4,3)
    val objSortList = new SortList()
    assert(objSortList.mayoresQue(testListA, 12).toSet == Set())
  }

  test ("testMayoresQueCase4") {
    val testListA = List(10,3,9,12,1,4,3)
    val objSortList = new SortList()
    assert(objSortList.mayoresQue(testListA, 1).toSet == Set(10,3,9,12,4,3))
  }

  test("testMenoresQueCase1") {
    val testListA = List(10,3,9,12,1,4,3)
    val objSortList = new SortList()
    assert(objSortList.menoresQue(testListA, 5).toSet == Set(3,1,4,3))

  }

  test ("testMenoresQueCase2") {
    val testListA = List(10,3,9,12,1,4,3)
    val objSortList = new SortList()
    assert(objSortList.menoresQue(testListA, 0).toSet == Set())
  }

  test ("testMenoresQueCase3") {
    val testListA = List(10,3,9,12,1,4,3)
    val objSortList = new SortList()
    assert(objSortList.menoresQue(testListA, 12).toSet == Set(10,3,9,1,4,3))
  }

}
