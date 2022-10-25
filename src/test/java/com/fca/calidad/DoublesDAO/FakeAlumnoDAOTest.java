package com.fca.calidad.DoublesDAO;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class FakeAlumnoDAOTest {
	private FakeAlumnoDao alumnoDAO;
	public HashMap<String, Alumno> baseDatos;

	@Before
	public void setUp() throws Exception {
		alumnoDAO = Mockito.mock(FakeAlumnoDao.class);
		baseDatos = new HashMap<String,Alumno>();
	}
	
	@Test
	public void agregarTest() {
		when(alumnoDAO.addAlumno(any(Alumno.class))).thenAnswer(new Answer<Boolean>(){
			public Boolean answer(InvocationOnMock invocation) throws Throwable {
				Alumno arg = (Alumno) invocation.getArguments() [0];
				baseDatos.put ("1", arg);
				System.out.println("Size despues=" + baseDatos.size() + "/n");
				return true;
			}
		}
	);
	
Alumno a= new Alumno("nombre", "id", 14, "email");
int sizeBefore = baseDatos.size();
Boolean res = alumnoDAO.addAlumno(a);
int sizeAfter =baseDatos.size();
 assertThat(sizeAfter, is(sizeBefore+1));

	}

}
