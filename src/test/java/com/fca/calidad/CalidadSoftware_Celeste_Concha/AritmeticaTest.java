package com.fca.calidad.CalidadSoftware_Celeste_Concha;

import org.junit.After;
import org.junit.Before; 
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AritmeticaTest {
private Aritmetica aritmetica;

@Before 
public void setup()throws Exception {
	aritmetica = new Aritmetica ();
	System.out.println("Este es el before");
	
}
@After
public void tearDown()throws Exception {
	aritmetica = new Aritmetica ();
	System.out.println("Este es el after");
}
@Test 
public void sumaTest () {
	//Inicializar 
	double resultadoSuma = 4; // 2+2
	double resultadoEjecucion = 0;
	//Ejercicio del código
	resultadoEjecucion = aritmetica.suma(2, 2);
	//Verificar 
	
	
}
@Test 
public void restaTest () {
	
	
}
}
