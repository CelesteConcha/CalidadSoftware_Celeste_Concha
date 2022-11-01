package com.fca.calidad.dbunit;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matcher;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;


public class DAOEstudianteSQlite {
IDatabaseConnection connection;
@Before

public void setUp() throws Exception {

super.setUp();

Connection jdbcConnection;

 

jdbcConnection = DriverManager.getConnection

("jdbc:sqlite:C:\\Users\\alnmi\\OneDrive\\Escritorio\\Clases\\Calidad\\Proyectos java\\Alumnos.db");

 

connection = new DatabaseConnection(jdbcConnection);

 

try {

 

PreparedStatement preparedStatement;

preparedStatement = jdbcConnection.prepareStatement("Delete from sqlite_sequence WHERE name = ?");

// Set the values to match in the ? on query

 

 

preparedStatement.setString(1, "Estudiante");

 

Boolean result = false;

 

// Return the result of connection and statement

if (preparedStatement.executeUpdate() >= 1) {

result = true;

}

preparedStatement.close();

 

DatabaseOperation.CLEAN_INSERT.execute(connection, getDataSet());

} catch(Exception e) {

fail("Error in setup: " + e.getMessage());

connection.close();

} 

}

 

@After

public void tearDown()

{

try {

if (connection != null)

connection.close();

} catch (SQLException e) {

// TODO Auto-generated catch block

e.printStackTrace();

}

}

public IDatabaseConnection getConnection()  {

returnconnection;

}



	@Test
	public void crearEstudianteTest() {
		Estudiante alumno = new Estudiante("nombreprueba","apellidocrear","emailcrear","carreracrear");
		
		//insertar en la tabla 
		int diNuevo =daoSQLite.createEstudiante(alumno);
		//verificar 
		int numEsperado =4;
		int numReal =-1;
		try {
			IDataSet databaseDataSet = getConnection().createDataSet();
			ITable actualTable = databaseDataSet.getTable("Estudiante");
			numReal = actualTable.getRowCount();
			assertThat(numEsperado,is(numReal));
		}catch(Exception e) {
			System.out.println("Error en crearAlumnoTest");
		}
	}

}
