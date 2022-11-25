package com.fca.calidad.Calculadora;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.fca.calidad.pruebas.algebra;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class AritmeticaParametrizadaTest {
	private float arg1;
	private float arg2;
	private float arg3;
	private Calculadora miCalculadora; //Object
	private algebra mycalculadora;
	
	public AritmeticaParametrizadaTest (float arg1, float arg2, float arg3) {
	this.arg1 = arg1;
		this.arg2 = arg2;
		this.arg3 = arg3;
	}

	//set parameters to test
	@Parameters
		public static Collection<Object[]>data() {
			return Arrays.asList(new Object[][] {
				{4,2,2},			//Integers
				{6,-3,-2},			//Negative Integer
				{5,5,1},
				{5,2,2.5f},
				{5,-2,-2.5f},
				});
		}
		private Calculadora myCalculadora ;
	@Before
	public void setUp() throws Exception {
		//Create new object
		mycalculadora = new algebra();
	}
	
	@Test
	public void sumaTest() {
		//Inicializar
		double resultadoEsperado= 4; //2+2
		double resultadoEjecucion = 0;
		//Ejercicio del codigo
		resultadoEjecucion = mycalculadora.suma(2,2);
		//Verificar
		//assertThat(resultadoEsperado, is(resultadoEjecucion));
		System.out.println("Resultado de la suma"+resultadoEjecucion);
	}

	@Test
	public void restaTest() {
		//Inicializar
		double resultadoEsperado= 1; //3-2
		double resultadoEjecucion = 0;
		//Ejercicio del codigo
		resultadoEjecucion = mycalculadora.resta(3,2);
		//Verificar
		//assertThat(resultadoEsperado, is(resultadoEjecucion));
		System.out.println("Resultado de la resta"+resultadoEjecucion);
	}
	
	@Test
	public void multiplicaTest() {
		//Inicializar
		double resultadoEsperado= 9; //3x3
		double resultadoEjecucion = 0;
		//Ejercicio del codigo
		resultadoEjecucion = mycalculadora.multiplicacion(3,3);
		//Verificar
		//assertThat(resultadoEsperado, is(resultadoEjecucion));
		System.out.println("Resultado de la multiplicación"+resultadoEjecucion);
	}
	
	
	@Test
	public void divideTestEntre0() {
		//Inicializar
		double pInfiniteDouble = Double.POSITIVE_INFINITY; 
		double resultadoEsperado= pInfiniteDouble; //10/
		double resultadoEjecucion = 0;
		//Ejercicio del codigo
		resultadoEjecucion = mycalculadora.division(10,0);
		//Verificar
		//assertThat(resultadoEsperado, is(resultadoEjecucion));
		System.out.println("Resultado de dividir entre 0"+resultadoEjecucion);
	}

	

	@Test(expected = ArithmeticException.class)
	public void divideTestExcepcion() {
		//No se verifica, solo se llama a la ejecucion cuando son excepciones
		mycalculadora.divisionEntera(10,0);
	}
	

}