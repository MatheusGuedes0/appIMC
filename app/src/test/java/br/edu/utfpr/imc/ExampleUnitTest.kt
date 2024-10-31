package br.edu.utfpr.imc

import org.junit.Test

import org.junit.Assert.*


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

class ExampleUnitTest {

    @Test
    fun addition_isCorrect() {
        val calcula = Calcula()
        assertTrue( "IMC calculado corretamente", calcula.calculaIMC(90.0,1.9) in 24.93 .. 24.94)
    }
}