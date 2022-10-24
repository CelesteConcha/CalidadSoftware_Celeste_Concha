package com.fca.calidad.doubles;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

public class DependencyTest {

	Dependency dependency;

	@Before
	public void setUp() throws Exception {
		dependency = Mockito.mock(Dependency.class);
	}

	@After 
	public void tearDown() throws Exception {
	}

	@Test
	public void testDummy() {
		assertThat(dependency.getClassName(), is(nullValue()));
		//assertThat(dependency.getClassName(), is("Dependency"));
	}
	
	private void setBehavior() {
		when(dependency.getClassName()).thenReturn("Nombre de la clase"); 
	}
	@Test
	public void getClassNameTest() {
		setBehavior();
		String resultadoEsperado = "Nombre de la clase";
		String resultadoEjecucion= dependency.getClassName();
		assertThat(resultadoEjecucion, is(resultadoEsperado));
		//assertThat(dependency.getClassName(), is("Dependency"));
	}
	private void setBehaviorAdd() {
		when(dependency.addTwo(0)).thenReturn(6);
	}
	@Test
	public void addTwoTest() {
		setBehaviorAdd();
		int resultadoEsperado = 6;
		int resultadoEjecucion=dependency.addTwo(0);
		assertThat(resultadoEjecucion, is(resultadoEsperado));
	}
	@Test
	public void mockArgument_Test() { //usando anyint (matchers)
		int resultadoEsperado2 = 2;
		when(dependency.addTwo(anyInt())).thenReturn(2);
		int resultadoEjecucion2 = dependency.addTwo(0);
		assertThat(resultadoEsperado2, is(resultadoEjecucion2));
	}
	@Test(expected = ArithmeticException.class) //comportamiento para tirar excepciones 
	public void excepcionEsperadaTest() {
		when (dependency.getClassName()).thenThrow(ArithmeticException.class);
		dependency.getClassName();
	}
	//CallRealMethod
	@Test
	public void callRealTest() { //usando anyint (matchers)
		int resultadoEsperado3 = 2;
		when(dependency.addTwo(anyInt())).thenCallRealMethod();
		int resultadoEjecucion3 = dependency.addTwo(0);
		assertThat(resultadoEsperado3, is(resultadoEjecucion3));
	}
	//Answer
	@Test
	public void testAnswer() {
		when(dependency.addTwo(anyInt())).thenAnswer(new Answer<Integer>() {
			public 	Integer answer(InvocationOnMock invocation) throws Throwable{
					int arg = (Integer) invocation.getArguments()[0];
					System.out.println("Este es el argumento del thenAnswer: " + arg);
					System.out.println("Este es la suma más 2: " + (arg+2));
					return arg + 10;
			}
		}
	);
		assertThat(20,is(dependency.addTwo(10)));
		assertThat(49,is(dependency.addTwo(39)));
	}
	
}
