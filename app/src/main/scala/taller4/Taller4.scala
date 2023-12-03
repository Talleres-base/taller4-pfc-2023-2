/**
  * Taller 3 - Programación Funcional
  * Autores: <Estudiantes>
  * Profesor: Carlos A Delgado
  */
package taller4

import org.scalameter.measure
import org.scalameter.withWarmer
import org.scalameter.Warmer
import scala.util.Random


object Taller4{

 type Matriz = Vector [ Vector [ Int ] ]

  def saludo() = "Taller 4 2023-II"

 
 
  def main(args: Array[String]): Unit = {
    val obj = new implAlgoritmos()

    println(obj.multMatrizRec(obj.matrizAlAzar(128,2),obj.matrizAlAzar(128,2)))

    // println(saludo())
    // println(
    //   withWarmer(new Warmer.Default) measure {
    //     (1 to 100000000).toArray
    //   } // ) 
  }

 }
