package taller4
import org.scalameter.measure
import org.scalameter.withWarmer
import org.scalameter.Warmer
import scala.util.Random

class implAlgoritmos {     
    type Matriz = Vector [ Vector [ Int ] ]

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


def multMatriz(m1: Matriz, m2: Matriz): Matriz = {
    //calculo usando prodPunto y la transpuesta
    val l=m1.length
    Vector.tabulate(l, l)((i, j) => prodPunto(m1(i), transpuesta(m2)(j)))
}

  def sumMatriz(m1: Matriz, m2: Matriz): Matriz = {
    val l=m1.length
    Vector.tabulate(l, l)((i, j) => m1(i)(j)+m2(i)(j))
  }

  def restaMatriz(m1: Matriz, m2: Matriz): Matriz = {
    val l=m1.length
    Vector.tabulate(l, l)((i, j) => m1(i)(j)-m2(i)(j))
  }
   def subMatriz (m:Matriz , i: Int , j : Int , l : Int ) : Matriz ={
    val sub = Vector.tabulate(l/l, l/l)((is, js) => m(i)(j))
    sub
  }

  def multMatrizRec (m1:Matriz , m2: Matriz ) : Matriz ={

    def auxSumaVectorMatriz(matriz: Matriz, posicion: Int, acumuladorSuma : Vector[Vector[Int]]): Vector[Int]={
      if (posicion == matriz.length) {acumuladorSuma(0)}
      else{
        val suma = sumMatriz(subMatriz(matriz,(posicion),0,matriz.length),acumuladorSuma.appended(Vector(0)))
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

    def auxMultMatrizRec (m1:Matriz , m2: Matriz,auxMatriz: Matriz, tamanio : Int,posicionQuieta:Int,posicionCambiante:Int,auxVector: Vector[Int] ) : Matriz ={
     if (auxMatriz.length == m1.length ) {auxMatriz}
     else{
      val vectorSuma = Vector.tabulate(tamanio)((i) => prodPunto(subMatriz(m1,posicionQuieta,i,m1.length)(0), transpuesta(subMatriz(m2,i,posicionCambiante,m2.length))(0)))
      val nuevoVector= modificarVector(vectorSuma,0,vectorSuma.length,Vector())
      val aux2 = auxVector ++ auxSumaVectorMatriz(nuevoVector,0,Vector())
      
      if(aux2.length == tamanio){
        val nuevaMatriz = auxMatriz:+aux2
        auxMultMatrizRec(m1,m2,nuevaMatriz,tamanio,posicionQuieta+1,0,Vector())

      }else{
        if (posicionCambiante == tamanio-1) {auxMultMatrizRec(m1,m2,auxMatriz,tamanio,posicionQuieta+1,0,aux2)}
      else{ auxMultMatrizRec(m1,m2,auxMatriz,tamanio,posicionQuieta,posicionCambiante+1,aux2)}
      
      } 
    }
    }
    val matriz: Matriz= Vector()

    auxMultMatrizRec(m1,m2,matriz,m1.length,0,0,Vector())
  }
}

