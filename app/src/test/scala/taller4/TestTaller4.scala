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

@RunWith(classOf[JUnitRunner])
class TestTaller4 extends AnyFunSuite {
    val obj = new implAlgoritmos()
    val obj2 = new implAlgoritmosParallel()
    val obj3 = new Benchmark()
    val A = Vector(Vector(1, 2, 3, 4), Vector(5, 7, 8, 6), Vector(10, 9, 12, 11), Vector(14, 15, 13, 16))
    val B = Vector(Vector(3, 2, 9 , 8), Vector(55, 2, 44, 19), Vector(35, 6, 5, 12), Vector(24, 5, 6, 17))
    val C = Vector(
        Vector(314, 44, 136, 150), 
        Vector(824, 102, 429, 371), 
        Vector(1209, 165, 612, 582), 
        Vector(1706, 216, 947, 825)
        )

    test("Prueba de resultados de las diferentes implementaciones para multiplicar matrices"){
        assert(obj.multMatriz(A,B) == C)
        assert(obj2.strassenParallel(A,B) == C )
        assert(obj.multMatriz(A,B) == C)
        assert(obj2.multMatrizParV2(A,B) == C)
        assert(obj2.strassenParallel(A,B) == C)
        assert(obj.multMatriz(A,B) == C)
        assert(obj2.multMatrizParV2(A,B) == C)
        assert(obj2.multMatrizRecParallel(A,B) == C)
    }

    test("Prueba de la multiplicación de matrices recursiva secuencial vs recursiva paralelo") { 
        println("Comparación de algoritmos")
        val prueba = for {
            i <- 1 to 7
            m1 = obj.matrizAlAzar(math.pow(2, i).toInt, 2)
            m2 = obj.matrizAlAzar(math.pow(2, i).toInt, 2)
        } yield (obj3.compararAlgoritmos(obj.multMatrizRec, obj2.multMatrizRecParallel)(m1, m2), math.pow(2, i).toInt)
        println(prueba)
    }

    test("Prueba de la multiplicación de matrices strassen secuencial vs strassen paralelo") { 
        println("Comparación de algoritmos")
        val prueba = for {
            i <- 1 to 7
            m1 = obj.matrizAlAzar(math.pow(2, i).toInt, 2)
            m2 = obj.matrizAlAzar(math.pow(2, i).toInt, 2)
        } yield (obj3.compararAlgoritmos(obj.strassen, obj2.strassenParallel)(m1, m2), math.pow(2, i).toInt)
        println(prueba)
    }

    
    test("Prueba de la multiplicación de matrices secuencial vs paraleloV2") { 
        println("Comparación de algoritmos")
        val prueba = for {
            i <- 1 to 7
            m1 = obj.matrizAlAzar(math.pow(2, i).toInt, 2)
            m2 = obj.matrizAlAzar(math.pow(2, i).toInt, 2)
        } yield (obj3.compararAlgoritmos(obj.multMatriz, obj2.multMatrizParV2)(m1, m2), math.pow(2, i).toInt)
        println(prueba)
    }
}


    
