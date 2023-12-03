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

    val A = Vector(
      Vector(2, 3),
      Vector(4, 5)
    )
    val B = Vector(
      Vector(1,4),
      Vector(3, 2)
      )

    // println(obj.multMatrizRec(A,B))
    // println(obj.strassen(A,B))
    
    val strassenTime = (1 to 100).map(_ => 0.0).toArray
    for (i <- 0 until 100) {
      val m1 = obj.matrizAlAzar(4,2)
      val m2 =obj.matrizAlAzar(4,2)
      val time = withWarmer(new Warmer.Default) measure {
        obj.strassen(m1, m2)
      }
      strassenTime(i) = time.value
      println(" Repetición " + i + " tiempo: " + time)
    }


    val promedioSeq = (1 to 100).map(_ => 0.0).toArray
    for (i <- 0 until 100) {
      val m1 = obj.matrizAlAzar(4,2)
      val m2 = obj.matrizAlAzar(4,2)
      val time = withWarmer(new Warmer.Default) measure {
        obj.multMatrizRec(m1, m2)
      }
      promedioSeq(i) = time.value
      println(" Repetición " + i + " tiempo: " + time)
    }

    println("El promedio multiRec es: " + promedioSeq.sum / 100 + " ms")
    println("El promedio strassen es: " + strassenTime.sum / 100 + " ms")
   
    

    // println(saludo())
    // println(
    //   withWarmer(new Warmer.Default) measure {
    //     (1 to 100000000).toArray
    //   } // ) 
  }

 }
