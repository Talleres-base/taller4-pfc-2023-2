/**
 * Plantilla para pruebas
 * author Carlos Delgado
 * version 1.0
 * note 22 de Noviembre de 2023 
 */
package taller4

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner
import org.scalactic.source.Position

@RunWith(classOf[JUnitRunner])
class TestTaller4 extends AnyFunSuite {
    val obj = new implAlgoritmos()
    val obj2 = new implAlgoritmosParallel()
    val obj3 = new Benchmark()
    
    test("Prueba de la multiplicación de matrices strassen secuencial vs strassen paralelo") { 
        println("Comparación de algoritmos")
        val prueba = for {
            i <- 1 to 7
            m1 = obj.matrizAlAzar(math.pow(2, i).toInt, 2)
            m2 = obj.matrizAlAzar(math.pow(2, i).toInt, 2)
        } yield (obj3.compararAlgoritmos(obj.strassen, obj2.strassenParallel)(m1, m2), math.pow(2, i).toInt)
        println(prueba)
    }(Position.apply("", "", 0))

    
    test("Prueba de la multiplicación de matrices secuencial vs paraleloV2") { 
        println("Comparación de algoritmos")
        val prueba = for {
            i <- 1 to 7
            m1 = obj.matrizAlAzar(math.pow(2, i).toInt, 2)
            m2 = obj.matrizAlAzar(math.pow(2, i).toInt, 2)
        } yield (obj3.compararAlgoritmos(obj.multMatriz, obj2.multMatrizParV2)(m1, m2), math.pow(2, i).toInt)
        println(prueba)
    }(Position.apply("", "", 0))

    test("Prueba de la multiplicación de matrices recursiva secuencial vs recursiva paralelo") { 
        println("Comparación de algoritmos")
        val prueba = for {
            i <- 1 to 7
            m1 = obj.matrizAlAzar(math.pow(2, i).toInt, 2)
            m2 = obj.matrizAlAzar(math.pow(2, i).toInt, 2)
        } yield (obj3.compararAlgoritmos(obj.multMatrizRec, obj2.multMatrizRecParallel)(m1, m2), math.pow(2, i).toInt)
        println(prueba)
    }(Position.apply("", "", 0))
}


    
