/**
 * Clase BuscadorCadena
 */

package taller4
import taller4.TrieDefinitions._
//import common._
import scala.collection.parallel._

class BuscadorCadena(cadenaObjetivo: String, alfabeto: Seq[Char]) {
  type Oraculo = Seq[Char] => Boolean
  val oraculo: Oraculo = (subcadena: Seq[Char]) => cadenaObjetivo.contains(subcadena.mkString)
  val n: Int = cadenaObjetivo.length

  def agregarcombinaciones(lista: Seq[Seq[Char]],listaCadeneasAconcatenar: Seq[Char]): Seq[Seq[Char]] = {
    if (lista.isEmpty) Nil 
    else listaCadeneasAconcatenar.map{cadena => lista.head :+ cadena} ++ agregarcombinaciones(lista.tail,listaCadeneasAconcatenar) 
  }

  def gemerarCombinaciones(cadenaAconcatenar: Seq[Char],tamañodeseado: Int, lista: Seq[Seq[Char]]): Seq[Seq[Char]] = {
    if (tamañodeseado == 0) lista 
    else{
      val accResul = agregarcombinaciones(lista,cadenaAconcatenar)
      gemerarCombinaciones(cadenaAconcatenar,tamañodeseado-1,accResul)
    }   
  }

  def PRC_Ingenuo(): Option[Seq[Char]] = {
    val alfabetoenForma = alfabeto.map(cadena => Seq(cadena))
    val combinaciones = gemerarCombinaciones(alfabeto,n-1,alfabetoenForma)
    combinaciones.find(oraculo)
  }

  def PRC_Mejorado(): Option[Seq[Char]]  = {
    def PRC_MejoradoAux(sck : Seq[Seq[Char]]): Option[Seq[Char]]  = {
      if (sck.isEmpty) None 
      else {
        val combinaciones = agregarcombinaciones(sck,alfabeto).filter(oraculo(_))
        if(combinaciones.filter(_.size == n).size != 0) Some(combinaciones.head)
        else PRC_MejoradoAux(combinaciones) 
      }
    }
    val alfabetoenForma = alfabeto.map(cadena => Seq(cadena))
    PRC_MejoradoAux(alfabetoenForma)
  }

  def combinar(lista1: Seq[Seq[Char]], lista2: Seq[Seq[Char]]): Seq[Seq[Char]] = { 
    //else agregarcombinaciones(lista2,lista1.head) ++ combinar(lista1.tail,lista2)
    if (lista1.isEmpty) Nil 
    else lista2.map{cadena => cadena ++ lista1.head} ++ combinar(lista1.tail,lista2)
  }
  /*
  def reconstruirCadenaTurbo(n: Int): Seq[Char] = {
    // Función que recibe la longitud de la secuencia a construir (n, potencia de 2)
    // y un oráculo para esa secuencia, y devuelve la secuencia reconstruida.
    // Utiliza la propiedad de que si s = s1 ++ s2 entonces s1 y s2 también son subsecuencias de s
    // ...
    def reconstruirCadenaTurboAux(lista1: Seq[char],lista2: Seq[char], combinaciones: Seq[char],n : Int): Seq[char] = {
      if (n == 0) combinaciones
    }
    
  }
  */
  def PRC_turbo(): Seq[Char]  = {
    def PRC_turboAux(sck : Seq[Seq[Char]],n: Int): Seq[Seq[Char]]  = {
      if (sck.head.size +1 == n && n%2 != 0){
        val combinaciones = agregarcombinaciones(sck,sck.flatten.distinct)
        combinaciones.filter(oraculo(_))
      } else if(sck.head.size >= n) sck
      else {
        val combinaciones = combinar(sck,sck).filter(oraculo(_))
        if(combinaciones.filter(_.size == n).size != 0) combinaciones
        else PRC_turboAux(combinaciones,n) 
      }
    }
    val alfabetoenForma = alfabeto.map(cadena => Seq(cadena))
    if (n%2==0){
      val sub_cadenas = PRC_turboAux(alfabetoenForma,n/2)
      val combinaciones = combinar(sub_cadenas,sub_cadenas).filter(oraculo(_))
      if (combinaciones.isEmpty){
        println("vacio")
        Seq()
      } else combinaciones.head
    } 
    else {
      val alfabeto_meno = alfabeto.map(cadena => Seq(cadena))
      val cadenas1 = PRC_turboAux(alfabetoenForma,(n+1)/2)
      val cadenas2 = PRC_turboAux(alfabetoenForma,n/2)
      val combinaciones = combinar(cadenas1,cadenas2).filter(oraculo(_))
      if (combinaciones.isEmpty){
        println("vacio")
        Seq()
      } else combinaciones.head
    }
  }

  def filtro_cadenas(s: Seq[Char],sck: Seq[Seq[Char]],k: Int): Boolean = {
    def estaContenido(s: Seq[Char],sck: Seq[Seq[Char]]): Boolean = {
      if(sck.isEmpty) false
      else if(sck.head == s) true
      else estaContenido(s,sck.tail)
    }
    if(s.length == k) estaContenido(s.take(k),sck)
    else {
      val subcadena = s.take(k)
      if(estaContenido(subcadena,sck)) filtro_cadenas(s.tail,sck,k)
      else false
    } 
  }

  def PRC_turbo_mejorada(): Seq[Char]  = {
    def PRC_turbo_mejoradaAux(sck : Seq[Seq[Char]]): Seq[Char]  = {
      if (sck.isEmpty) Seq() 
      else if(sck.head.size >= n) Seq() 
      else {
        val combinaciones = combinar(sck,sck).filter(filtro_cadenas(_,sck,sck.head.size)).filter(oraculo(_))
        if(combinaciones.filter(_.size == n).size != 0) combinaciones.head
        else PRC_turbo_mejoradaAux(combinaciones) 
      }
    }
    val alfabetoenForma = alfabeto.map(cadena => Seq(cadena))
    PRC_turbo_mejoradaAux(alfabetoenForma)
  }


  def pertenece(c: Seq[Char], t: Trie): Boolean = {
    t match {
      case Nodo(car, marcada, hijos) => {
        if (c.isEmpty) marcada
        else {
          val cabeza = c.head
          val cola = c.tail
          val hijosCabeza = hijos.filter(hijo => raiz(hijo) == cabeza)
          if (hijosCabeza.isEmpty) false
          else pertenece(cola, hijosCabeza.head)
        }
      }
      case Hoja(car, marcada) => {
        if (c.isEmpty) marcada
        else false
      }
    }
  }

  def agregar(c: Seq[Char], t: Trie): Trie = {
    t match {
      case Nodo(car, marcada, hijos) => {
        if (c.isEmpty) Nodo(car, true, hijos)
        else {
          val cabeza = c.head
          val cola = c.tail
          val hijosCabeza = hijos.filter(hijo => raiz(hijo) == cabeza)
          if (hijosCabeza.isEmpty) {
            val nuevoHijo = if (cola.isEmpty) Hoja(cabeza, true) else agregar(cola,Nodo(cabeza, false, List()))
            Nodo(car, marcada, nuevoHijo :: hijos)
          } else {
            val nuevoHijo = agregar(cola, hijosCabeza.head)
            val otrosHijos = hijos.filter(hijo => raiz(hijo) != cabeza)
            Nodo(car, marcada, nuevoHijo :: otrosHijos)
          }
        }
      }
      case Hoja(car, marcada) => {
        if (c.isEmpty) Hoja(car, true)
        else {
          val cabeza = c.head
          val cola = c.tail
          if (car == cabeza) Nodo(car, marcada, List(if (cola.isEmpty) Hoja(cabeza, false) else agregar(cola, Nodo(cabeza, false, List()))))
          else Nodo(car, marcada, List(Nodo(cabeza, false, List(if (cola.isEmpty) Hoja(cabeza, false) else agregar(cola, Nodo(cabeza, false, List()))))))
        }
      }
    }
  }


  def arbolDeSufijos(ss: Seq[Seq[Char]]): Trie = {
    var t: Trie = Nodo(' ', false, List())
    for (s <- ss; i <- s.indices) {
      t = agregar(s, t)
    }
    t
  }

  def secuencias_del_arbol_hijos(hijos: List[Trie], seqa: Seq[Char]): Seq[Seq[Char]] = {
    hijos match {
      case Nil => if (oraculo(seqa)) Seq(seqa)
                  else Seq()
      case x :: xs => secuencias_del_arbol(x, seqa) ++ secuencias_del_arbol_hijos(xs, seqa)
    }
  }



  def filtro_arbol(s: Seq[Char],t: Trie,k: Int): Boolean = {
    if(s.length == k) pertenece(s,t)
    else {
      val subcadena = s.take(k)
      if(pertenece(subcadena,t)) filtro_arbol(s.tail,t,k)
      else false

    } 
  }
  def secuencias_del_arbol(arbol: Trie, seqa: Seq[Char] = Seq()): Seq[Seq[Char]] = {  
    arbol match {
      case Nodo(valor, esFinal, hijos) =>
        if(valor != ' ') secuencias_del_arbol_hijos(hijos, seqa :+ valor)
        else secuencias_del_arbol_hijos(hijos, seqa)
      case Hoja(valor, esFinal) =>
        if (esFinal) Seq(seqa :+ valor)
        else Seq(seqa)
    }
  }

  def recorrerArbol(t: Trie): Seq[Seq[Char]] = {
    t match {
      case Nodo(c, _, hijos) => 
        val secuenciasHijos = hijos.flatMap(hijo => recorrerArbol(hijo))
        secuenciasHijos.map(secuencia => c +: secuencia).map(_.filter(_ != ' '))
      case Hoja(c, _) => Seq(Seq(c))
    }
  }
  def reconstruirCadenaTurboAcelerada(): Seq[Char] = {
    // recibe la longitud de la secuencia que hay que reconstruir (n, potencia de 2), y un oraculo para esa secuencia
    // y devuelve la secuencia reconstruida
    // Usa la propiedad de que si s=s1++s2 entonces s1 y s2 tambien son subsecuencias de s
    // Usa arboles de sufijos para guardar Seq[Seq[Char]]...        val combinaciones = agregarcombinaciones(sck,sck.flatten.distinct)  combinaciones.filter(oraculo(_))
    def turboAcelerada(t: Trie,n: Int): Seq[Seq[Char]] = {
      val secuencias = recorrerArbol(t).filter(oraculo(_))
      if (secuencias.isEmpty) Seq(Seq())
      else if(secuencias.head.length == n) secuencias
      else if(secuencias.head.length+1 == n) agregarcombinaciones(secuencias,secuencias.flatten.distinct)
      else{
        val resultado  = combinar(secuencias,secuencias).filter(filtro_arbol(_,t,secuencias.head.length))
        turboAcelerada(arbolDeSufijos(resultado),n)
      } 
    }

    val arbol_inicial = arbolDeSufijos(alfabeto.map(cadena => Seq(cadena)))
    //val arbol_inicial = arbolDeSufijos(Seq(Seq('p','e'),Seq('s','o')))
    if (n%2==0){
      val sub_cadenas = turboAcelerada(arbol_inicial,n/2)
      val combinaciones = combinar(sub_cadenas,sub_cadenas).filter(oraculo(_))
      if (combinaciones.isEmpty){
        println("vacio")
        Seq()
      } else combinaciones.head
    } 
    else {
      val alfabeto_meno = alfabeto.map(cadena => Seq(cadena))
      val cadenas1 = turboAcelerada(arbol_inicial,(n+1)/2)
      val cadenas2 = turboAcelerada(arbol_inicial,n/2)
      val combinaciones = combinar(cadenas1,cadenas2).filter(oraculo(_))
      if (combinaciones.isEmpty){
        println("vacio")
        Seq()
      } else combinaciones.head
    }
    
  }
  //
  //    funciones paralelas
  //
  //
  /*
  def PRC_IngenuoPar(): Option[Seq[Char]] = {
    val alfabetoenForma = alfabeto.map(cadena => Seq(cadena))
    val resultado = gemerarCombinaciones(alfabeto, n - 1, alfabetoenForma)

    if (n % 2 == 0) {
      val (c1, c2) = (resultado.take(n / 2).par.find(oraculo), resultado.drop(n / 2).par.find(oraculo))
      if (c1.isDefined) c1 else c2
    } else {
      val (c1, c2) = (resultado.take((n + 1) / 2).par.find(oraculo), resultado.drop((n - 1) / 2).par.find(oraculo))
      if (c1.isDefined) c1 else c2
    }
  }
  */

}



  

