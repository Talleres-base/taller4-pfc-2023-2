package taller4
import org.scalameter.measure
import org.scalameter.withWarmer
import org.scalameter.Warmer
import scala.util.Random
import org.scalameter.Quantity

class Benchmark {
    type Matriz = Vector[Vector[Int]]
    val obj = new implAlgoritmos()
    val obj2 = new implAlgoritmosParallel()

    def compararAlgoritmos(Funcion1:(Matriz,Matriz) => Matriz, Funcion2:(Matriz,Matriz) => Matriz)(m1: Matriz, m2: Matriz): (Double, Double, Double) = {
        val timeF1 = withWarmer(new Warmer.Default) measure {
            Funcion1(m1, m2)
        }
        val timeF2 = withWarmer(new Warmer.Default) measure {
            Funcion2(m1, m2)
        }

        val promedio = timeF1.value / timeF2.value
        (timeF1.value, timeF2.value, promedio)

    }
    def compararProdPunto(tamanoVectores: Int): (Double, Double, Double) = {
        val v1 = obj.vectorAlAzar(tamanoVectores, 10)
        val v2 = obj.vectorAlAzar(tamanoVectores, 10)
        val timeSeq = withWarmer(new Warmer.Default) measure {
            obj.prodPunto(v1, v2)
        }
        val timePar = withWarmer(new Warmer.Default) measure {
            obj2.prodPuntoParD(v1, v2)
        }

        (timeSeq.value, timePar.value, timeSeq.value / timePar.value)
    }

    def desempenoDeFunciones(tamanoMatrices: Int): Vector[Double] = {
    println("Tamanio: " + tamanoMatrices)
    val m1 = obj.matrizAlAzar(tamanoMatrices, 2)
    val m2 = obj.matrizAlAzar(tamanoMatrices, 2)
    
    val tiemposSeq = (1 to 100).map(_ => 0.0).toArray
    for (i <- 0 until 100) {
      val time = withWarmer(new Warmer.Default) measure {
        obj.multMatriz(m1, m2)
      }
      tiemposSeq(i) = time.value
    }

    val tiemposSeqPar = (1 to 100).map(_ => 0.0).toArray
    for (i <- 0 until 100) {
      val time = withWarmer(new Warmer.Default) measure {
        obj2.multMatrizParV2(m1, m2)
      }
      tiemposSeqPar(i) = time.value
    }

    val tiempoRec = (1 to 100).map(_ => 0.0).toArray
    for (i <- 0 until 100) {
        val time = withWarmer(new Warmer.Default) measure {
            obj.multMatrizRec(m1, m2)
        }
        tiempoRec(i) = time.value
    }

    val tiempoRecPar = (1 to 100).map(_ => 0.0).toArray
    for (i <- 0 until 100) {
        val time = withWarmer(new Warmer.Default) measure {
            obj2.multMatrizRecParallel(m1, m2)
        }
        tiempoRecPar(i) = time.value
    }

    val tiempoStraseen = (1 to 100).map(_ => 0.0).toArray
    for (i <- 0 until 100) {
        val time = withWarmer(new Warmer.Default) measure {
            obj.strassen(m1, m2)
        }
        tiempoStraseen(i) = time.value
    }

    val tiempoStraseenPar = (1 to 100).map(_ => 0.0).toArray
    for (i <- 0 until 100) {
        val time = withWarmer(new Warmer.Default) measure {
            obj2.strassenParallel(m1, m2)
        }
        tiempoStraseenPar(i) = time.value
    }
    Vector(tiemposSeq.sum / 100, tiemposSeqPar.sum / 100, tiempoRec.sum / 100, tiempoRecPar.sum / 100, tiempoStraseen.sum / 100, tiempoStraseenPar.sum / 100)
  }

  def desempenoDeFuncionesSecuenciales(tamanoMatrices: Int): Vector[Double] = {
    println("Tamanio: " + tamanoMatrices)
    val m1 = obj.matrizAlAzar(tamanoMatrices, 2)
    val m2 = obj.matrizAlAzar(tamanoMatrices, 2)

    val tiemposSeq = (1 to 100).map(_ => 0.0).toArray
    for (i <- 0 until 100) {
      val time = withWarmer(new Warmer.Default) measure {
        obj.multMatriz(m1, m2)
      }
      tiemposSeq(i) = time.value
    }

    val tiempoRec = (1 to 100).map(_ => 0.0).toArray
    for (i <- 0 until 100) {
        val time = withWarmer(new Warmer.Default) measure {
            obj.multMatrizRec(m1, m2)
        }
        tiempoRec(i) = time.value
    }

    val tiempoStraseen = (1 to 100).map(_ => 0.0).toArray
    for (i <- 0 until 100) {
        val time = withWarmer(new Warmer.Default) measure {
            obj.strassen(m1, m2)
        }
        tiempoStraseen(i) = time.value
    }

    Vector(tiemposSeq.sum / 100,  tiempoRec.sum / 100, tiempoStraseen.sum / 100)
  }

  def desempenoDeFuncionesParalelas(tamanoMatrices: Int): Vector[Double] = {
    println("Tamanio: " + tamanoMatrices)
    val m1 = obj.matrizAlAzar(tamanoMatrices, 2)
    val m2 = obj.matrizAlAzar(tamanoMatrices, 2)

    val tiemposParallel = (1 to 100).map(_ => 0.0).toArray
    for (i <- 0 until 100) {
      val time = withWarmer(new Warmer.Default) measure {
        obj2.multMatrizParV2(m1, m2)
      }
      tiemposParallel(i) = time.value
    }

    val tiempoRecParallel = (1 to 100).map(_ => 0.0).toArray
    for (i <- 0 until 100) {
        val time = withWarmer(new Warmer.Default) measure {
            obj2.multMatrizRecParallel(m1, m2)
        }
        tiempoRecParallel(i) = time.value
    }

    val tiempoStraseenParallel = (1 to 100).map(_ => 0.0).toArray
    for (i <- 0 until 100) {
        val time = withWarmer(new Warmer.Default) measure {
            obj2.strassenParallel(m1, m2)
        }
        tiempoStraseenParallel(i) = time.value
    }

    Vector(tiemposParallel.sum / 100,  tiempoRecParallel.sum / 100, tiempoStraseenParallel.sum / 100)
  }


  def desempenoProdPunto(tamanoVectores: Int, pow: Int): Vector[Double] = {
    println("Tamano Vectores: " + "10^" + pow)
    val v1 = obj.vectorAlAzar(tamanoVectores, 10)
    val v2 = obj.vectorAlAzar(tamanoVectores, 10)

    val tiemposSeq = (1 to 100).map(_ => 0.0).toArray
    for (i <- 0 until 100) {

      val time = withWarmer(new Warmer.Default) measure {
        obj.prodPunto(v1, v2)
      }
      tiemposSeq(i) = time.value
    }

    val tiemposSeqPar = (1 to 100).map(_ => 0.0).toArray
    for (i <- 0 until 100) {
      val time = withWarmer(new Warmer.Default) measure {
        obj2.prodPuntoParD(v1, v2)
      }
      tiemposSeqPar(i) = time.value
    }
    
    Vector(tiemposSeq.sum / 100, tiemposSeqPar.sum / 100)

  }
}