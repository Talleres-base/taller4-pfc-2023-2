file:///C:/Users/ALEJANDRO/github-classroom/Programacion-funcional-2023-I/taller4-pfc-2023-2/app/src/main/scala/taller4/Taller4.scala
### scala.reflect.internal.FatalError: no context found for source-file:///C:/Users/ALEJANDRO/github-classroom/Programacion-funcional-2023-I/taller4-pfc-2023-2/app/src/main/scala/taller4/Taller4.scala,line-4,offset=86

occurred in the presentation compiler.

action parameters:
offset: 86
uri: file:///C:/Users/ALEJANDRO/github-classroom/Programacion-funcional-2023-I/taller4-pfc-2023-2/app/src/main/scala/taller4/Taller4.scala
text:
```scala
/**
  * Taller 3 - Programación Funcional
  * Autores: <Estudiantes>
  * Profesor: @@Carlos A Delgado
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

    println(matrizAlAzar(2,3))
    println(matrizAlAzar(2,5))
    println(prodPunto(vectorAlAzar(3,3),vectorAlAzar(3,5)))
    println(transpuesta(matrizAlAzar(8,2)))
    println(multMatriz(matrizAlAzar(3,3),matrizAlAzar(3,5)))
    println(sumMatriz(matrizAlAzar(3,3),matrizAlAzar(3,5)))
    println(restaMatriz(matrizAlAzar(3,3),matrizAlAzar(3,5)))
    println(subMatriz(matrizAlAzar(4,10),0,1,2))

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

scala.reflect.internal.FatalError: no context found for source-file:///C:/Users/ALEJANDRO/github-classroom/Programacion-funcional-2023-I/taller4-pfc-2023-2/app/src/main/scala/taller4/Taller4.scala,line-4,offset=86