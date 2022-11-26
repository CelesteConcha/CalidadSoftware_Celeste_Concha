package com.fca.calidad.pruebas;

public class algebra {
	
	private double ultimoResultado;
	public double suma(Double primerSumando, double segundoSumando) {
		return ultimoResultado = primerSumando + segundoSumando;
	}
	public double resta(Double minuendo, double sustraendo) {
		return ultimoResultado = minuendo-sustraendo;
	}
	public double multiplicacion(double primerFactor,
			double segundoFactor) {
		return ultimoResultado = primerFactor * segundoFactor;
	}
	public double division(double dividendo, double divisor) {
		return ultimoResultado = dividendo / divisor;
	}
	public double divisionEntera(double dividendo, double divisor) {
		return dividendo/divisor;
	}
	public double getUltimoResultado() {
		return ultimoResultado;
	}
}
