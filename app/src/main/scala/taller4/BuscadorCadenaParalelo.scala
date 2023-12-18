/**
 * Clase BuscadorCadenaSecuencial
 */

package taller4
import Trie.ramaValida
import Trie.agregar_secuenciasPar
import Trie.cadenas_del_arbolPar
import Trie.arbolDeSufijosPar
import Trie.cadenas_del_arbol
import Trie.pertenece
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
class BuscadorCadenaParalelo(cadenaObjetivo: String, alfabeto: Seq[Char]) {
  // Definición de tipo para el oráculo que verifica la existencia de subcadenas.
  type Oraculo = Seq[Char] => Boolean
  
  // Oráculo que evalúa si una subcadena está presente en la cadena objetivo.
  val oraculo: Oraculo = (subcadena: Seq[Char]) => cadenaObjetivo.contains(subcadena.mkString)
  
  // Longitud de la cadena objetivo.
  val n: Int = cadenaObjetivo.length
  val alfabetoForma: ParVector[Seq[Char]] = ParVector(alfabeto.map(Seq(_)): _*)


  /**
  * Función para generar todas las posibles subcadenas de un n específico a partir de un alfabeto dado.
  *
  * @param alfabeto Alfabeto de alfabeto que componen las subcadenas.
  * @param longitud n de las subcadenas a generar.
  * @return Una secuencia con todas las subcadenas generadas.
  */
  def generarSubcadenasParalelo(caracteres: Seq[Char], longitud: Int): ParVector[Seq[Char]] = {
    def subcadenasIter(subs: ParVector[Seq[Char]], n: Int): ParVector[Seq[Char]] = {
      if (n > longitud) subs
      else subcadenasIter(subs.flatMap(subcadena => caracteres.map(subcadena :+ _)), n + 1)
    }
    subcadenasIter(alfabetoForma, 1)
  }


  
  /**
  * Función paralela que busca una secuencia de un n dado que cumpla con el oráculo.
  *
  * @return Option[Seq[Char]]: La primera secuencia encontrada que cumpla con el oráculo, o None si no hay ninguna.
  */
  // Cambia el nombre de la función de PRC_IngenuoPar a buscarSecuenciaParalelo
  def ingenua(): Seq[Char] = {
    //val alfabetoForma = alfabeto.map(cadena => Seq(cadena))
    // Genera todas las combinaciones posibles de n n-1 con el alfabeto
    //val resultado = generarSubcadenasParalelo(alfabeto, n - 1)
    val subcadenas = generarSubcadenasParalelo(alfabeto, n-1)
    // Busca la primera subcadena que satisfaga el oraculo
    subcadenas.find(oraculo(_)).head
  }



  /**
  * Función paralela que busca secuencias mejoradas de un n dado que cumplan con el oráculo.
  *
  * @param n n deseado de las secuencias a buscar.
  * @param oraculo El oráculo que evalúa si una secuencia está presente en la cadena objetivo.
  * @return Seq[Seq[Char]]: Conjunto de secuencias encontradas que cumplen con el oráculo.
  */
  // Cambia el nombre de la función de PRC_MejoradoPar a buscarSecuenciasMejoradasPar
  def mejorada(): Seq[Char] = {
    // Función auxiliar que busca secuencias mejoradas a partir de una lista de subsecuencias
    def buscarSecuenciasMSubs(subsecuencias: ParVector[Seq[Char]]): ParVector[Seq[Char]] = {
      // Agrega un caracter del alfabeto a cada subsecuencia y filtra las que cumplan con el oráculo
      //val c1 = combinar(subsecuencias.take(n / 2), Seq('a', 'c', 'g', 't').map(Seq(_))).find(oraculo(_))
      val c1 = subsecuencias.flatMap(subcadena => alfabeto.map(subcadena :+ _)).filter(oraculo(_))
      // Devuelve la primera secuencia encontrada, o una secuencia vacía si no hay ninguna
      if (c1.nonEmpty) c1 else ParVector(Seq())
    }

    // Función auxiliar que busca secuencias mejoradas a partir de una lista de secuencias
    def buscarSecuenciasMejoradasAux(secuencias: ParVector[Seq[Char]]): Seq[Char] = {
      // Si la lista de secuencias está vacía, devuelve una secuencia vacía
      if (secuencias.head.isEmpty) Seq()
      else {
        // Une las secuencias encontradas
        val total = buscarSecuenciasMSubs(secuencias)
        // Si hay alguna secuencia de n n, devuelve el conjunto de secuencias
        if (total.filter(_.size == n).nonEmpty) total.head
        // Si no, llama recursivamente a la función auxiliar con el conjunto de secuencias
        else buscarSecuenciasMejoradasAux(total)
      }
    }
    // Llama a la función auxiliar con la lista de secuencias
    buscarSecuenciasMejoradasAux(alfabetoForma)
  }
  /**
  * Combina dos listas de cadenas generando todas las posibles combinaciones. 
  * usando paralelismo con ParVector
  * @param primeraLista Primera lista de cadenas.
  * @param segundaLista Segunda lista de cadenas.
  * @return Lista de todas las combinaciones posibles.
  */
  def combinar_dos_listas_paralelo(primeraLista: ParVector[Seq[Char]], segundaLista: ParVector[Seq[Char]]): ParVector[Seq[Char]] = {
    if (primeraLista.isEmpty) ParVector.empty
    else segundaLista.map { cadena => cadena ++ primeraLista.head }.union(combinar_dos_listas_paralelo(primeraLista.tail, segundaLista))
  }
/**
  * Función que busca una secuencia de un n dado que cumpla con el oráculo, usando paralelismo y combinaciones iterativas.
  *
  * @return Option[Seq[Char]]: La primera secuencia encontrada que cumpla con el oráculo, o None si no hay ninguna.
  */
  // Cambia el nombre de la función de PRC_turboPar a buscarSecuenciaTurbo
  def turbo(): Seq[Char]  = {
    def turboAux(sck: ParVector[Seq[Char]], n: Int,cadenaPasada: ParVector[Seq[Char]]= ParVector(Seq())): ParVector[Seq[Char]]  = {
      if (sck.head.size + 1 == n) {
        val uniones = combinar_dos_listas_paralelo(sck, sck.flatten.distinct.map(Seq(_)))
        uniones.filter(oraculo(_))
      } else if (sck.head.size >= n) sck
      else if (sck.head.size*2 > n) {
        val uniones = combinar_dos_listas_paralelo(sck, cadenaPasada).filter(oraculo(_))
        turboAux(uniones, n,sck) 
      }
      else {
        val uniones = combinar_dos_listas_paralelo(sck, sck).filter(oraculo(_))
        turboAux(uniones, n,sck) 
      }
    }
    //val alfabetoEnForma = alfabeto.map(Seq(_)).toVector.toParVector
    // Si el n es 2, llama a la función buscarSecuencia
    if (n == 2) turboAux(alfabetoForma,n).head
    // Si el n es par, busca secuencias de n n-1 y les agrega un caracter del alfabeto
    else if (n % 2 == 0) {
      val subsecuencias = turboAux(alfabetoForma,n/2)
      val secuencias = combinar_dos_listas_paralelo(subsecuencias, subsecuencias).filter(oraculo(_))
      secuencias.head
    // Si el n es impar, busca secuencias de n (n+1)/2 y (n-1)/2 y las combina
    } else {
      val secuencias1 = turboAux(alfabetoForma,n / 2)
      val secuencias2 = turboAux(alfabetoForma,n-(n/2))
      val secuencias = combinar_dos_listas_paralelo(secuencias1, secuencias2).filter(oraculo(_))
      secuencias.head
    }
  }

  def filtro_cadenas(cadena: Seq[Char], subcadenas: ParVector[Seq[Char]], n: Int): Boolean = {
    // Define una función auxiliar recursiva que verifica si una cadena está contenida en una lista de subcadenas
    def contiene(cadena: Seq[Char], subcadenas: ParVector[Seq[Char]]): Boolean = {
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
  * Función que busca una secuencia de un n dado que cumpla con el oráculo, usando paralelismo y combinaciones iterativas.
  *
  * @return Option[Seq[Char]]: La primera secuencia encontrada que cumpla con el oráculo, o None si no hay ninguna.
  */
  // Cambia el nombre de la función de PRC_turboPar a buscarSecuenciaTurbo
  def turboMejorada(): Seq[Char]  = {
    def turboMejoradaAux(sck: ParVector[Seq[Char]], n: Int, secuanciaPasada: ParVector[Seq[Char]] = ParVector(Seq())): ParVector[Seq[Char]]  = {
      if (sck.head.size + 1 == n) {
        val uniones = combinar_dos_listas_paralelo(sck, sck.flatten.distinct.map(Seq(_)))
        uniones.filter(oraculo(_))
      } else if (sck.head.size >= n) sck
      else if (sck.head.size*2 > n){
        val uniones = combinar_dos_listas_paralelo(sck, secuanciaPasada).filter(filtro_cadenas(_, secuanciaPasada, secuanciaPasada.head.size)).filter(oraculo(_))
        turboMejoradaAux(uniones, n, sck)
      }
      else {
        val uniones = combinar_dos_listas_paralelo(sck, sck).filter(filtro_cadenas(_, sck, sck.head.size)).filter(oraculo(_))
        turboMejoradaAux(uniones, n,sck) 
      }
    }
    //val alfabetoEnForma = alfabeto.map(Seq(_)).toVector.toParVector
    // Si el n es 2, llama a la función buscarSecuencia
    if (n == 2) turboMejoradaAux(alfabetoForma,n).head
    // Si el n es par, busca secuencias de n n-1 y les agrega un caracter del alfabeto
    else if (n % 2 == 0) {
      val subsecuencias = turboMejoradaAux(alfabetoForma,n/2)
      val secuencias = combinar_dos_listas_paralelo(subsecuencias, subsecuencias).filter(oraculo(_))
      secuencias.head
    // Si el n es impar, busca secuencias de n (n+1)/2 y (n-1)/2 y las combina
    } else {
      val secuencias1 = turboMejoradaAux(alfabetoForma,n /2)
      val secuencias2 = turboMejoradaAux(alfabetoForma,n-(n / 2))
      val secuencias = combinar_dos_listas_paralelo(secuencias1, secuencias2).filter(oraculo(_))
      secuencias.head
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

    def turboAceleradaAux(t: Trie, secuencias: ParVector[Seq[Char]], acumulada: Seq[Char]): Trie = {
        t match {
          case NodoP(valor, esFinal, hijos) =>
            val nuevosHijos = hijos.map { hijo =>
              if (ramaValida(hijo)) turboAceleradaAux(hijo, secuencias, acumulada :+ valor)
              else hijo
            }
            NodoP(valor, esFinal, nuevosHijos)
          case Hoja(valor, esFinal) =>
            if (!esFinal) NodoP(valor, esFinal, ParVector())
            else {
              val cadenasNuevas: ParVector[Seq[Char]] = secuencias.map(cadena => (acumulada.filter(_ != ' ') :+ valor) ++ cadena).filter(filtro_cadenas(_, secuencias, secuencias.head.size)).filter(oraculo(_)) 

              if (cadenasNuevas.isEmpty) NodoP(valor, esFinal, ParVector())
              else {
                agregar_secuenciasPar(cadenasNuevas.map(_.drop((acumulada.filter(_ != ' ') :+ valor).length)), t)
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
    def evaluar_arbol(arbol: Trie, n: Int,secuanciaPasada: Seq[Seq[Char]]): ParVector[Seq[Char]] = {
      
      val todas_secuencias_arbol = cadenas_del_arbol(arbol)
      if (todas_secuencias_arbol.head.size + 1 == n) {
        combinar_dos_listas_paralelo(todas_secuencias_arbol.toVector.par, alfabetoForma).filter(oraculo(_))
      }
      else if (todas_secuencias_arbol.head.size >= n) todas_secuencias_arbol.toVector.par
      else if (todas_secuencias_arbol.head.size * 2 > n){
        val arbolNuevo = turboAceleradaAux(arbol, secuanciaPasada.toVector.par, Seq())
        evaluar_arbol(arbolNuevo, n,todas_secuencias_arbol)
      }
      else {
        val arbolNuevo = turboAceleradaAux(arbol, todas_secuencias_arbol.toVector.par, Seq())
        evaluar_arbol(arbolNuevo, n,todas_secuencias_arbol)
      }
    }
    val arbol_inicial = arbolDeSufijosPar(alfabetoForma)
    if (n % 2 == 0) {
      val sub_cadenas = evaluar_arbol(arbol_inicial, n / 2,Seq())
      val mezclas = combinar_dos_listas_paralelo(sub_cadenas, sub_cadenas).filter(oraculo(_))
      mezclas.head
    } else {
      val c1 = evaluar_arbol(arbol_inicial, (n + 1) / 2,Seq())
      val c2 = evaluar_arbol(arbol_inicial, (n - 1) / 2,Seq())
      val mezclas = combinar_dos_listas_paralelo(c1, c2).filter(oraculo(_))
      mezclas.head
    }
  }

}   