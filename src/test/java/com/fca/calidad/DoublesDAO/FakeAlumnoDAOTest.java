package com.fca.calidad.DoublesDAO;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matcher;
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
	public void updateEmailTest() {
		when(alumnoDAO.updateEmail(any(Alumno.class))).thenAnswer(new Answer<Boolean>(){
			public Boolean answer(InvocationOnMock invocation) throws Throwable {
				Alumno arg = (Alumno) invocation.getArguments() [0];
				Alumno alumno = new Alumno("nombre", "id", 14, "email");
				baseDatos.put("1", alumno);
				baseDatos.put(arg.getId(), arg);
				return true;
			}
		}
	);
		//Stup
		//agregarlo a la base de datos
		Alumno alumno = new Alumno("nombre", "1", 14, "email");
		baseDatos.put("1", alumno);
		
		alumno.setEmail("nuevoCorreo");
		alumnoDAO.updateEmail(alumno);
		String valorEsperado = "nuevoCorreo";
		String valorEjecucion = baseDatos.get("1").getEmail();
		assertThat(valorEsperado,is(valorEjecucion));
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
	@Test
	public void deleteAlumno() {
		when(alumnoDAO.deleteAlumno(any(Alumno.class))).thenAnswer(new Answer<Boolean>(){
			public Boolean answer(InvocationOnMock invocation) throws Throwable {
				Alumno arg = (Alumno) invocation.getArguments() [0];
				baseDatos.remove (arg.getId());
				System.out.println("Size despues=" + baseDatos.size() + "/n");
				return true;
			}
		}
	);
	
Alumno a= new Alumno("nombre", "id", 14, "email");
int sizeBefore = baseDatos.size();
Boolean res = alumnoDAO.deleteAlumno(a);
int sizeAfter =baseDatos.size();
 assertThat(sizeAfter, is(sizeBefore+0));
}
	@Test
	public void searchAlumno() {
		when(alumnoDAO.searchAlumno(any(String.class))).thenAnswer(new Answer<Alumno>(){
			public Alumno answer(InvocationOnMock invocation) throws Throwable {
				String arg = (String) invocation.getArguments() [0];
				baseDatos.toString();
				System.out.println("Size despues=" + baseDatos.size() + "/n");
			
			}
		}
	);
	
Alumno id= new Alumno("nombre", "id", 14, "email");
int sizeBefore = baseDatos.size();
Alumno res = alumnoDAO.searchAlumno(id);
int sizeAfter =baseDatos.size();
 assertThat(sizeAfter, is(sizeBefore+0));
}
}