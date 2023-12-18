/**
 * Plantilla para pruebas
* @author miguel angel cebalos, Cristhian leonardo Albarracin zapata,Nicolás Gutiérrez Ramírez
* @version 1.0
* @note 22 de Noviembre de 2023 
 */
package taller4

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

import Taller4._

@RunWith(classOf[JUnitRunner])
class testBuscaCadenas extends AnyFunSuite {
  test("2 a 8") {
    val alfabeto = "acgt".toSeq

    // prueba de funcionamiento
    for (tamanioCadena <- 2 to 8) {
      val cadenaObjetivo = generarCadenaAleatoria(tamanioCadena, alfabeto)
      val buscadorCadena1 = new BuscadorCadenaSecuencial(cadenaObjetivo, alfabeto)
      val buscadorCadenasParalelo = new BuscadorCadenaParalelo(cadenaObjetivo,alfabeto)
      println(s"Pruebas con cadena de tamaño $tamanioCadena para hallar $cadenaObjetivo")

      // Caso de prueba 1: ingenua
    
      val resultadoIngenuo = buscadorCadena1.ingenua()
      assert(resultadoIngenuo == cadenaObjetivo.toSeq)
    

      // Caso de prueba 2: mejorada

      val resultadoMejorado = buscadorCadena1.mejorada()
      assert(resultadoMejorado == cadenaObjetivo.toSeq)


      // Caso de prueba 3: turbo

      val resultadoTurbo = buscadorCadena1.turbo()
      assert(resultadoTurbo == cadenaObjetivo.toSeq)


      // Caso de prueba 4: turboMejorada

      val resultadoTurboMejorada = buscadorCadena1.turboMejorada()
      assert(resultadoTurboMejorada == cadenaObjetivo.toSeq)


      // Caso de prueba 10xd: turboAcelerada
      val resultadoTurboAcelerada = buscadorCadena1.turboAcelerada()
      assert(resultadoTurboAcelerada == cadenaObjetivo.toSeq)
      

      // Caso de prueba 5: ingenuaPar
      val resultadoIngenuoPar = buscadorCadenasParalelo.ingenua()
      assert(resultadoIngenuoPar == cadenaObjetivo.toSeq)
      

      // Caso de prueba 6: mejoradaPar
      val resultadoMejoradoPar = buscadorCadenasParalelo.mejorada()
      assert(resultadoMejoradoPar == cadenaObjetivo.toSeq)
      

      // Caso de prueba 7: turboPar
      val resultadoTurboPar = buscadorCadenasParalelo.turbo()
      assert(resultadoTurboPar == cadenaObjetivo.toSeq)
      

      // Caso de prueba 6: turboMejoradaPar
      val resultadoTurboMejoradaPar = buscadorCadenasParalelo.turboMejorada()
      assert(resultadoTurboMejoradaPar == cadenaObjetivo.toSeq)
      

      // Caso de prueba 7: turboAceleradaPar
      val resultadoTurboAceleradaPar = buscadorCadenasParalelo.turboAcelerada()
      assert(resultadoTurboAceleradaPar == cadenaObjetivo.toSeq)
      
    }
  }
}