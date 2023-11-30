package taller4
import org.scalameter.measure
import org.scalameter.withWarmer
import org.scalameter.Warmer
import scala.util.Random

class implAlgoritmos {     
    type Matriz = Vector [ Vector [ Int ] ]

  def matrizAlAzar(Long: Int, vals: Int): Matriz = {
    val v = Vector.fill(Long, Long){Random.nextInt(vals)}
    v
  }


  def vectorAlAzar(Long: Int, vals: Int): Vector[Int] = {
    val v = Vector.fill(Long){Random.nextInt(vals)}
    v
  }
  
  // Funciones auxiliares para la operación de matrices
  def prodPunto(v1: Vector[Int], v2: Vector[Int]): Int = {
    (v1 zip v2).map( { case (i, j) => (i * j) }).sum
  }

  def transpuesta(m: Matriz): Matriz = {
    val l=m.length
    Vector.tabulate(l, l)((i, j) => m(j)(i))
  }


def multMatriz(m1: Matriz, m2: Matriz): Matriz = {
    //calculo usando prodPunto y la transpuesta
    val l=m1.length
    Vector.tabulate(l, l)((i, j) => prodPunto(m1(i), transpuesta(m2)(j)))
}

  def sumMatriz(m1: Matriz, m2: Matriz): Matriz = {
    val l=m1.length
    Vector.tabulate(l, l)((i, j) => m1(i)(j)+m2(i)(j))
  }

  def restaMatriz(m1: Matriz, m2: Matriz): Matriz = {
    val l=m1.length
    Vector.tabulate(l, l)((i, j) => m1(i)(j)-m2(i)(j))
  }
   def subMatriz (m:Matriz , i: Int , j : Int , l : Int ) : Matriz ={
    val sub = Vector.tabulate(l/l, l/l)((is, js) => m(i)(j))
    sub
  }
}