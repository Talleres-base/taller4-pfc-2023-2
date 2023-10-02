package taller2

import scala.annotation.tailrec

/**
 * Clase para implementar circuitos combinacionales usando funciones de alto orden
 */
class Circuitos {
    /**
    * Tipo chip
     */
    type Chip = List[Int] => List[Int]

  /**
   * Primer punto del Taller
   * Chips básicos
   */

  /**
   * Método para crear un chip unario
   * @param f función que implementa el chip
   * @return chip unario
   */
    def crearChipUnario(f: Int => Int): Chip = {
      (entrada: List[Int]) => f(entrada.head) :: Nil
    }

  /**
   * Método para crear un chip binario
   * @param f función que implementa el chip
   * @return chip binario
   */
    def crearChipBinario(f: (Int, Int) => Int): Chip = {
      (entrada: List[Int]) => {
        //Borrar la siguient linea y completar
        List()
      }
    }

  /**
   * Segundo punto del taller
   * Chips compuestos
   */

  /**
   * Semisumador half-adder
   * @return chip semisumador
   */
    def halfAdder: Chip = {
      (entrada: List[Int]) => {
        //Borrar la siguient linea y completar
        List()
      }
    }

  /**
   * Sumador completo full-adder
   * @return chip sumador completo
   */
    def fullAdder: Chip = {
      (entrada: List[Int]) => {
        //Borrar la siguient linea y completar
        Nil
      }
    }

  /**
   * Sumador de n bits addr
   * @param n número de bits
   * @return chip
   */
  def adder(n:Int) : Chip = {
    (entrada: List[Int]) => {
      @tailrec
      def adderAux(entrada:List[Int], n:Int, c:Int, res:List[Int]): List[Int] = {
        //Borrar las siguientes lineas y completar funcion, no tocar @tailrec
        if (n==0)
          List()
        else
          adderAux(entrada, n-1, 0, List())
        }
      adderAux(entrada,n, 0, List())
    }
  }

}
