/**
  * Taller 3 - Programación Funcional
  * Autores: <Jhon Alejandro Martinez - 2259565  - Victor Hernandez- 2259520>
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
    // for(i <- 1  to 7){
    //         println(obj3.desempenoDeFuncionesSecuenciales(math.pow(2,i).toInt))
    //     }
    val obj3 = new Benchmark()
      for(i <- 1  to 7){
            println(obj3.desempenoDeFuncionesSecuenciales(math.pow(2,i).toInt))
        }

  }

 }
