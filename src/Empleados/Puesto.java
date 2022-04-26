package Empleados;

public enum Puesto {
Mozo(1545.5,0,0.85,5),
JEFESECCION(1750,50,0.83,7),
JEFEPLANTA(1825.5,60,0.81,9),
ADMINISTRATIVO(1635,0,0.84,6),
DIRECTIVO(4500,100,0.73,12);
	
private double bruto , neto;
private int primaCategoria , aumento;

Puesto(double bruto, int primaCategoria, double neto, int aumento) {
	this.bruto = bruto;
	this.primaCategoria = primaCategoria;
	this.neto = neto;
	this.aumento= aumento;
	
}
public double sBruto() {
	return bruto;
}
public int primaCategoria() {
	return primaCategoria; 
}
public double neto() {
	return neto;
}
public int aumento() {
	return aumento;
}
}
