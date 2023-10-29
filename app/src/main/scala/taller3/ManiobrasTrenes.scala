/**
 * Clase Maniobrastrenes
 */

package taller3

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
    * Aplicar movimientos
    * @param e:Estado estado actual
    * @param movs: Lista de movimientos a aplicar
    * @return List[Estado] lista de estados resultantes
    */
  def aplicarMovimientos(e:Estado,movs:List[Movimiento]):List[Estado] = {
    List((List(),List(),List())) //Borrar
  }
  /**
    * Lista de maniobras para llegar de un tren t1 a un tren t2
    * @param t1:Tren tren inicial
    * @param t2:Tren tren final
    * @return List[Maniobra] lista de maniobras
    */
  def definirManiobra(t1:Tren,t2:Tren):List[Maniobra] = {
    List(List()) //Borrar
  }


}
