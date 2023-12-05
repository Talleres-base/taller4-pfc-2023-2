/**
 * Plantilla para pruebas
* @author miguel angel cebalos, Cristhian leonardo Albarracin zapata,Nicolás Gutiérrez Ramírez
* @version 1.0
* @note 22 de Noviembre de 2023 
 */
package taller4

import org.junit.runner.RunWith
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.junit.JUnitRunner
// Importar el objeto Taller4 que contiene la función multMatriz y las funciones auxiliares
import Taller4._

@RunWith(classOf[JUnitRunner])
class testMultMatriz extends AnyFunSuite {
  // Definir una función para mostrar las matrices de forma más legible

  // Prueba 1: matrices de 4x4
  test("Prueba1") {
    //val obj = new taller4()
    // Crear las matrices de 4x4 usando vectores inventados
    val m1 = Vector(Vector(1, 2, 3, 4), Vector(5, 6, 7, 8), Vector(9, 10, 11, 12), Vector(13, 14, 15, 16))
    val m2 = Vector(Vector(4, 3, 2, 1), Vector(8, 7, 6, 5), Vector(12, 11, 10, 9), Vector(16, 15, 14, 13))
    // Definir el resultado esperado de la multiplicación
    val esperado = Vector(Vector(120, 110, 100, 90), Vector(280, 254, 228, 202), Vector(440, 398, 356, 314), Vector(600, 542, 484, 426))
    if (multMatriz(m1, m2) != esperado) {
      throw new Exception(s"\nEl resultado de multMatrizPar no coincide con el esperado")
    }
    if (multMatrizPar(m1, m2) != esperado) {
      throw new Exception(s"\nEl resultado de multMatrizPar no coincide con el esperado")
    }
    if (multMatrizRec(m1, m2) != esperado) {
      throw new Exception(s"\nEl resultado de multMatrizRec no coincide con el esperado.${multMatrizRec(m1, m2)}")
    }
    if (multMatrizRecPar(m1, m2) != esperado) {
      throw new Exception(s"\nEl resultado de multMatrizRecPar no coincide con el esperado")
    }
    if (multStrass(m1, m2) != esperado) {
      throw new Exception(s"\nEl resultado de multStrass no coincide con el esperado")
    }
    if (multStrassPar(m1, m2) != esperado) {
      throw new Exception(s"\nEl resultado de multStrassPar no coincide con el esperado")
    }
  }

    // Prueba 2: matrices de 8x8
  test("Prueba2") {
    //val obj = new taller4()
    // Crear las matrices de 4x4 usando vectores inventados
    val m1 = Vector(Vector(3, 2, 7, 8, 3, 4, 2, 3), Vector(0, 6, 9, 0, 3, 7, 4, 8), Vector(2, 6, 2, 1, 9, 9, 6, 9), Vector(5, 4, 8, 0, 1, 2, 0, 3), Vector(6, 5, 8, 8, 0, 3, 4, 5), Vector(4, 3, 4, 2, 0, 2, 0, 8), Vector(9, 2, 2, 8, 4, 5, 4, 9), Vector(7, 0, 0, 3, 1, 0, 2, 1))
    val m2 = Vector(Vector(6, 8, 3, 5, 9, 5, 5, 5), Vector(9, 8, 5, 3, 9, 3, 3, 8), Vector(8, 5, 9, 7, 9, 6, 3, 0), Vector(9, 1, 8, 6, 8, 2, 0, 0), Vector(1, 2, 4, 4, 9, 2, 8, 3), Vector(7, 4, 3, 2, 2, 2, 3, 6), Vector(1, 1, 9, 9, 6, 1, 2, 1), Vector(3, 1, 6, 6, 8, 0, 0, 5))
    // Definir el resultado esperado de la multiplicación
    val esperado = Vector(Vector(206, 110, 206, 174, 243, 95, 82, 81), Vector(206, 139, 228, 191, 264, 96, 98, 143), Vector(196, 144, 233, 210, 305, 84, 145, 190), Vector(154, 125, 135, 119, 190, 91, 75, 87), Vector(257, 157, 254, 221, 305, 119, 86, 117), Vector(139, 94, 133, 121, 183, 61, 47, 96), Vector(230, 147, 240, 229, 323, 101, 112, 152), Vector(75, 64, 73, 81, 116, 45, 47, 45))
    if (multMatriz(m1, m2) != esperado) {
      throw new Exception(s"\nEl resultado de multMatrizPar no coincide con el esperado")
    }
    if (multMatrizPar(m1, m2) != esperado) {
      throw new Exception(s"\nEl resultado de multMatrizPar no coincide con el esperado")
    }
    if (multMatrizRec(m1, m2) != esperado) {
      throw new Exception(s"\nEl resultado de multMatrizRec no coincide con el esperado.${multMatrizRec(m1, m2)} 0 ${esperado}")
    }
    if (multMatrizRecPar(m1, m2) != esperado) {
      throw new Exception(s"\nEl resultado de multMatrizRec no coincide con el esperado.${multMatrizRec(m1, m2)} 0 ${esperado}")
    }
    if (multStrass(m1, m2) != esperado) {
      throw new Exception(s"\nEl resultado de multStrass no coincide con el esperado")
    }
    if (multStrassPar(m1, m2) != esperado) {
      throw new Exception(s"\nEl resultado de multStrassPar no coincide con el esperado")
    }
  }

  // Prueba 3: matrices de 16x16
  test("Prueba3") {
    // Crear las matrices de 4x4 usando vectores inventados
    val m1 = Vector(Vector(2, 5, 3, 5, 5, 4, 2, 4, 1, 3, 4, 3, 5, 6, 3, 0), Vector(3, 0, 7, 3, 3, 5, 0, 6, 0, 6, 6, 1, 3, 2, 5, 1), Vector(2, 0, 5, 3, 3, 0, 4, 1, 2, 6, 2, 4, 5, 0, 5, 4), Vector(7, 2, 3, 1, 7, 3, 1, 0, 6, 1, 1, 4, 3, 7, 3, 3), Vector(4, 5, 0, 3, 3, 6, 5, 7, 3, 1, 0, 3, 1, 0, 6, 0), Vector(0, 6, 0, 4, 1, 2, 0, 3, 0, 7, 6, 4, 6, 1, 0, 4), Vector(6, 2, 3, 4, 4, 7, 1, 2, 1, 6, 5, 1, 5, 4, 2, 5), Vector(3, 6, 3, 3, 7, 4, 2, 5, 7, 6, 0, 2, 2, 3, 6, 6), Vector(5, 3, 4, 7, 6, 5, 7, 6, 6, 6, 1, 4, 5, 3, 3, 1), Vector(3, 7, 1, 3, 7, 0, 4, 7, 7, 4, 6, 2, 2, 6, 6, 2), Vector(5, 1, 7, 7, 3, 7, 6, 0, 1, 0, 6, 6, 7, 2, 3, 3), Vector(2, 3, 6, 4, 2, 3, 6, 2, 1, 7, 3, 0, 4, 4, 0, 2), Vector(5, 4, 3, 4, 4, 4, 3, 3, 5, 1, 3, 0, 3, 0, 2, 5), Vector(0, 4, 6, 6, 2, 5, 2, 0, 3, 7, 6, 7, 6, 7, 0, 1), Vector(1, 6, 2, 5, 1, 1, 7, 0, 6, 6, 1, 0, 2, 0, 0, 5), Vector(2, 0, 2, 5, 3, 7, 7, 4, 5, 7, 5, 4, 1, 7, 3, 4))
    val m2 = Vector(Vector(7, 1, 1, 7, 4, 0, 1, 5, 5, 6, 4, 6, 0, 6, 1, 6), Vector(4, 6, 1, 1, 0, 4, 7, 0, 1, 5, 6, 4, 3, 3, 3, 6), Vector(4, 7, 6, 3, 4, 6, 5, 4, 3, 1, 6, 4, 7, 4, 7, 4), Vector(0, 6, 4, 6, 1, 7, 2, 5, 6, 2, 4, 3, 7, 4, 1, 1), Vector(6, 4, 6, 2, 2, 7, 6, 1, 7, 2, 6, 0, 3, 1, 1, 2), Vector(4, 4, 1, 1, 1, 7, 4, 1, 2, 3, 0, 5, 7, 4, 0, 5), Vector(1, 7, 7, 1, 5, 2, 4, 0, 2, 1, 7, 4, 1, 7, 2, 4), Vector(4, 5, 1, 4, 5, 3, 2, 2, 0, 1, 4, 1, 5, 3, 2, 7), Vector(6, 5, 0, 0, 7, 1, 0, 2, 7, 4, 4, 2, 5, 3, 2, 7), Vector(6, 0, 2, 0, 0, 0, 4, 7, 0, 3, 5, 2, 5, 2, 3, 4), Vector(3, 2, 2, 3, 3, 2, 6, 1, 1, 3, 2, 0, 4, 7, 6, 6), Vector(7, 6, 7, 2, 1, 7, 6, 1, 0, 0, 3, 5, 5, 0, 1, 5), Vector(0, 6, 3, 2, 1, 5, 1, 6, 6, 2, 1, 2, 0, 1, 0, 4), Vector(2, 3, 4, 0, 2, 7, 2, 2, 2, 2, 2, 4, 2, 2, 5, 3), Vector(7, 4, 0, 3, 6, 4, 6, 7, 7, 4, 6, 3, 0, 3, 5, 1), Vector(7, 6, 5, 2, 4, 4, 2, 6, 6, 5, 3, 7, 0, 4, 6, 0))
    // Definir el resultado esperado de la multiplicación
    val esperado = Vector(Vector(200, 244, 171, 127, 126, 261, 213, 157, 175, 137, 207, 157, 199, 169, 143, 224), Vector(218, 200, 139, 138, 144, 209, 199, 190, 154, 129, 193, 139, 207, 179, 166, 210), Vector(205, 212, 170, 108, 137, 178, 172, 191, 177, 116, 201, 147, 142, 146, 140, 159), Vector(253, 218, 167, 116, 159, 229, 171, 157, 223, 158, 198, 182, 150, 155, 137, 208), Vector(210, 221, 113, 122, 152, 188, 180, 122, 155, 132, 202, 153, 162, 164, 91, 212), Vector(168, 186, 129, 92, 69, 175, 174, 150, 109, 122, 149, 127, 159, 132, 119, 184), Vector(244, 225, 167, 144, 138, 238, 198, 209, 203, 177, 196, 195, 195, 204, 158, 225), Vector(319, 289, 178, 132, 199, 259, 234, 217, 254, 200, 280, 208, 217, 195, 181, 252), Vector(287, 329, 230, 172, 207, 292, 241, 221, 254, 181, 299, 220, 266, 237, 157, 302), Vector(293, 286, 179, 143, 215, 250, 253, 183, 233, 193, 292, 174, 210, 222, 199, 289), Vector(231, 315, 241, 177, 170, 305, 238, 197, 234, 156, 228, 226, 228, 239, 166, 246), Vector(167, 217, 174, 101, 119, 192, 175, 161, 141, 122, 203, 155, 182, 181, 148, 196), Vector(212, 229, 137, 130, 157, 187, 161, 153, 204, 158, 196, 164, 161, 187, 129, 202), Vector(222, 276, 221, 115, 119, 294, 238, 185, 169, 141, 213, 193, 262, 185, 177, 256), Vector(166, 212, 140, 76, 122, 137, 143, 137, 155, 134, 200, 149, 148, 165, 119, 170), Vector(269, 277, 215, 128, 192, 268, 227, 194, 200, 166, 245, 213, 248, 236, 185, 263))
    if (multMatriz(m1, m2) != esperado) {
      throw new Exception(s"\nEl resultado de multMatrizPar no coincide con el esperado")
    }
    if (multMatrizPar(m1, m2) != esperado) {
      throw new Exception(s"\nEl resultado de multMatrizPar no coincide con el esperado")
    }
    if (multMatrizRec(m1, m2) != esperado) {
      throw new Exception(s"\nEl resultado de multMatrizRec no coincide con el esperado")
    }
    if (multMatrizRecPar(m1, m2) != esperado) {
      throw new Exception(s"\nEl resultado de multMatrizRecPar no coincide con el esperado")
    }
    if (multStrass(m1, m2) != esperado) {
      throw new Exception(s"\nEl resultado de multStrass no coincide con el esperado")
    }
    if (multStrassPar(m1, m2) != esperado) {
      throw new Exception(s"\nEl resultado de multStrassPar no coincide con el esperado")
    }
  }

  // Prueba 4: matrices de 32x32
  test("Prueba4") {
    //val obj = new taller4()
    // Crear las matrices de 32x32 usando el espacio vacío
    val m1 = 
      Vector(Vector(2, 0, 1, 3, 3, 3, 0, 0, 0, 1, 0, 2, 3, 3, 0, 0, 0, 2, 2, 0, 1, 0, 3, 2, 2, 1, 2, 0, 3, 0, 3, 1), Vector(2, 0, 2, 0, 0, 1, 0, 0, 0, 1, 3, 0, 2, 2, 0, 1, 1, 1, 3, 0, 3, 2, 1, 2, 3, 3, 2, 2, 2, 3, 1, 1), Vector(2, 1, 2, 1, 1, 1, 3, 3, 2, 0, 0, 0, 3, 2, 1, 2, 2, 3, 0, 0, 1, 1, 3, 3, 3, 0, 3, 0, 2, 1, 3, 3), Vector(2, 0, 2, 2, 1, 2, 2, 2, 1, 3, 1, 3, 0, 1, 0, 1, 1, 3, 1, 3, 0, 0, 2, 1, 3, 3, 1, 3, 0, 3, 
        0, 1), Vector(3, 0, 1, 2, 1, 2, 3, 3, 2, 3, 0, 1, 1, 2, 2, 3, 2, 2, 0, 0, 3, 2, 2, 3, 3, 1, 2, 3, 0, 3, 3, 2), Vector(2, 0, 1, 1, 3, 1, 3, 3, 1, 2, 3, 2, 2, 1, 1, 0, 0, 3, 0, 0, 2, 2, 0, 2, 1, 1, 1, 0, 3, 0, 
        2, 1), Vector(3, 2, 2, 3, 2, 2, 2, 3, 0, 0, 2, 0, 2, 3, 2, 1, 3, 1, 1, 2, 2, 0, 0, 3, 2, 1, 1, 2, 0, 0, 0, 2), Vector(1, 1, 2, 2, 2, 1, 2, 2, 3, 2, 3, 0, 0, 0, 3, 2, 0, 1, 2, 0, 2, 3, 2, 1, 0, 2, 0, 2, 1, 3, 
        2, 0), Vector(2, 0, 3, 2, 2, 3, 2, 0, 1, 0, 3, 2, 1, 3, 0, 1, 0, 0, 3, 2, 3, 0, 2, 3, 3, 2, 0, 1, 0, 2, 0, 1), Vector(2, 2, 1, 0, 0, 2, 1, 1, 0, 0, 0, 0, 2, 1, 3, 0, 2, 3, 2, 2, 2, 3, 0, 1, 3, 1, 3, 0, 1, 2, 
        0, 2), Vector(3, 2, 1, 0, 3, 2, 0, 0, 3, 3, 2, 3, 3, 0, 0, 3, 1, 1, 1, 3, 3, 3, 2, 2, 0, 2, 1, 2, 3, 2, 1, 0), Vector(1, 1, 2, 1, 2, 1, 0, 0, 0, 0, 0, 2, 3, 1, 3, 2, 2, 1, 2, 1, 0, 2, 1, 3, 1, 2, 0, 3, 2, 2, 
        1, 1), Vector(2, 2, 0, 3, 1, 0, 0, 3, 0, 1, 0, 2, 2, 0, 3, 3, 0, 3, 1, 2, 1, 2, 2, 1, 3, 0, 1, 3, 0, 2, 2, 3), Vector(1, 1, 1, 1, 1, 3, 2, 1, 1, 3, 3, 3, 2, 2, 1, 3, 3, 3, 3, 2, 3, 3, 2, 0, 3, 3, 0, 1, 0, 3, 
        1, 3), Vector(3, 0, 3, 2, 0, 1, 1, 2, 0, 1, 0, 2, 3, 1, 3, 0, 3, 1, 3, 0, 2, 0, 1, 3, 1, 0, 3, 3, 3, 0, 3, 0), Vector(1, 1, 1, 3, 0, 3, 3, 0, 0, 1, 3, 2, 1, 0, 3, 3, 0, 2, 1, 3, 2, 2, 0, 2, 1, 1, 2, 1, 1, 1, 
        3, 2), Vector(3, 2, 2, 0, 1, 3, 0, 3, 3, 3, 1, 3, 2, 1, 1, 1, 0, 2, 1, 2, 2, 3, 2, 0, 3, 2, 0, 3, 3, 0, 0, 0), Vector(2, 3, 0, 1, 1, 3, 1, 2, 2, 0, 2, 0, 1, 2, 0, 3, 1, 1, 0, 0, 3, 0, 3, 0, 1, 2, 2, 2, 1, 0, 
        1, 3), Vector(1, 1, 3, 0, 0, 1, 2, 1, 2, 2, 2, 1, 3, 1, 2, 1, 3, 2, 0, 0, 1, 0, 2, 1, 0, 3, 3, 1, 0, 3, 0, 1), Vector(3, 2, 2, 0, 0, 3, 1, 2, 3, 0, 2, 2, 1, 0, 1, 2, 1, 0, 1, 1, 3, 0, 0, 3, 2, 0, 3, 1, 2, 1, 
        3, 1), Vector(3, 1, 1, 3, 0, 0, 2, 0, 3, 0, 2, 1, 0, 0, 1, 3, 2, 2, 0, 0, 2, 3, 3, 0, 3, 0, 1, 0, 2, 0, 3, 0), Vector(3, 3, 3, 2, 2, 2, 0, 3, 0, 3, 0, 0, 1, 0, 0, 0, 2, 1, 3, 0, 0, 0, 0, 3, 0, 0, 1, 3, 0, 0, 
        0, 2), Vector(3, 0, 1, 3, 3, 2, 3, 3, 0, 0, 2, 2, 0, 2, 2, 2, 1, 1, 2, 0, 3, 2, 3, 1, 0, 3, 2, 2, 1, 1, 3, 3), Vector(3, 1, 1, 3, 0, 2, 3, 1, 2, 2, 0, 1, 0, 0, 0, 0, 2, 1, 3, 0, 3, 2, 3, 2, 1, 2, 2, 3, 1, 2, 
        0, 2), Vector(3, 1, 2, 2, 2, 1, 3, 3, 2, 1, 1, 1, 1, 1, 2, 0, 1, 0, 1, 0, 0, 0, 1, 3, 3, 1, 2, 0, 3, 1, 3, 3), Vector(2, 0, 0, 2, 3, 1, 0, 2, 0, 0, 1, 3, 2, 1, 3, 3, 0, 2, 3, 2, 2, 1, 2, 0, 0, 1, 2, 0, 3, 0, 
        2, 1), Vector(0, 0, 0, 3, 1, 1, 3, 3, 0, 2, 1, 2, 2, 1, 1, 2, 2, 1, 0, 0, 3, 0, 3, 0, 3, 2, 2, 3, 1, 0, 3, 3), Vector(0, 2, 3, 0, 3, 0, 1, 2, 0, 0, 3, 1, 3, 3, 3, 1, 1, 3, 0, 2, 3, 3, 0, 0, 2, 3, 1, 3, 1, 3, 
        1, 3), Vector(0, 2, 1, 2, 1, 3, 1, 2, 1, 0, 0, 1, 2, 0, 2, 3, 1, 3, 0, 3, 2, 1, 2, 3, 3, 2, 0, 2, 0, 2, 2, 2), Vector(3, 3, 2, 0, 0, 0, 2, 2, 0, 1, 2, 2, 0, 3, 0, 3, 1, 1, 3, 1, 1, 2, 1, 2, 1, 2, 3, 3, 2, 0, 
        3, 3), Vector(1, 2, 2, 3, 0, 1, 0, 1, 1, 3, 2, 0, 2, 2, 3, 2, 3, 2, 1, 0, 3, 1, 1, 0, 0, 1, 3, 0, 1, 2, 3, 2), Vector(2, 2, 1, 3, 2, 3, 0, 1, 0, 1, 2, 1, 3, 3, 2, 3, 3, 0, 3, 2, 0, 3, 2, 1, 0, 0, 2, 2, 1, 0, 
        3, 1)
        )
    val m2 = Vector(Vector(3, 0, 3, 1, 3, 3, 3, 2, 3, 0, 0, 0, 2, 0, 1, 3, 3, 0, 3, 3, 3, 3, 1, 2, 2, 2, 0, 1, 2, 0, 3, 0), Vector(2, 2, 0, 2, 0, 3, 1, 3, 1, 0, 1, 1, 2, 2, 3, 3, 1, 2, 1, 1, 0, 0, 3, 2, 0, 2, 3, 
        3, 1, 3, 0, 3), Vector(2, 1, 2, 0, 1, 0, 3, 3, 2, 2, 3, 0, 3, 2, 0, 3, 0, 3, 2, 3, 0, 3, 3, 2, 1, 2, 3, 3, 2, 3, 1, 2), Vector(0, 2, 3, 0, 2, 1, 0, 2, 3, 1, 2, 0, 0, 3, 0, 2, 1, 2, 0, 2, 1, 3, 0, 3, 0, 1, 1, 
        3, 1, 2, 2, 2), Vector(2, 3, 3, 1, 0, 2, 2, 2, 1, 0, 1, 2, 0, 2, 2, 3, 2, 2, 3, 3, 2, 0, 2, 2, 1, 2, 2, 3, 1, 2, 2, 1), Vector(3, 3, 3, 1, 1, 1, 0, 2, 1, 3, 1, 0, 0, 2, 2, 0, 1, 0, 1, 2, 1, 3, 2, 2, 2, 0, 0, 
        1, 1, 3, 2, 3), Vector(0, 0, 0, 3, 2, 3, 3, 1, 1, 0, 2, 3, 2, 0, 3, 1, 0, 2, 1, 2, 3, 1, 3, 1, 3, 0, 2, 3, 0, 2, 0, 0), Vector(2, 3, 2, 2, 1, 0, 3, 2, 1, 3, 1, 0, 1, 2, 3, 0, 2, 1, 2, 2, 1, 2, 0, 3, 1, 0, 2, 
        3, 1, 0, 3, 3), Vector(0, 1, 3, 3, 2, 2, 1, 3, 1, 0, 3, 2, 3, 2, 1, 2, 3, 1, 2, 2, 2, 1, 0, 1, 3, 0, 3, 0, 1, 1, 0, 0), Vector(2, 3, 1, 0, 0, 0, 1, 2, 1, 1, 2, 0, 1, 3, 0, 1, 1, 0, 3, 3, 1, 1, 2, 0, 3, 2, 1, 
        0, 3, 2, 1, 2), Vector(3, 2, 1, 1, 0, 1, 0, 3, 1, 0, 2, 1, 2, 0, 1, 0, 1, 1, 2, 0, 2, 2, 0, 2, 2, 2, 1, 2, 3, 1, 3, 2), Vector(0, 0, 2, 3, 3, 3, 0, 0, 3, 0, 0, 1, 0, 1, 3, 1, 0, 2, 2, 1, 3, 0, 2, 1, 3, 1, 0, 
        3, 0, 2, 1, 1), Vector(2, 1, 3, 1, 3, 2, 2, 3, 0, 2, 0, 3, 1, 1, 3, 2, 0, 0, 1, 3, 3, 2, 1, 2, 1, 1, 3, 3, 0, 1, 1, 0), Vector(3, 3, 1, 3, 0, 1, 0, 0, 2, 0, 1, 3, 2, 2, 3, 3, 0, 3, 2, 0, 0, 2, 0, 2, 0, 1, 0, 
        0, 2, 2, 0, 2), Vector(0, 0, 1, 2, 2, 0, 0, 0, 2, 2, 3, 0, 1, 2, 2, 2, 2, 2, 2, 1, 1, 3, 3, 0, 3, 2, 0, 0, 0, 3, 2, 1), Vector(1, 0, 0, 2, 3, 3, 3, 1, 1, 0, 0, 3, 0, 1, 2, 3, 0, 3, 0, 2, 0, 2, 2, 0, 3, 3, 0, 
        2, 1, 0, 1, 2), Vector(3, 2, 3, 2, 1, 0, 0, 2, 3, 2, 2, 0, 2, 0, 1, 1, 2, 1, 3, 3, 3, 2, 3, 1, 1, 3, 1, 2, 3, 1, 3, 3), Vector(2, 2, 3, 2, 2, 0, 1, 0, 1, 2, 0, 3, 2, 2, 2, 1, 3, 1, 1, 3, 3, 0, 1, 1, 0, 2, 1, 
        0, 3, 2, 1, 2), Vector(0, 0, 1, 2, 1, 0, 0, 2, 3, 0, 3, 1, 3, 3, 3, 2, 2, 0, 1, 1, 2, 0, 3, 0, 3, 2, 3, 0, 0, 1, 0, 2), Vector(0, 2, 0, 3, 3, 2, 2, 2, 3, 2, 2, 3, 1, 3, 0, 1, 3, 0, 0, 0, 2, 3, 3, 3, 0, 1, 0, 
        3, 1, 2, 1, 2), Vector(2, 3, 1, 1, 0, 0, 1, 3, 0, 3, 2, 3, 1, 1, 0, 0, 0, 1, 3, 3, 3, 2, 3, 2, 0, 0, 2, 0, 2, 0, 1, 2), Vector(3, 2, 3, 0, 3, 2, 0, 2, 3, 2, 3, 3, 0, 3, 2, 1, 0, 1, 3, 1, 1, 0, 3, 1, 1, 3, 3, 
        3, 1, 0, 3, 3), Vector(3, 2, 3, 3, 2, 2, 3, 2, 0, 1, 2, 1, 1, 2, 2, 2, 3, 3, 0, 2, 3, 3, 0, 2, 3, 1, 2, 3, 0, 2, 0, 1), Vector(1, 2, 3, 1, 1, 0, 1, 0, 0, 0, 3, 1, 0, 1, 1, 3, 0, 3, 2, 1, 1, 0, 1, 2, 3, 3, 1, 
        1, 0, 1, 2, 1), Vector(2, 1, 1, 2, 3, 0, 0, 2, 0, 2, 0, 0, 0, 0, 2, 3, 0, 3, 3, 0, 3, 1, 2, 1, 0, 1, 0, 1, 0, 1, 2, 2), Vector(2, 0, 2, 0, 3, 3, 2, 0, 1, 1, 1, 1, 2, 0, 2, 1, 2, 1, 0, 2, 1, 2, 1, 2, 1, 1, 1, 
        3, 0, 2, 3, 0), Vector(2, 0, 3, 2, 0, 3, 1, 0, 2, 2, 0, 2, 2, 0, 2, 1, 3, 3, 2, 2, 2, 1, 0, 0, 3, 1, 0, 1, 0, 2, 2, 0), Vector(2, 2, 1, 2, 1, 3, 1, 0, 3, 1, 1, 1, 0, 1, 3, 1, 2, 2, 1, 3, 0, 2, 3, 0, 0, 1, 0, 
        2, 1, 3, 2, 3), Vector(1, 2, 0, 2, 2, 2, 0, 1, 2, 3, 2, 3, 0, 3, 1, 0, 1, 3, 0, 3, 0, 0, 2, 1, 3, 0, 0, 2, 1, 0, 0, 2), Vector(1, 2, 1, 3, 1, 2, 0, 1, 2, 1, 3, 0, 3, 1, 3, 1, 0, 3, 0, 0, 1, 1, 3, 1, 1, 2, 2, 
        3, 2, 1, 3, 1), Vector(0, 1, 2, 3, 1, 3, 0, 0, 1, 1, 0, 2, 1, 2, 3, 2, 3, 0, 1, 1, 1, 0, 0, 0, 3, 1, 0, 0, 0, 3, 1, 1), Vector(1, 0, 2, 2, 0, 2, 3, 3, 2, 0, 3, 0, 0, 1, 1, 0, 1, 1, 3, 1, 0, 3, 2, 3, 3, 1, 3, 
        0, 2, 2, 3, 3))
    // Definir el resultado esperado de la multiplicación 
    val esperado = Vector(
      Vector(71, 68, 94, 71, 63, 65, 43, 59, 60, 52, 50, 62, 40, 72, 79, 75, 59, 69, 63, 82, 72, 60, 52, 65, 75, 51, 44, 65, 37, 72, 55, 61),
        Vector(83, 63, 76, 66, 62, 61, 42, 67, 65, 55, 69, 59, 60, 54, 78, 65, 47, 72, 71, 73, 68, 64, 76, 57, 67, 65, 55, 67, 52, 57, 76, 70),
        Vector(84, 71, 105, 99, 78, 78, 75, 78, 65, 65, 71, 76, 61, 69, 98, 87, 70, 92, 85, 96, 86, 77, 71, 76, 94, 67, 69, 81, 51, 76, 76, 77),
        Vector(75, 71, 85, 84, 80, 73, 62, 65, 80, 54, 67, 50, 59, 67, 84, 70, 67, 76, 68, 83, 80, 79, 82, 70, 70, 63, 49, 90, 57, 82, 80, 77),
        Vector(96, 90, 113, 105, 88, 89, 75, 82, 86, 71, 87, 74, 65, 80, 109, 94, 75, 98, 103, 110, 94, 94, 97, 77, 102, 82, 67, 89, 67, 89, 101, 95),
        Vector(71, 71, 84, 68, 63, 63, 53, 66, 59, 55, 61, 70, 46, 65, 77, 58, 54, 63, 80, 86, 76, 53, 63, 66, 78, 54, 55, 73, 52, 60, 70, 65),
        Vector(85, 78, 90, 77, 65, 62, 64, 81, 78, 57, 73, 56, 56, 64, 82, 82, 60, 76, 86, 87, 75, 91, 82, 86, 63, 69, 58, 84, 59, 77, 86, 87),
        Vector(69, 72, 81, 74, 67, 70, 53, 75, 71, 51, 89, 60, 63, 78, 83, 70, 63, 73, 69, 83, 65, 69, 81, 59, 84, 68, 70, 82, 53, 71, 75, 74),
        Vector(76, 71, 82, 77, 68, 63, 55, 79, 68, 45, 78, 58, 59, 63, 78, 80, 46, 79, 73, 71, 79, 81, 80, 79, 71, 61, 59, 81, 49, 73, 70, 72),
        Vector(72, 56, 77, 71, 66, 54, 42, 65, 69, 65, 65, 57, 55, 59, 77, 61, 55, 62, 74, 68, 72, 63, 85, 58, 59, 62, 55, 62, 46, 62, 73, 72),
        Vector(91, 87, 99, 88, 90, 99, 66, 92, 84, 62, 81, 89, 60, 87, 90, 83, 72, 77, 84, 107, 89, 74, 99, 75, 95, 80, 70, 102, 63, 74, 80, 83),
        Vector(64, 57, 79, 70, 74, 67, 45, 55, 74, 49, 69, 56, 43, 66, 84, 76, 49, 74, 61, 77, 58, 62, 86, 55, 70, 72, 52, 81, 38, 70, 70, 70),
        Vector(67, 65, 85, 87, 82, 76, 61, 69, 78, 57, 63, 58, 41, 76, 93, 78, 67, 76, 72, 79, 72, 76, 82, 67, 71, 71, 56, 82, 47, 75, 82, 86),
        Vector(104, 91, 106, 105, 96, 88, 67, 102, 96, 71, 95, 82, 75, 88, 112, 84, 70, 85, 100, 101, 105, 96, 116, 86, 97, 90, 82, 102, 79, 92, 101, 110),
        Vector(71, 63, 94, 80, 70, 63, 49, 62, 83, 68, 69, 57, 57, 70, 86, 77, 68, 75, 79, 100, 78, 73, 80, 57, 88, 65, 49, 71, 44, 76, 71, 73),
        Vector(62, 62, 79, 82, 78, 80, 51, 68, 79, 58, 74, 72, 48, 73, 82, 67, 59, 71, 68, 76, 73, 78, 87, 66, 89, 68, 48, 79, 49, 83, 78, 80),
        Vector(93, 85, 92, 83, 91, 79, 62, 88, 80, 73, 71, 70, 55, 87, 91, 75, 70, 72, 86, 101, 82, 78, 91, 74, 78, 62, 63, 91, 58, 75, 75, 91),
        Vector(82, 66, 77, 77, 54, 78, 63, 75, 55, 48, 54, 60, 48, 54, 79, 61, 62, 68, 65, 81, 62, 78, 60, 69, 69, 48, 54, 68, 50, 66, 65, 75),
        Vector(76, 56, 84, 72, 60, 65, 58, 65, 61, 52, 68, 51, 71, 48, 77, 62, 57, 71, 66, 84, 72, 74, 70, 57, 75, 62, 61, 77, 54, 72, 71, 57),
        Vector(68, 61, 82, 84, 64, 74, 52, 74, 65, 57, 64, 59, 56, 58, 79, 70, 61, 71, 78, 80, 72, 67, 73, 62, 89, 56, 50, 66, 45, 66, 70, 70),
        Vector(64, 52, 78, 73, 77, 69, 45, 68, 62, 47, 57, 63, 47, 58, 65, 70, 59, 69, 65, 75, 76, 60, 59, 51, 73, 58, 47, 67, 45, 52, 58, 62),
        Vector(66, 62, 76, 47, 37, 44, 53, 67, 65, 39, 60, 24, 45, 61, 61, 64, 53, 49, 69, 81, 46, 58, 68, 58, 57, 60, 57, 61, 49, 64, 64, 74),
        Vector(89, 77, 107, 94, 78, 95, 75, 78, 91, 60, 83, 73, 60, 78, 105, 79, 79, 87, 88, 102, 86, 93, 85, 84, 100, 71, 67, 96, 56, 87, 96, 88),
        Vector(77, 68, 94, 77, 69, 74, 59, 77, 81, 54, 85, 53, 61, 68, 80, 66, 66, 73, 76, 95, 81, 76, 86, 67, 83, 61, 69, 79, 52, 71, 76, 77),
        Vector(66, 61, 90, 85, 68, 73, 62, 73, 70, 52, 75, 51, 55, 66, 85, 79, 65, 81, 83, 83, 72, 70, 69, 72, 96, 58, 59, 76, 43, 74, 77, 68),
        Vector(59, 57, 79, 79, 74, 72, 52, 60, 74, 55, 56, 72, 42, 76, 82, 66, 68, 65, 61, 81, 73, 65, 68, 60, 83, 58, 45, 73, 38, 62, 62, 66),
        Vector(74, 69, 85, 86, 69, 77, 63, 69, 65, 62, 59, 62, 41, 61, 90, 62, 62, 77, 75, 92, 80, 81, 71, 67, 80, 51, 52, 81, 46, 78, 76, 80),
        Vector(94, 84, 88, 89, 74, 81, 64, 83, 83, 70, 83, 82, 66, 75, 103, 77, 60, 89, 90, 89, 75, 84, 103, 82, 63, 77, 76, 99, 68, 88, 95, 95),
        Vector(71, 75, 88, 87, 83, 72, 62, 72, 64, 65, 70, 65, 45, 73, 89, 77, 62, 78, 65, 81, 74, 80, 87, 76, 69, 67, 58, 87, 46, 82, 79, 86),
        Vector(84, 63, 81, 94, 70, 95, 68, 70, 90, 47, 71, 75, 64, 71, 102, 83, 69, 85, 83, 86, 66, 71, 86, 67, 94, 76, 60, 82, 55, 80, 77, 90),
        Vector(78, 72, 88, 76, 56, 64, 47, 77, 75, 63, 75, 60, 66, 74, 77, 70, 65, 71, 78, 89, 68, 80, 75, 62, 80, 71, 61, 66, 66, 78, 76, 81),
        Vector(88, 79, 99, 86, 75, 84, 52, 81, 94, 58, 74, 72, 54, 88, 98, 88, 72, 73, 78, 89, 72, 85, 84, 71, 87, 82, 59, 90, 54, 85, 80, 94),
    )
    if (multMatriz(m1, m2) != esperado) {
      throw new Exception(s"\nEl resultado de multMatrizPar no coincide con el esperado")
    }
    if (multMatrizPar(m1, m2) != esperado) {
      throw new Exception(s"\nEl resultado de multMatrizPar no coincide con el esperado")
    }
    if (multMatrizRec(m1, m2) != esperado) {
      throw new Exception(s"\nEl resultado de multMatrizRec no coincide con el esperado")
    }
    if (multMatrizRecPar(m1, m2) != esperado) {
      throw new Exception(s"\nEl resultado de multMatrizRecPar no coincide con el esperado")
    }
    if (multStrass(m1, m2) != esperado) {
      throw new Exception(s"\nEl resultado de multStrass no coincide con el esperado")
    }
    if (multStrassPar(m1, m2) != esperado) {
      throw new Exception(s"\nEl resultado de multStrassPar no coincide con el esperado")
    }
  }

    test("Prueba5") {
      // Ejemplo de matriz para pruebas
      val matrizEjemplo: Matriz = Vector(
        Vector(1, 2, 3),
        Vector(4, 5, 6),
        Vector(7, 8, 9)
      )
      val esperado = Vector(Vector(1, 2), Vector(4, 5))
      if (subMatriz(matrizEjemplo, 0, 0, 2) != esperado) {
        throw new Exception(s"\nEl resultado de subMatriz no coincide con el esperado")
      }
      val matriz1 = Vector(Vector(1, 2), Vector(3, 4))
      val matriz2 = Vector(Vector(5, 6), Vector(7, 8))
      val esperado2 = Vector(Vector(6, 8), Vector(10, 12))
      if (sumMatriz(matriz1, matriz2) != esperado2) {
        throw new Exception(s"\nEl resultado de sumMatriz no coincide con el esperado.${sumMatriz(matriz1, matriz2)} 0 ${esperado}")
      }
      val matriz4 = Vector(Vector(5, 6), Vector(7, 8))
      val matriz5 = Vector(Vector(1, 2), Vector(3, 4))
      val esperado3 = Vector(Vector(4, 4), Vector(4, 4))
      if (restaMatriz(matriz4, matriz5)!= esperado3) {
        throw new Exception(s"\nEl resultado de restaMatriz no coincide con el esperado.${restaMatriz(matriz4, matriz5)} 0 ${esperado}")
      }
    }
}
