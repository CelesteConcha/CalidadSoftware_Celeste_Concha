package com.fca.calidad.Calculadora;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fca.calidad.pruebas.algebra;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Calculadora {

private algebra aritmetica;
	
	@Before
	public void setUp() throws Exception {
		aritmetica = new algebra();
		
	}

	@Test
	public void sumaTest() {
		double resultadoEsperado = 4; //2+2
		double resultadoEjecucion = 0;
		resultadoEjecucion = aritmetica.suma(2.0, 2.0);
		assertThat(resultadoEsperado, is(resultadoEjecucion));
		System.out.println("Resultado Suma "+resultadoEjecucion);
	}
	@Test
	public void restaTest() {
		double resultadoEsperado = 4; 
		double resultadoEjecucion = 0;
		resultadoEjecucion = aritmetica.resta(6.0, 2.0);
		assertThat(resultadoEsperado, is(resultadoEjecucion));
		System.out.println("Resultado resta " +resultadoEjecucion);
	}
	
	@Test
	public void multiplicacionTest( ) {
		double resultadoEsperado = 6; 
		double resultadoEjecucion = 0;
		resultadoEjecucion = aritmetica.multiplicacion(3.0, 2.0);
		assertThat(resultadoEsperado, is(resultadoEjecucion));
		System.out.println("Resultado multiplicación " +resultadoEjecucion);
	}
	
	@Test
	public void divisionTest() {
		double resultadoEsperado = 6; 
		double resultadoEjecucion = 0;
		resultadoEjecucion = aritmetica.division(18.0, 3.0);
		assertThat(resultadoEsperado, is(resultadoEjecucion));
		System.out.println("Resultado división " +resultadoEjecucion);
	}
	
	@Test
	public void divideTestEntre0() {
		double pInfiniteDouble = Double.POSITIVE_INFINITY; 
		double resultadoEsperado= pInfiniteDouble; 
		double resultadoEjecucion = 0;
		resultadoEjecucion = aritmetica.division(10,0);
		assertThat(resultadoEsperado, is(resultadoEjecucion));
		System.out.println("Resultado división entre 0 " +resultadoEjecucion);
	}
}