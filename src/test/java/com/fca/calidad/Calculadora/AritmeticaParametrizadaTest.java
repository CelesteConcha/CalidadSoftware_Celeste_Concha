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
	 private double arg1;
	 private double arg2;
	 private double arg3;
	 private algebra miAritmetica;
	 
	 public AritmeticaParametrizadaTest(double arg1, double arg2, double arg3) {
		 this.arg1 =arg1;
		 this.arg2 =arg2;
		 this.arg3= arg3;
	 }
	 @Parameters
	 public static Collection<Object[]>data(){
		 return Arrays.asList(new Object[][] {
			 {4,2,2},
			 {6,-3,-2},
			 {5,5,1},
			 {5,2,2.5},
			 {5,-2,-2.5}
		
		
		 });
	 }

	@Before
	public void setUp() throws Exception {
		miAritmetica = new algebra();
	}

	@After
	public void tearDown() throws Exception {
	}

	
	
	@Test
	public void test() {
		Double resEjecucion=  miAritmetica.divisionEntera(this.arg1, this.arg2);
		
		assertThat(this.arg3, is(resEjecucion));
		System.out.println("Resultados del arreglo división " +resEjecucion);
	}
	

}