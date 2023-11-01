/**
 * Clase Maniobrastrenes
 */
package taller3

import scala.annotation.tailrec

class ManiobrasTrenes {
  type Vagon = Any
  type Tren = List[Vagon]
  type Estado = (Tren,Tren,Tren)
  type Maniobra = List[Movimiento]
  /**
      * Aplicar movimiento
      * @param e:Estado estado actual
      * @param m:Movimiento movimiento a aplicar
      * @return Estado estado resultante
      */

    def aplicarMovimiento(e:Estado,m:Movimiento):Estado = {
      (List(),List(),List()) //Borrar
    }
  /**
    * Aplicar movimientos usando recursión de cola
    * @param e:Estado estado actual
    * @param movs: Lista de movimientos a aplicar
    * @return List[Estado] lista de estados resultantes
    */
  def aplicarMovimientos(e:Estado,movs:Maniobra):List[Estado] = {
    @tailrec
    def aplicarMovimientosAux(movs:Maniobra, acc:List[Estado]):List[Estado] = {
      if (movs.isEmpty) acc
      else 
  	  	aplicarMovimientosAux(List(), acc) //Borrar y cambiar (asi esta para que compile)
  	}
	  aplicarMovimientosAux(movs, List(e))
  }
  /**
    * Maniobras para llegar de un tren t1 a un tren t2
    * @param t1:Tren tren inicial
    * @param t2:Tren tren final
    * @return Maniobra lista de movimientos
    */
  def definirManiobra(t1:Tren,t2:Tren):Maniobra = {
    List(Uno(0)) //Borrar
  }


}
