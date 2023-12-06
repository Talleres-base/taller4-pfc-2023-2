file:///C:/Users/ALEJANDRO/github-classroom/Programacion-funcional-2023-I/taller4-pfc-2023-2/app/src/main/scala/taller4/Taller4.scala
### java.lang.NullPointerException: Cannot invoke "scala.reflect.internal.Types$Type.decls()" because the return value of "scala.reflect.internal.Trees$Tree.tpe()" is null

occurred in the presentation compiler.

action parameters:
offset: 453
uri: file:///C:/Users/ALEJANDRO/github-classroom/Programacion-funcional-2023-I/taller4-pfc-2023-2/app/src/main/scala/taller4/Taller4.scala
text:
```scala
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

    def inversions(lst: List[Int]):Int{
      def a@@
    }
    // val obj = new implAlgoritmos()
    // val obj2 = new implAlgoritmosParallel()
    // val obj3 = new Benchmark()
    
    // val A = Vector(Vector(1, 2, 3, 4), Vector(5, 7, 8, 6), Vector(10, 9, 12, 11), Vector(14, 15, 13, 16))
    // val B = Vector(Vector(3, 2, 9 , 8), Vector(55, 2, 44, 19), Vector(35, 6, 5, 12), Vector(24, 5, 6, 17))

    // println(obj.multMatrizRec(A,B))
    // println(obj.strassen(A,B))
    // println(obj2.strassenParallel(A,B))
    // println(obj.multMatriz(A,B))
    // println(obj2.multMatrizParV2(A,B))
    // println(obj2.multMatrizRecParallel(A,B))

    // val tiros =10000000
    // println("Comparación de productos punto")
    // println("Cantidad de tiros: " +tiros)
    // //println(obj3.compararProdPunto(tiros))
    // //println(obj3.CompararAlgoritmos(obj.multMatrizRec, obj.strassen)(obj.matrizAlAzar(32,2),obj.matrizAlAzar(32,2)))
    
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
    //     obj2.multMatrizRecParallel(m1, m2)
    //   }
    //   promedioRecParallel(i) = time.value
    //   println(" Repetición " + i + " tiempo: " + time)
    // }

    // println("El promedio normal es: " + promedioNormal.sum / 100 + " ms")
    // println("El promedio normal paralelo v2 es: " + promedioNormalPar2.sum / 100 + " ms")
    // println("El promedio multiRec es: " + promedioRec.sum / 100 + " ms")
    // println("El promedio multiRec paralelo es: " + promedioRecParallel.sum / 100 + " ms")
    // println("El promedio strassenPal es: " + promedioParallelStrassen.sum / 100 + " ms")
    // println("El promedio strassen es: " + strassenTime.sum / 100 + " ms")
   
  }

 }

```



#### Error stacktrace:

```
scala.meta.internal.pc.completions.OverrideCompletions.scala$meta$internal$pc$completions$OverrideCompletions$$getMembers(OverrideCompletions.scala:180)
	scala.meta.internal.pc.completions.OverrideCompletions$OverrideCompletion.contribute(OverrideCompletions.scala:79)
	scala.meta.internal.pc.CompletionProvider.expected$1(CompletionProvider.scala:439)
	scala.meta.internal.pc.CompletionProvider.safeCompletionsAt(CompletionProvider.scala:499)
	scala.meta.internal.pc.CompletionProvider.completions(CompletionProvider.scala:58)
	scala.meta.internal.pc.ScalaPresentationCompiler.$anonfun$complete$1(ScalaPresentationCompiler.scala:187)
```
#### Short summary: 

java.lang.NullPointerException: Cannot invoke "scala.reflect.internal.Types$Type.decls()" because the return value of "scala.reflect.internal.Trees$Tree.tpe()" is null