package taller1

/**
 * Created by Carlos Delgado
 * Class for the first point of the assignment one of the course of functional programming
 */
class SizeList {

  /**
   * Method to calculate the size of a list using linear recursion
   * @param l list of integers
   * @return size of the list
   */
  def tamR(l:List[Int]) : Int = {
    if (l.isEmpty) 0
    else 1 + tamR(l.tail)
  }

  /**
   * Method to calculate the size of a list using tail recursion using an auxiliary method
   * @param l list of integers
   * @return size of the list
   */
  def tamI(l:List[Int]) : Int = {
    //Replace code use tamIAux method
    tamIAux(List(), 0)
  }

  /**
   * Auxiliary method to calculate the size of a list using tail recursion
   * @param l list of integers
   * @param n accumulator
   * @return size of the list
   */
  def tamIAux(l:List[Int], n:Int) : Int = {
    //Replace code
    0
  }

}
