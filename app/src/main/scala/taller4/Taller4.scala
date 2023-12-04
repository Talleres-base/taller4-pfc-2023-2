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
    val obj2 = new implAlgoritmosParallel()
    val obj3 = new Benchmark()
    
    val A = Vector(
      Vector(2, 3, 4, 5),
      Vector(4, 5, 6, 7),
      Vector(4, 5, 6, 7),
      Vector(4, 5, 6, 7)
    )
    val B = Vector(
      Vector(1,4, 5, 6),
      Vector(3, 2, 1, 4),
      Vector(3, 2, 1, 4),
      Vector(3, 2, 1, 4)
      )

    // val A = Vector(Vector(3, 2, 0, 2), Vector(6, 7, 8, 5), Vector(1, 9, 2, 18), Vector(4, 5, 6, 7))

    // val B = Vector(Vector(3, 2, 9 , 5), Vector(5, 2, 4, 9), Vector(5, 6, 5, 12), Vector(4, 5, 6, 7))
   
    println(obj.multMatrizRec(A,B))
    println(obj.strassen(A,B))
    println(obj2.strassenParallel(A,B))
    println(obj.multMatriz(A,B))
    println(obj2.multMatrizPar(A,B))
    println(obj2.multMatrizParV2(A,B))
    println(obj2.multMatrizRecParallel(A,B))

    println("Comparación de algoritmos")
    val prueba = for {
      i <- 1 to 7
    m1=obj.matrizAlAzar (math.pow(2 , i ).toInt , 2)
    m2=obj.matrizAlAzar (math.pow(2 , i ).toInt , 2)
  } yield ( obj3.compararAlgoritmos (obj.multMatriz , obj2.multMatrizRecParallel ) (m1,m2) ,math.pow(2 , i ).toInt )

  println(prueba)
    //println(obj3.CompararAlgoritmos(obj.multMatrizRec, obj.strassen)(obj.matrizAlAzar(32,2),obj.matrizAlAzar(32,2)))
    
    // val strassenTime = (1 to 100).map(_ => 0.0).toArray
    // for (i <- 0 until 100) {
    //   val m1 = obj.matrizAlAzar(16,2)
    //   val m2 =obj.matrizAlAzar(16,2)
    //   val time = withWarmer(new Warmer.Default) measure {
    //     obj.strassen(m1, m2)
    //   }
    //   strassenTime(i) = time.value
    //   println(" Repetición " + i + " tiempo: " + time)
    // }


    // val promedioRec = (1 to 100).map(_ => 0.0).toArray
    // for (i <- 0 until 100) {
    //   val m1 = obj.matrizAlAzar(16,2)
    //   val m2 = obj.matrizAlAzar(16,2)
    //   val time = withWarmer(new Warmer.Default) measure {
    //     obj.multMatrizRec(m1, m2)
    //   }
    //   promedioRec(i) = time.value
    //   println(" Repetición " + i + " tiempo: " + time)
    // }

    //  val promedioParallelStrassen = (1 to 100).map(_ => 0.0).toArray
    // for (i <- 0 until 100) {
    //   val m1 = obj.matrizAlAzar(16,2)
    //   val m2 = obj.matrizAlAzar(16,2)
    //   val time = withWarmer(new Warmer.Default) measure {
    //     obj2.strassenParallel(m1, m2)
    //   }
    //   promedioParallelStrassen(i) = time.value
    //   println(" Repetición " + i + " tiempo: " + time)
    // }
    // val promedioNormal = (1 to 100).map(_ => 0.0).toArray
    // for (i <- 0 until 100) {
    //   val m1 = obj.matrizAlAzar(16,2)
    //   val m2 = obj.matrizAlAzar(16,2)
    //   val time = withWarmer(new Warmer.Default) measure {
    //     obj.multMatriz(m1, m2)
    //   }
    //   promedioNormal(i) = time.value
    //   println(" Repetición " + i + " tiempo: " + time)
    // }
    // val promedioNormalPar1 = (1 to 100).map(_ => 0.0).toArray
    // for (i <- 0 until 100) {
    //   val m1 = obj.matrizAlAzar(16,2)
    //   val m2 = obj.matrizAlAzar(16,2)
    //   val time = withWarmer(new Warmer.Default) measure {
    //     obj2.multMatrizPar(m1, m2)
    //   }
    //   promedioNormalPar1(i) = time.value
    //   println(" Repetición " + i + " tiempo: " + time)
    // }
    // val promedioNormalPar2 = (1 to 100).map(_ => 0.0).toArray
    // for (i <- 0 until 100) {
    //   val m1 = obj.matrizAlAzar(16,2)
    //   val m2 = obj.matrizAlAzar(16,2)
    //   val time = withWarmer(new Warmer.Default) measure {
    //     obj2.multMatrizParV2(m1, m2)
    //   }
    //   promedioNormalPar2(i) = time.value
    //   println(" Repetición " + i + " tiempo: " + time)
    // }

    
    // val promedioRecParallel = (1 to 100).map(_ => 0.0).toArray
    // for (i <- 0 until 100) {
    //   val m1 = obj.matrizAlAzar(16,2)
    //   val m2 = obj.matrizAlAzar(16,2)
    //   val time = withWarmer(new Warmer.Default) measure {
    //     obj2.multMatrizParV2(m1, m2)
    //   }
    //   promedioRecParallel(i) = time.value
    //   println(" Repetición " + i + " tiempo: " + time)
    // }
    // println("El promedio normal es: " + promedioNormal.sum / 100 + " ms")
    // println("El promedio normal paralelo es: " + promedioNormalPar1.sum / 100 + " ms")
    // println("El promedio normal paralelo v2 es: " + promedioNormalPar2.sum / 100 + " ms")
    // println("El promedio multiRec es: " + promedioRec.sum / 100 + " ms")
    // println("El promedio multiRec paralelo es: " + promedioRecParallel.sum / 100 + " ms")
    // println("El promedio strassenPal es: " + promedioParallelStrassen.sum / 100 + " ms")
    // println("El promedio strassen es: " + strassenTime.sum / 100 + " ms")
   
  

    // println(saludo())
    // println(
    //   withWarmer(new Warmer.Default) measure {
    //     (1 to 100000000).toArray
    //   } // ) 
  }

 }
