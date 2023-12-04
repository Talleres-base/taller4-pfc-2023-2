/**
  * Taller 3 - Programación Funcional
  * Autores: miguel angel ceballos y ya
  * Profesor: Carlos A Delgado
  */
package taller4


import org.scalameter.measure
import org.scalameter.withWarmer
import org.scalameter.Warmer
import scala.util.Random
//import scala.collection.parallel.CollectionConverters._

import common._
//import org.scalameter._


object Taller4{
  type Matriz = Vector[Vector[Int]]

  def saludo() = "Taller 4 2023-II"

  def matrizAlAzar (long:Int , vals:Int ):Matriz = {
    //Crea una m a t r i z de e n t e r o s cuad rada de l o n g x lon g ,
    // con v a l o r e s a l e a t o r i o s e n t r e 0 y v a l s
    val v = Vector.fill(long,long){Random.nextInt(vals)}
    v
  }
  
  def prodPunto(v1: Vector[Int], v2: Vector[Int]): Int = {
    (v1 zip v2).map({ case (i, j) => i * j }).sum
  }

  //def prodPuntoParD( v1 : ParVector[Int], v2 : ParVector[Int] ): Int={
  //  (v1 zip v2).map({ case(i,j) => (i∗j)}).sum
  //}


  def transpuesta(m: Matriz): Matriz = {
    val l = m.length
    Vector.tabulate(l, l)((i, j) => m(j)(i))
  }

  def multMatrizAux(vec1:Vector[Int],matrizTransformer:Matriz): Vector[Int]={
    if (matrizTransformer.length == 1) Vector(prodPunto(vec1,matrizTransformer.head))
    else Vector(prodPunto(vec1,matrizTransformer.head)) ++ multMatrizAux(vec1,matrizTransformer.tail)
  }

  def multMatriz(m1: Matriz, m2: Matriz): Matriz = {
    val size = m1.length

    Vector.tabulate(size, size) { (i, j) =>
      val fila = m1(i)
      val columna = transpuesta(m2)(j)
      prodPunto(fila, columna)
    }
  }

  def multMatrizPar(m1: Matriz, m2: Matriz): Matriz = {
    val size = m1.length
    Vector.tabulate(size, size) { (i, j) =>
      val (fila, columna) = parallel(m1(i), transpuesta(m2)(j))
      prodPunto(fila, columna)
    }
  }

  def subMatriz(m: Matriz, i: Int, j: Int, n: Int): Matriz = {
    // Dada m, matriz cuadrada de NxN, 1<=i, j<=N, i+n<=N, j+n<=N,
    // devuelve la submatriz de nxn correspondiente a m[i..i+(n-1), j..j+(n-1)]
    Vector.tabulate(n){y =>
      Vector.tabulate(n){x =>
        m(i+y)(j+x)
      }
    } 
  }

  def sumMatriz(m1: Matriz, m2: Matriz): Matriz = {
    // recibe m1 y m2 matrices cuadradas de la misma dimensión, potencia de 2
    // y devuelve la matriz resultante de la suma de las 2 matrices
    Vector.tabulate(m1.length){y =>
      Vector.tabulate(m1.head.length){x =>
        m1(y)(x) + m2(y)(x)
      }
    } 
  }
  //println(multiVector(Vector(2,2),Vector(2,2)))          (iiiiiiiiiiiiiiiiii)
  def multMatrizRec(m1: Matriz, m2: Matriz): Matriz = {
    if (m1.length == 1) Vector(Vector(m1(0)(0) * m2(0)(0)))
    else {
      val m2T = m2
      val m1SubMatrices = Vector(
        subMatriz(m1, 0, 0, m1.length / 2),
        subMatriz(m1, 0, m1.length / 2, m1.length / 2),
        subMatriz(m1, m1.length / 2, 0, m1.length / 2),
        subMatriz(m1, m1.length / 2, m1.length / 2, m1.length / 2)
      )

      val m2SubMatrices = Vector(
        subMatriz(m2T, 0, 0, m2.length / 2),
        subMatriz(m2T, 0, m2.length / 2, m2.length / 2),
        subMatriz(m2T, m2.length / 2, 0, m2.length / 2),
        subMatriz(m2T, m2.length / 2, m2.length / 2, m2.length / 2)
      )
      val vector1  = sumMatriz(
        multMatrizRec(m1SubMatrices(0), m2SubMatrices(0)),
        multMatrizRec(m1SubMatrices(1), m2SubMatrices(2))
      )  
      val vector2  = sumMatriz(
        multMatrizRec(m1SubMatrices(0), m2SubMatrices(1)),
        multMatrizRec(m1SubMatrices(1), m2SubMatrices(3))
      )
      val vector3  = sumMatriz(
        multMatrizRec(m1SubMatrices(2), m2SubMatrices(0)),
        multMatrizRec(m1SubMatrices(3), m2SubMatrices(2))
      )  
      val vector4  = sumMatriz(
        multMatrizRec(m1SubMatrices(2), m2SubMatrices(1)),
        multMatrizRec(m1SubMatrices(3), m2SubMatrices(3))
      )
      
      
      val sumavector1y2 = Vector.tabulate(vector1.size)(y =>
        (vector1(y)++vector2(y))
      )
      val sumavector3y4 = Vector.tabulate(vector3.size)(y =>
        (vector3(y)++vector4(y))
      )
      sumavector1y2 ++ sumavector3y4
    }
  }
  //
  // Esta función recibe dos matrices cuadradas de la misma dimensión y devuelve su productossss
  // Esta función recibe dos matrices cuadradas de la misma dimensión y devuelve su producto
def multMatrizRecPar(m1: Matriz, m2: Matriz): Matriz = {
  if (m1.length == 1) Vector(Vector(m1(0)(0) * m2(0)(0)))
  else {
    val m2T = m2
    // Se crean las submatrices de la primera matriz
    val (m1SubMatrices,m2SubMatrices) = parallel(Vector(
      subMatriz(m1, 0, 0, m1.length / 2),
      subMatriz(m1, 0, m1.length / 2, m1.length / 2),
      subMatriz(m1, m1.length / 2, 0, m1.length / 2),
      subMatriz(m1, m1.length / 2, m1.length / 2, m1.length / 2)
    ),Vector(
      subMatriz(m2T, 0, 0, m2.length / 2),
      subMatriz(m2T, 0, m2.length / 2, m2.length / 2),
      subMatriz(m2T, m2.length / 2, 0, m2.length / 2),
      subMatriz(m2T, m2.length / 2, m2.length / 2, m2.length / 2)
    ))

    // Se calculan los cuatro bloques de la matriz producto
    val (c1, c2, c3, c4) = parallel(
      sumMatriz(
        multMatrizRecPar(m1SubMatrices(0), m2SubMatrices(0)),
        multMatrizRecPar(m1SubMatrices(1), m2SubMatrices(2))
      ),
      sumMatriz(
        multMatrizRecPar(m1SubMatrices(0), m2SubMatrices(1)),
        multMatrizRecPar(m1SubMatrices(1), m2SubMatrices(3))
      ),
      sumMatriz(
        multMatrizRecPar(m1SubMatrices(2), m2SubMatrices(0)),
        multMatrizRecPar(m1SubMatrices(3), m2SubMatrices(2))
      ),
      sumMatriz(
        multMatrizRecPar(m1SubMatrices(2), m2SubMatrices(1)),
        multMatrizRecPar(m1SubMatrices(3), m2SubMatrices(3))
      )
    )
    // Se unen los cuatro bloques para formar la matriz producto
    val sumavector1y2 = Vector.tabulate(c1.size)(y =>
        (c1(y)++c2(y))
      )
      val sumavector3y4 = Vector.tabulate(c3.size)(y =>
        (c3(y)++c4(y))
      )
      sumavector1y2 ++ sumavector3y4
    
  }
}



  def restaMatriz(m1: Matriz, m2: Matriz): Matriz ={
    //Recibe m1 y m2 matrices cuadradas de la misma dimensión, potencia de 2
    //y devuelve la matriz resultante de la resta de las 2 matrices
    Vector.tabulate(m1.length){y =>
      Vector.tabulate(m1.length){x =>
        m1(y)(x) + ((m2(y)(x)*(-1)))
      }
    } 
  }
  

  def multStrass(m1: Matriz, m2: Matriz): Matriz = {
    // Recibe m1 y m2 matrices cuadradas de la misma dimensión, potencia de 2
    // y devuelve la multiplicación de las 2 matrices usando el algoritmo de Strassen
    if (m1.length == 1) Vector(Vector(m1(0)(0) * m2(0)(0)))
    else {
      val m1_1 = subMatriz(m1, 0, 0, m1.length / 2)
      val m1_2 = subMatriz(m1, 0, m1.length / 2, m1.length / 2)
      val m1_3 = subMatriz(m1, m1.length / 2, 0, m1.length / 2)
      val m1_4 = subMatriz(m1, m1.length / 2, m1.length / 2, m1.length / 2)
      val m2_1 = subMatriz(m2, 0, 0, m2.length / 2)
      val m2_2 = subMatriz(m2, 0, m2.length / 2, m2.length / 2)
      val m2_3 = subMatriz(m2, m2.length / 2, 0, m2.length / 2)
      val m2_4 = subMatriz(m2, m2.length / 2, m2.length / 2, m2.length / 2)
      val s1 = restaMatriz(m2_2, m2_4)
      val s2 = sumMatriz(m1_1, m1_2)
      val s3 = sumMatriz(m1_3, m1_4)
      val s4 = restaMatriz(m2_3, m2_1)
      val s5 = sumMatriz(m1_1, m1_4)
      val s6 = sumMatriz(m2_1, m2_4)
      val s7 = restaMatriz(m1_2, m1_4)
      val s8 = sumMatriz(m2_3, m2_4)
      val s9 = restaMatriz(m1_1, m1_3)
      val s10 = sumMatriz(m2_1, m2_2)

      val p1 = multStrass(m1_1, s1)
      val p2 = multStrass(s2, m2_4)
      val p3 = multStrass(s3, m2_1)
      val p4 = multStrass(m1_4, s4)
      val p5 = multStrass(s5, s6)
      val p6 = multStrass(s7, s8)
      val p7 = multStrass(s9, s10)

      val c1 = sumMatriz(sumMatriz(p5, p4), restaMatriz(p6, p2))
      val c2 = sumMatriz(p1, p2)
      val c3 = sumMatriz(p3, p4)
      val c4 = restaMatriz(sumMatriz(p5, p1), sumMatriz(p3, p7))
      val sumavector1y2 = Vector.tabulate(c1.size)(y =>
        (c1(y)++c2(y))
      )
      val sumavector3y4 = Vector.tabulate(c3.size)(y =>
        (c3(y)++c4(y))
      )
      sumavector1y2 ++ sumavector3y4
    }
  }

  def multStrassPar(m1: Matriz, m2: Matriz): Matriz = {
  if (m1.length == 1) Vector(Vector(m1(0)(0) * m2(0)(0)))
  else {
    // Se usa la abstracción parallel para crear un par de vectores paralelos con las submatrices de la primera y la segunda matriz
    val (m1SubMatrices,m2SubMatrices) = parallel(Vector(
      subMatriz(m1, 0, 0, m1.length / 2),
      subMatriz(m1, 0, m1.length / 2, m1.length / 2),
      subMatriz(m1, m1.length / 2, 0, m1.length / 2),
      subMatriz(m1, m1.length / 2, m1.length / 2, m1.length / 2)
    ),Vector(
      subMatriz(m2, 0, 0, m2.length / 2),
      subMatriz(m2, 0, m2.length / 2, m2.length / 2),
      subMatriz(m2, m2.length / 2, 0, m2.length / 2),
      subMatriz(m2, m2.length / 2, m2.length / 2, m2.length / 2)
    ))

    // Se usa la abstracción parallel para crear un vector paralelo con las diferencias y las sumas de las submatrices
    val s1 = task { restaMatriz(m2SubMatrices(1), m2SubMatrices(3)) }
    val s2 = task { sumMatriz(m1SubMatrices(0), m1SubMatrices(1)) }
    val s3 = task { sumMatriz(m1SubMatrices(2), m1SubMatrices(3)) }
    val s4 = task { restaMatriz(m2SubMatrices(2), m2SubMatrices(0)) }
    val s5 = task { sumMatriz(m1SubMatrices(0), m1SubMatrices(3)) }
    val s6 = task { sumMatriz(m2SubMatrices(0), m2SubMatrices(3)) }
    val s7 = task { restaMatriz(m1SubMatrices(1), m1SubMatrices(3)) }
    val s8 = task { sumMatriz(m2SubMatrices(2), m2SubMatrices(3)) }
    val s9 = task { restaMatriz(m1SubMatrices(0), m1SubMatrices(2)) }
    val s10 = task { sumMatriz(m2SubMatrices(0), m2SubMatrices(1)) }

    // Se usa el método task para crear las tareas que calculan las multiplicaciones de las submatrices
    val p1 = task { multStrass(m1SubMatrices(0), s1.join) }
    val p2 = task { multStrass(s2.join, m2SubMatrices(3)) }
    val p3 = task { multStrass(s3.join, m2SubMatrices(0)) }
    val p4 = task { multStrass(m1SubMatrices(3), s4.join) }
    val p5 = task { multStrass(s5.join, s6.join) }
    val p6 = task { multStrass(s7.join, s8.join) }
    val p7 = task { multStrass(s9.join, s10.join) }

    // Se usa el método join para obtener el resultado de las tareas cuando se vayan a usar
    val c1 = sumMatriz(sumMatriz(p5.join, p4.join), restaMatriz(p6.join, p2.join))
    val c2 = sumMatriz(p1.join, p2.join)
    val c3 = sumMatriz(p3.join, p4.join)
    val c4 = restaMatriz(sumMatriz(p5.join, p1.join), sumMatriz(p3.join, p7.join))

    // Se unen los cuatro bloques para formar la matriz producto
    val sumavector1y2 = Vector.tabulate(c1.size)(y =>
        (c1(y)++c2(y))
      )
      val sumavector3y4 = Vector.tabulate(c3.size)(y =>
        (c3(y)++c4(y))
      )
      sumavector1y2 ++ sumavector3y4  
    }
  }

  def compararAlgoritmos(funcion1: (Matriz, Matriz) => Matriz, funcion2: (Matriz, Matriz) => Matriz)
                        (matriz1: Matriz, matriz2: Matriz): (Double, Double, Double) = {

    val tiempoFuncion1 = withWarmer(new Warmer.Default) measure {
      funcion1(matriz1, matriz2)
    }

    val tiempoFuncion2 = withWarmer(new Warmer.Default) measure {
      funcion2(matriz1, matriz2)
    }

    val tiempo1: Double = tiempoFuncion1.value
    val tiempo2: Double = tiempoFuncion2.value

    val aceleracion = tiempo1 / tiempo2

    (tiempo1, tiempo2, aceleracion)
  }
 
  def main(args: Array[String]): Unit = {
    println(saludo())
    println(" pruebas 8x8")
    val m1 = matrizAlAzar(8,10)
    val m2 = matrizAlAzar(8,10)
    println(compararAlgoritmos(multMatriz,multMatrizPar)(m1,m2))
    println(compararAlgoritmos(multMatrizRec,multMatrizRecPar)(m1,m2))
    println(compararAlgoritmos(multStrass,multStrassPar)(m1,m2))
    println(" pruebas 32x32")
    val m3 = matrizAlAzar(32,10)
    val m4 = matrizAlAzar(32,10)
    println(compararAlgoritmos(multMatriz,multMatrizPar)(m3,m4))
    println(compararAlgoritmos(multMatrizRec,multMatrizRecPar)(m3,m4))
    println(compararAlgoritmos(multStrass,multStrassPar)(m3,m4))
    println(" pruebas 128x128")
    val m5 = matrizAlAzar(128,10)
    val m6 = matrizAlAzar(128,10)
    println(compararAlgoritmos(multMatriz,multMatrizPar)(m5,m6))
    println(compararAlgoritmos(multMatrizRec,multMatrizRecPar)(m5,m6))
    println(compararAlgoritmos(multStrass,multStrassPar)(m5,m6))
    println(" pruebas 256x256")
    val m7 = matrizAlAzar(256,10)
    val m8 = matrizAlAzar(256,10)
    println(compararAlgoritmos(multMatriz,multMatrizPar)(m7,m8))
    println(compararAlgoritmos(multMatrizRec,multMatrizRecPar)(m7,m8))
    println(compararAlgoritmos(multStrass,multStrassPar)(m7,m8))
    
  }
}
