package com.fca.calidad.DoublesDAO;

public class Alumno {
private String nombre;
private String id;
private int edad;
private String email;
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public int getEdad() {
	return edad;
}
public void setEdad(int edad) {
	this.edad = edad;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Alumno(String nombre, String id, int edad, String email) {
	super();
	this.nombre = nombre;
	this.id = id;
	this.edad = edad;
	this.email = email;
}
}
