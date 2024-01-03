/**
 * Clase BuscadorCadenaSecuencial
 */

package taller4
import Trie.ramaValida
import Trie.agregar_secuencias
import Trie.cadenas_del_arbol
import Trie.arbolDeSufijos
import common._
import scala.annotation.tailrec
import scala.collection.parallel.immutable.ParVector
import scala.collection.parallel._
import scala.collection.parallel.CollectionConverters._

/**
 * Clase que define diferentes algoritmos para encontrar una cadena en otra.
 *
 * @param cadenaObjetivo Cadena objetivo a buscar.
 * @param alfabeto Alfabeto de alfabeto disponibles.
 */
class BuscadorCadenaSecuencial(cadenaObjetivo: String, alfabeto: Seq[Char]) {
  // Definición de tipo para el oráculo que verifica la existencia de subcadenas.
  type Oraculo = Seq[Char] => Boolean
  
  // Oráculo que evalúa si una subcadena está presente en la cadena objetivo.
  val oraculo: Oraculo = (subcadena: Seq[Char]) => cadenaObjetivo.contains(subcadena.mkString)
  
  // Longitud de la cadena objetivo.
  val n: Int = cadenaObjetivo.length

  /**
  * Función para generar todas las posibles subcadenas de un n específico a partir de un alfabeto dado.
  *
  * @param alfabeto Alfabeto de alfabeto que componen las subcadenas.
  * @param longitud n de las subcadenas a generar.
  * @return Una secuencia con todas las subcadenas generadas.
  */
  def generarSubcadenas(caracteres: Seq[Char], longitud: Int): Seq[Seq[Char]] = {
    def subcadenasIter(subs: Seq[Seq[Char]], n: Int): Seq[Seq[Char]] = {
      if (n > longitud) subs
      else subcadenasIter(subs.flatMap(subcadena => caracteres.map(subcadena :+ _)), n + 1)
    }
    subcadenasIter(caracteres.map(Seq(_)), 1)
  }

  /**
  * Busca la primera subcadena que coincida con una cadena objetivo, utilizando un enfoque ingenuo.
  *
  * @return Una opción que contiene la primera subcadena encontrada, si existe.
  */
  def ingenua(): Seq[Char] = {
    // Genera todas las posibles subcadenas de longitud n a partir del alfabeto
    val subcadenas = generarSubcadenas(alfabeto, n-1)
    // Busca la primera subcadena que satisfaga el oraculo
    subcadenas.find(oraculo(_)).head
  }

  /**
  * Algoritmo de búsqueda PRC (Pattern Recognition Code) Mejorado.
  *
  * @return Lista de subcadenas encontradas.
  */
  def mejorada(): Seq[Char]  = {
    // Obtiene la longitud de la cadena objetivo
    // Inicializa la lista de subcadenas con las de n 1
    val subcadenas = alfabeto.map(Seq(_))
    // Define una función auxiliar recursiva que busca las subcadenas que satisfacen el oráculo
    def busCadMejoradaAux(sck: Seq[Seq[Char]],oraculo:Oraculo): Seq[Seq[Char]]  = {
      // Si la lista de subcadenas está vacía, devuelve una lista vacía
      if (sck.isEmpty) Seq(Seq()) 
      else {
        // Genera las combinaciones de las subcadenas con el alfabeto y las filtra por el oráculo
        val combinaciones = sck.flatMap(subcadena => alfabeto.map(subcadena :+ _)).filter(oraculo(_))
        // Si alguna de las combinaciones tiene el n deseado, devuelve las combinaciones
        if (combinaciones.exists(_.size == n)) combinaciones
        // Si no, llama recursivamente a la función auxiliar con las combinaciones
        else busCadMejoradaAux(combinaciones,oraculo) 
      }
    }
    // Llama a la función auxiliar con la lista inicial de subcadenas
    busCadMejoradaAux(subcadenas,oraculo).head
  }

  /**
  * Combina dos listas de cadenas generando todas las posibles combinaciones.
  *
  * @param primeraLista Primera lista de cadenas.
  * @param segundaLista Segunda lista de cadenas.
  * @return Lista de todas las combinaciones posibles.
  */
  def combinar_dos_listas(primeraLista: Seq[Seq[Char]], segundaLista: Seq[Seq[Char]]): Seq[Seq[Char]] = { 
    if (primeraLista.isEmpty) Nil 
    else segundaLista.map { cadena => cadena ++ primeraLista.head } ++ combinar_dos_listas(primeraLista.tail, segundaLista)
  }


  /**
  * Algoritmo de búsqueda de subcadenas rápido.
  *
  * @return Lista de subcadenas encontradas.
  */
  def turbo(): Seq[Char] = {
    // Inicializa la lista de subcadenas con las de n 1
    val alfabetoEnForma = alfabeto.map(Seq(_))
    // Define una función auxiliar recursiva que busca las subcadenas que satisfacen el oráculo
    def buscarSubcadenasRapidoAux(sck: Seq[Seq[Char]], n: Int,combinacion_pasada: Seq[Seq[Char]]): Seq[Seq[Char]]  = {
      if (sck.head.size + 1 == n) {
        val uniones = combinar_dos_listas(sck, sck.flatten.distinct.map(Seq(_)))
        uniones.filter(oraculo(_))
      } else if (sck.head.size >= n) sck
      else if( sck.head.size * 2 > n)  {
        val uniones = combinar_dos_listas(sck, combinacion_pasada).filter(oraculo(_))
        buscarSubcadenasRapidoAux(uniones, n,sck) 
      }
      else {
        val uniones = combinar_dos_listas(sck, sck).filter(oraculo(_))
        buscarSubcadenasRapidoAux(uniones, n,sck) 
      }
    }
    if (n == 1) alfabetoEnForma.filter(oraculo(_)).head
    else if (n % 2 == 0) {
      val sub_alfabetoEnForma = buscarSubcadenasRapidoAux(alfabetoEnForma, n / 2,Seq())
      val uniones = combinar_dos_listas(sub_alfabetoEnForma, sub_alfabetoEnForma).filter(oraculo(_))
      uniones.head
    } 
    else {
      val cadenas1 = buscarSubcadenasRapidoAux(alfabetoEnForma, n / 2,Seq())
      val cadenas2 = buscarSubcadenasRapidoAux(alfabetoEnForma, n - (n / 2),Seq())
      val uniones = combinar_dos_listas(cadenas1, cadenas2).filter(oraculo(_))
      uniones.head
    }
  }


  /**
  * Filtra las cadenas que cumplen con ciertas condiciones.
  *
  * @param cadena Cadena a filtrar.
  * @param subcadenas Lista de subcadenas.
  * @param n Longitud de subcadena a verificar.
  * @return Booleano que indica si la cadena cumple con las condiciones.
  */
  def filtro_cadenas(cadena: Seq[Char], subcadenas: Seq[Seq[Char]], n: Int): Boolean = {
    // Define una función auxiliar recursiva que verifica si una cadena está contenida en una lista de subcadenas
    def contiene(cadena: Seq[Char], subcadenas: Seq[Seq[Char]]): Boolean = {
      if (subcadenas.isEmpty) false
      else if (subcadenas.head == cadena) true
      else contiene(cadena, subcadenas.tail)
    }
    // Si la cadena tiene el mismo n que el deseado, verifica si está contenida en la lista de subcadenas
    if (cadena.length == n) contiene(cadena.take(n), subcadenas)
    // Si no, toma una subcadena del mismo n y verifica si está contenida, y luego llama recursivamente a la función con el resto de la cadena
    else {
      val segmento = cadena.take(n)
      if (contiene(segmento, subcadenas)) filtro_cadenas(cadena.tail, subcadenas, n)
      else false
    } 
  } 

  /**
  * Algoritmo de búsqueda de subcadenas turbo mejorado.
  *
  * @return Lista de subcadenas encontradas.
  */
  def turboMejorada(): Seq[Char]  = {
    // Define una función auxiliar recursiva que busca las subcadenas que satisfacen el oráculo
    def turboMejoradaAux(sck: Seq[Seq[Char]], n: Int, secuanciaPasada: Seq[Seq[Char]]): Seq[Seq[Char]]  = {
      if (sck.head.size + 1 == n) {
        val mezclas = combinar_dos_listas(sck, sck.flatten.distinct.map(Seq(_)))
        mezclas.filter(oraculo(_))
      } else if (sck.head.size >= n) sck
      else if( sck.head.size * 2 > n)  {
        val mezclas = combinar_dos_listas(sck, secuanciaPasada).filter(filtro_cadenas(_, secuanciaPasada, secuanciaPasada.head.size)).filter(oraculo(_))
        turboMejoradaAux(mezclas, n,sck) 
      }
      else {
        val mezclas = combinar_dos_listas(sck, sck).filter(filtro_cadenas(_, sck, sck.head.size)).filter(oraculo(_))
        turboMejoradaAux(mezclas,n,sck) 
      }
    }
    val alfabetoEnForma = alfabeto.map(Seq(_))
    // Si el n es 1, filtra los alfabeto por el oráculo
    if (n == 1) alfabetoEnForma.filter(oraculo(_)).head
    // Si el n es par, busca los alfabeto de la mitad del n y luego los combina
    else if (n % 2 == 0) {
      val sub_alfabeto = turboMejoradaAux(alfabetoEnForma, n / 2,Seq())
      val mezclas = combinar_dos_listas(sub_alfabeto, sub_alfabeto).filter(oraculo(_))
      mezclas.head
    // Si el n es impar, busca los alfabeto de la mitad superior e inferior del n y luego los combina
    } else {
      val cadenas1 = turboMejoradaAux(alfabetoEnForma, n / 2,Seq())
      val cadenas2 = turboMejoradaAux(alfabetoEnForma, n-(n/2),Seq())
      val mezclas = combinar_dos_listas(cadenas1, cadenas2).filter(oraculo(_))
      mezclas.head
    }
  }

  /**
  * Algoritmo de búsqueda de subcadenas turbo acelerada.
  *
  * @return Lista de subcadenas encontradas.
  */
  def turboAcelerada(): Seq[Char] = {
  /**
    * Función auxiliar que realiza la reconstrucción de secuencias en paralelo.
    *
    * @param arbol Arbol de sufijos.
    * @param secuencias Secuencias a combinar_dos_listas.
    * @param acumulada Secuencia acumulada.
    * @return Arbol de sufijos actualizado.
    */

    def turboAceleradaAux(t: Trie, secuencias: Seq[Seq[Char]], acumulada: Seq[Char]): Trie = {
        t match {
          case Nodo(valor, esFinal, hijos) =>
            val nuevosHijos = hijos.map { hijo =>
              if (ramaValida(hijo)) turboAceleradaAux(hijo, secuencias, acumulada :+ valor)
              else hijo
            }
            Nodo(valor, esFinal, nuevosHijos)
          case Hoja(valor, esFinal) =>
            if (!esFinal) Nodo(valor, esFinal, List())
            else {
              val cadenasNuevas: Seq[Seq[Char]] = secuencias.map(cadena => (acumulada.filter(_ != ' ') :+ valor) ++ cadena).filter(filtro_cadenas(_, secuencias, secuencias.head.size)).filter(oraculo(_))
              if (cadenasNuevas.isEmpty) Nodo(valor, esFinal, List())
              else {
                agregar_secuencias(cadenasNuevas.map(_.drop((acumulada.filter(_ != ' ') :+ valor).length)), t)
              }
            }
      }
    }

    /**
      * Función auxiliar evaluar_arbol que evalúa y actualiza el árbol de sufijos.
      *
      * @param arbol Arbol de sufijos.
      * @param n Longitud de las secuencias.
      * @return Seq[Seq[Char]] Secuencias encontradas que cumplen con el oráculo.
      */
    def evaluar_arbol(arbol: Trie, n: Int,combinacion_pasada: Seq[Seq[Char]]): Seq[Seq[Char]] = {
      val todas_secuencias_arbol = cadenas_del_arbol(arbol)
      if (todas_secuencias_arbol.isEmpty) Seq(Seq())
      else if (todas_secuencias_arbol.head.length + 1 == n) {
        combinar_dos_listas(todas_secuencias_arbol, alfabeto.map(Seq(_))).filter(oraculo(_))
      }
      else if (todas_secuencias_arbol.head.size == n) todas_secuencias_arbol
      else if( todas_secuencias_arbol.head.size * 2 > n)  {
        val arbol_nuevo = turboAceleradaAux(arbol, combinacion_pasada, Seq())
        evaluar_arbol(arbol_nuevo,n,todas_secuencias_arbol)
      }
      else {
        val arbolNuevo = turboAceleradaAux(arbol, todas_secuencias_arbol, Seq())
        evaluar_arbol(arbolNuevo,n,todas_secuencias_arbol)
      }
    }
    val arbol_inicial = arbolDeSufijos(alfabeto.map(cadena => Seq(cadena)))
    if (n % 2 == 0) {
      val sub_cadenas = evaluar_arbol(arbol_inicial, n / 2,Seq())
      val mezclas = combinar_dos_listas(sub_cadenas, sub_cadenas).filter(oraculo(_))
      mezclas.head
    } else {
      val c1 = evaluar_arbol(arbol_inicial,n/2,Seq())
      val c2 = evaluar_arbol(arbol_inicial,n-(n/2),Seq())
      val mezclas = combinar_dos_listas(c1, c2).filter(oraculo(_))
      mezclas.head
    }
  }

}


  

