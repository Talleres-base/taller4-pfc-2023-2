file:///C:/Users/ALEJANDRO/github-classroom/Programacion-funcional-2023-I/taller4-pfc-2023-2/app/src/main/scala/taller4/Taller4.scala
### scala.reflect.internal.FatalError: no context found for source-file:///C:/Users/ALEJANDRO/github-classroom/Programacion-funcional-2023-I/taller4-pfc-2023-2/app/src/main/scala/taller4/Taller4.scala,line-4,offset=80

occurred in the presentation compiler.

action parameters:
offset: 80
uri: file:///C:/Users/ALEJANDRO/github-classroom/Programacion-funcional-2023-I/taller4-pfc-2023-2/app/src/main/scala/taller4/Taller4.scala
text:
```scala
/**
  * Taller 3 - Programación Funcional
  * Autores: <Estudiantes>
  * Prof@@esor: Carlos A Delgado
  */
package taller4

import org.scalameter.measure
import org.scalameter.withWarmer
import org.scalameter.Warmer
import scala.util.Random

object Taller4{

 type Matriz = Vector [ Vector [ Int ] ]

  def saludo() = "Taller 4 2023-II"

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

  def main(args: Array[String]): Unit = {

    println(matrizAlAzar(8,2))
    println(vectorAlAzar(8,2))

    // println(saludo())
    // println(
    //   withWarmer(new Warmer.Default) measure {
    //     (1 to 100000000).toArray
    //   } // ) 
  }

 }

```



#### Error stacktrace:

```
scala.tools.nsc.interactive.CompilerControl.$anonfun$doLocateContext$1(CompilerControl.scala:100)
	scala.tools.nsc.interactive.CompilerControl.doLocateContext(CompilerControl.scala:100)
	scala.tools.nsc.interactive.CompilerControl.doLocateContext$(CompilerControl.scala:99)
	scala.tools.nsc.interactive.Global.doLocateContext(Global.scala:114)
	scala.meta.internal.pc.PcDefinitionProvider.definitionTypedTreeAt(PcDefinitionProvider.scala:151)
	scala.meta.internal.pc.PcDefinitionProvider.definition(PcDefinitionProvider.scala:68)
	scala.meta.internal.pc.PcDefinitionProvider.definition(PcDefinitionProvider.scala:16)
	scala.meta.internal.pc.ScalaPresentationCompiler.$anonfun$definition$1(ScalaPresentationCompiler.scala:321)
```
#### Short summary: 

scala.reflect.internal.FatalError: no context found for source-file:///C:/Users/ALEJANDRO/github-classroom/Programacion-funcional-2023-I/taller4-pfc-2023-2/app/src/main/scala/taller4/Taller4.scala,line-4,offset=80