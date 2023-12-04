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
}