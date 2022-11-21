package com.fca.calidad.DoublesDAO;
//Prueba del mockito
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.*;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class FakeAlumnoDAOTest {
	private FakeAlumnoDao alDAO;
	public HashMap<String, Alumno> baseDatos;

	@Before
	public void setUp() throws Exception {
		alDAO = Mockito.mock(FakeAlumnoDao.class);
		baseDatos = new HashMap<String,Alumno>();
	}
	
	//Realizamos las pruebas 
	
	//Prueba 1 agregar Alumno 
		@Test
	public void agregaAlumnoTest() {
		when(alDAO.addAlumno(any(Alumno.class))).thenAnswer(new Answer<Boolean>(){
			public Boolean answer(InvocationOnMock invocation) throws Throwable {
				Alumno arg = (Alumno) invocation.getArguments() [0];
				baseDatos.put ("1", arg);
				System.out.println("addAlumno=" + baseDatos.size() + "\n");
				return true;
			}
		}
	);
Alumno a= new Alumno("nombre", "id", 14, "email");
int sizeBefore = baseDatos.size();
Boolean res = alDAO.addAlumno(a);
int sizeAfter =baseDatos.size();
 assertThat(sizeAfter, is(sizeBefore+1));
	}
	//prueba 2 Actualizar correo
	@Test
	public void actualizarEmailTest() {
		when(alDAO.updateEmail(any(Alumno.class))).thenAnswer(new Answer<Boolean>(){
			public Boolean answer(InvocationOnMock invocation) throws Throwable {
				Alumno arg = (Alumno) invocation.getArguments() [0];
				baseDatos.put(arg.getId(), arg);
				return true;
			}
		}
	);
		Alumno al = new Alumno("nombre", "id", 14, "email");
		baseDatos.put("1", al);
		//cambiar correo
		al.setEmail("nuevoCorreo");
		//llamamos al método 
		Boolean res = alDAO.updateEmail(al);
		//verificamos
		String valorEsperado = "nuevoCorreo";
		String valorEjecucion = baseDatos.get("1").getEmail();
		assertThat(valorEsperado,is(valorEjecucion));
		System.out.println("Email Actualizado: " + res+"\n");
	}
	//Prueba 3 buscar alumno
	@Test
	public void buscaralumnoTest() {
		when(alDAO.searchAlumno(any(String.class))).thenAnswer(new Answer<Alumno>() { //en el documento IAlumnoDAO está como Alumno (los otros están en boolean)
			public Alumno answer(InvocationOnMock invocation) throws Throwable{
				String id = (String) invocation.getArguments()[0];
				Alumno alum = baseDatos.get(id);
				return alum;
			}
		});
		Alumno alum = new Alumno("nombre", "1", 14, "email");
		baseDatos.put("1", alum);
		Alumno res = alDAO.searchAlumno("1"); //Realizamos la busqueda
		String buscanombres = res.getNombre();
		String buscaid = res.getId();
		int buscaedad = res.getEdad();
		String buscaemail = res.getEmail();
		String nombre = baseDatos.get("1").getNombre();
		String id = baseDatos.get("1").getId();
		int edad = baseDatos.get("1").getEdad();
		String email = baseDatos.get("1").getEmail();
		assertThat(nombre,is(buscanombres)); assertThat(id,is(buscaid));
		assertThat(edad,is(buscaedad));assertThat(email,is(buscaemail));
		System.out.println("Busqueda: " + res);}
//Prueba 4 eliminar Alumno
	@Test
	public void eliminarAlumnoTest() {
		when(alDAO.deleteAlumno(any(Alumno.class))).thenAnswer(new Answer<Boolean>(){
			public Boolean answer(InvocationOnMock invocation) throws Throwable {
				Alumno arg = (Alumno) invocation.getArguments() [0];
				Alumno al= new Alumno("nombre", "id", 14, "email");
				baseDatos.remove ("1",al);
				System.out.println("eliminado=" + baseDatos.size() + "\n");
				return false;
			}
		}
	);
	
Alumno a= new Alumno("nombre", "id", 14, "email");
int sizeBefore = baseDatos.size();
Boolean res = alDAO.deleteAlumno(a);
int sizeAfter =baseDatos.size();
 assertThat(sizeAfter, is(sizeBefore));
	}
}