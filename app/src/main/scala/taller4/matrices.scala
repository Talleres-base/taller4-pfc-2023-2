/**
  * Código de solución del problema de multiplicación de matrices concurrente
  */

 package taller4
import common._
import scala.util.Random

class matrices {

  type Matriz = Vector[Vector[Int]]

  /**
  * Crea una matriz al azar dados una dimensiónde matriz (long) y un limite (vals) de valores que va contener la matriz, es decir los valores están en el intervalo [0,vals)
  * @param long:Int
  * @param vals:Int
  * @return Matriz de diección long x long con valores en el rango [0,vals)
  */ 
  def matrizAlAzar(long:Int, vals:Int): Matriz = {
    Vector.fill(long,long)(Random.nextInt(vals)
  }

  /**
  * Crea un vector al azar de dimension long y valores en el intervalo [0,vals)
  * @param long:Int
  * @param vals:Int
  * @return Vector de dimensión long con valores en el rango [0,vals)
  */
  def vectorAlAzar(long:Int, vals:Int): Vector[Int] = {
    Vector.fill(long)(Random.nextInt(vals))
  }

}
