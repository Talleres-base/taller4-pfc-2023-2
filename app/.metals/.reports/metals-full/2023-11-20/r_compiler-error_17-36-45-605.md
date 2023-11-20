file://<WORKSPACE>/src/main/scala/taller4/matrices.scala
### java.lang.IndexOutOfBoundsException: 0

occurred in the presentation compiler.

action parameters:
offset: 581
uri: file://<WORKSPACE>/src/main/scala/taller4/matrices.scala
text:
```scala
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
    Vector.fill(long,long)(@@Random.nextInt(vals)
  }

  /**
  * Crea un vector al azar de dimension long y valores en el intervalo [0,vals)
  * @param long:Int
  * @param vals:Int
  * @return Vector de dimensión long con valores en el rango [0,vals)
  */

}

```



#### Error stacktrace:

```
scala.collection.LinearSeqOps.apply(LinearSeq.scala:131)
	scala.collection.LinearSeqOps.apply$(LinearSeq.scala:128)
	scala.collection.immutable.List.apply(List.scala:79)
	dotty.tools.dotc.util.Signatures$.countParams(Signatures.scala:501)
	dotty.tools.dotc.util.Signatures$.applyCallInfo(Signatures.scala:186)
	dotty.tools.dotc.util.Signatures$.computeSignatureHelp(Signatures.scala:94)
	dotty.tools.dotc.util.Signatures$.signatureHelp(Signatures.scala:63)
	scala.meta.internal.pc.MetalsSignatures$.signatures(MetalsSignatures.scala:17)
	scala.meta.internal.pc.SignatureHelpProvider$.signatureHelp(SignatureHelpProvider.scala:51)
	scala.meta.internal.pc.ScalaPresentationCompiler.signatureHelp$$anonfun$1(ScalaPresentationCompiler.scala:375)
```
#### Short summary: 

java.lang.IndexOutOfBoundsException: 0