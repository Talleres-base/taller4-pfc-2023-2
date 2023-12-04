file:///C:/Users/ALEJANDRO/github-classroom/Programacion-funcional-2023-I/taller4-pfc-2023-2/app/src/main/scala/taller4/implAlgoritmosParallel.scala
### java.lang.StringIndexOutOfBoundsException: offset 5771, count -10, length 6285

occurred in the presentation compiler.

action parameters:
offset: 5874
uri: file:///C:/Users/ALEJANDRO/github-classroom/Programacion-funcional-2023-I/taller4-pfc-2023-2/app/src/main/scala/taller4/implAlgoritmosParallel.scala
text:
```scala
package taller4

import common._

class implAlgoritmosParallel{
    type Matriz = Vector [ Vector [ Int ] ]
    val obj = new implAlgoritmos()

    def multMatrizPar(m1: Matriz, m2: Matriz): Matriz = {
    val filasM1 = m1.length
    val columnasM2 = m2(0).length

    def calcularElemento(fila: Vector[Int], columnaTranspuesta: Vector[Int]): Int = {
      obj.prodPunto(fila, columnaTranspuesta)
    }

    def crearTarea(i: Int, j: Int): Int = {
      val tarea = task {
        val fila = m1(i)
        val columnaTranspuesta = obj.transpuesta(m2)(j)
        calcularElemento(fila, columnaTranspuesta)
      }
      tarea.join
    }

    val tareas = for {
      i <- 0 until filasM1
      j <- 0 until columnasM2
    } yield crearTarea(i, j)

    val resultados = tareas.map(_.toInt).toVector
    resultados.grouped(m1.length).toVector
   }

  def multMatrizParV2(m1: Matriz, m2: Matriz): Matriz = {
    
    def bloquesTarea (bloqueM1: Matriz, transpuesta: Matriz): Matriz = {
       obj.multMatriz(bloqueM1, transpuesta)
    }

    def partirMatrizPorMitad(matriz: Matriz): (Matriz, Matriz) = {
      val mitadFilas = matriz.length / 2
      val (primeraMitad, segundaMitad) = matriz.splitAt(mitadFilas)
      (primeraMitad, segundaMitad)
    }
    val tamanoMatrices = m1.length
    val mitadTamano = tamanoMatrices / 2


    if (m1.length == 1){
      val l=m1.length
      Vector.tabulate(l, l)((i, j) => obj.prodPunto(m1(i), obj.transpuesta(m2)(j)))

    } else if (m1.length == 2) {
      val resultado = parallel((obj.prodPunto(m1(0), obj.transpuesta(m2)(0)), obj.prodPunto(m1(0), obj.transpuesta(m2)(1)))
      ,(obj.prodPunto(m1(1), obj.transpuesta(m2)(0)), obj.prodPunto(m1(1), obj.transpuesta(m2)(1))))

       (Vector(Vector(resultado._1._1, resultado._1._2), Vector(resultado._2._1, resultado._2._2)))
    } else if (m1.length == 4){
      val matrizSeparada = partirMatrizPorMitad(m1)
      val par = parallel(bloquesTarea(matrizSeparada._1, m2), bloquesTarea(matrizSeparada._2, m2))
      (par._1 ++ par._2)
    
    } else {
      val matrizEn2 = partirMatrizPorMitad(m1)
      val matriz4Partes = (partirMatrizPorMitad(matrizEn2._1), partirMatrizPorMitad(matrizEn2._2))
      val par = parallel(bloquesTarea(matriz4Partes._1._1, m2), bloquesTarea(matriz4Partes._1._2, m2), 
      bloquesTarea(matriz4Partes._2._1, m2), bloquesTarea(matriz4Partes._2._2, m2))
      (par._1 ++ par._2 ++ par._3 ++ par._4)
    }
    
  }

    def multMatrizRecParallel (m1:Matriz , m2: Matriz ) : Matriz ={

    def auxSumaVectorMatriz(matriz: Matriz, posicion: Int, acumuladorSuma : Vector[Vector[Int]]): Vector[Int]={
      if (posicion == matriz.length) {acumuladorSuma(0)}
      else{
        val suma = obj.sumMatriz(obj.subMatriz(matriz,(posicion),0,matriz.length),acumuladorSuma.appended(Vector(0)))
        auxSumaVectorMatriz(matriz,posicion+1,suma)
      }
    }

    def modificarVector(vector:Vector[Int], posicion:Int,tamanio:Int, acumulador:Vector[Vector[Int]]) :Matriz={
      if (posicion == tamanio) {acumulador}
      else{
        val nuevoVector = acumulador:+Vector(vector(posicion))
        modificarVector(vector,posicion+1,tamanio,nuevoVector)
      }
    }

    def auxMultMatrizRecParallel (m1:Matriz , m2: Matriz,auxMatriz: Matriz, tamanio : Int,posicionQuieta:Int,posicionCambiante:Int,auxVector: Vector[Int] ) : Matriz ={
     if (auxMatriz.length == m1.length ) {auxMatriz}
     else{
      val vectorSuma = task(Vector.tabulate(tamanio)((i) => obj.prodPunto(obj.subMatriz(m1,posicionQuieta,i,m1.length)(0), obj.transpuesta(obj.subMatriz(m2,i,posicionCambiante,m2.length))(0))))
      val nuevoVector= modificarVector(vectorSuma.join(),0,vectorSuma.join().length,Vector())
      val aux2 = auxVector ++ auxSumaVectorMatriz(nuevoVector,0,Vector())
      
      if(aux2.length == tamanio){
        val nuevaMatriz = auxMatriz:+aux2
        auxMultMatrizRecParallel(m1,m2,nuevaMatriz,tamanio,posicionQuieta+1,0,Vector())

      }else{
        if (posicionCambiante == tamanio-1) {auxMultMatrizRecParallel(m1,m2,auxMatriz,tamanio,posicionQuieta+1,0,aux2)}
      else{ auxMultMatrizRecParallel(m1,m2,auxMatriz,tamanio,posicionQuieta,posicionCambiante+1,aux2)}
      
      } 
    }
    }
    val matriz: Matriz= Vector()

    auxMultMatrizRecParallel(m1,m2,matriz,m1.length,0,0,Vector())
  }
  
  def strassenParallel(A: Matriz, B: Matriz): Matriz = {
    if (A.length == 1) {
      Vector(Vector(A(0)(0) * B(0)(0)))
    } else {

      val newSize = A.length

      //Divide las matrices en 4 bloques
      val mitad = newSize / 2
      val A11 = obj.subMatriz2(A,0, mitad,0, mitad)
      val A12 = obj.subMatriz2(A,0, mitad,mitad, newSize)      
      val A21 = obj.subMatriz2(A,mitad, newSize,0, mitad)      
      val A22 = obj.subMatriz2(A,mitad, newSize,mitad, newSize)

      val B11 = obj.subMatriz2(B,0, mitad,0, mitad)
      val B12 = obj.subMatriz2(B,0, mitad,mitad, newSize)
      val B21 = obj.subMatriz2(B,mitad, newSize,0, mitad)
      val B22 = obj.subMatriz2(B,mitad, newSize,mitad, newSize)


      val P1 = task(strassenParallel(A11, obj.restaMatriz(B12, B22)))
      val P2 = task(strassenParallel(obj.sumMatriz(A11, A12), B22))
      val P3 = task(strassenParallel(obj.sumMatriz(A21,A22), B11))
      val P4 = task(strassenParallel(A22, obj.restaMatriz(B21, B11)))
      val P5 = task(strassenParallel(obj.sumMatriz(A11, A22), obj.sumMatriz(B11,B22)))
      val P6 = task(strassenParallel(obj.restaMatriz(A12, A22), obj.sumMatriz(B21, B22)))
      val P7 = task(strassenParallel(obj.restaMatriz(A11, A21), obj.sumMatriz(B11, B12)))

      
      val (C11,C12,C21,C22) = parallel(obj.sumMatriz(obj.sumMatriz(P5.join(), P4.join()), obj.restaMatriz(P6.join(), P2.join()))
      val C12@@,obj.sumMatriz(P1.join(), P2.join()),obj.sumMatriz(P3.join(), P4.join()),obj.restaMatriz(obj.sumMatriz(P5.join(), P1.join()), obj.sumMatriz(P7.join(), P3.join())))

    val result: Matriz = Vector.tabulate(newSize) { i =>
      if (i < mitad) {
        Vector.concat(C11(i), C12(i))
      } else {
        Vector.concat(C21(i - mitad), C22(i - mitad))
      }
    }
      result
    }
  }

    
}
```



#### Error stacktrace:

```
java.base/java.lang.String.checkBoundsOffCount(String.java:4589)
	java.base/java.lang.String.rangeCheck(String.java:304)
	java.base/java.lang.String.<init>(String.java:300)
	scala.tools.nsc.interactive.Global.typeCompletions$1(Global.scala:1245)
	scala.tools.nsc.interactive.Global.completionsAt(Global.scala:1283)
	scala.meta.internal.pc.SignatureHelpProvider.$anonfun$treeSymbol$1(SignatureHelpProvider.scala:390)
	scala.Option.map(Option.scala:242)
	scala.meta.internal.pc.SignatureHelpProvider.treeSymbol(SignatureHelpProvider.scala:388)
	scala.meta.internal.pc.SignatureHelpProvider$MethodCall$.unapply(SignatureHelpProvider.scala:205)
	scala.meta.internal.pc.SignatureHelpProvider$MethodCallTraverser.visit(SignatureHelpProvider.scala:316)
	scala.meta.internal.pc.SignatureHelpProvider$MethodCallTraverser.traverse(SignatureHelpProvider.scala:310)
	scala.meta.internal.pc.SignatureHelpProvider$MethodCallTraverser.fromTree(SignatureHelpProvider.scala:279)
	scala.meta.internal.pc.SignatureHelpProvider.signatureHelp(SignatureHelpProvider.scala:27)
	scala.meta.internal.pc.ScalaPresentationCompiler.$anonfun$signatureHelp$1(ScalaPresentationCompiler.scala:282)
```
#### Short summary: 

java.lang.StringIndexOutOfBoundsException: offset 5771, count -10, length 6285