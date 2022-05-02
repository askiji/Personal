package Empleados;

public class Trabajador implements Cobros{
	private String nombre;
	private String apellido;
	private String dni;
	private int antiguedad;
	private int categoria=1;
	private Puesto puesto;
	private boolean consejo=false;
	
	
	public double indemnizacion() {
		double a = sueldoneto() * 20/365;
		if(Puesto.JEFEPLANTA.equals(puesto) || Puesto.JEFESECCION.equals(puesto)) {
			a+= 400*categoria;
		}
		if(Puesto.DIRECTIVO.equals(puesto)) {
			a+=a;
		}
		return a;
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}

	public Puesto getPuesto() {
		return puesto;
	}

	public void setPuesto(Puesto puesto) {
		this.puesto = puesto;
	}

	public double sueldoneto() {
		int aniosTrabajados = antiguedad / 365;
		double bruto = puesto.sBruto();
		for (int i = 0; i < aniosTrabajados; i++) {
			if (consejo) {
				bruto+=2400;
			} 
			bruto = (bruto + (puesto.primaCategoria() * categoria) * 12) * (puesto.aumento() + 1);
		}
		return bruto;
	}

	@Override
	public String toString() {
		return "Trabajador  : nombre = " + nombre + ", apellido = " + apellido + ", dni = " + dni + ", antiguedad = " + antiguedad
				+ ", puesto = " + puesto ;
	}

	public Trabajador(String nombre, String apellido, String dni, int antiguedad, Puesto puesto) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.antiguedad = antiguedad;
		this.puesto = puesto;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	
	public void setConsejo() {
		this.consejo= true;
	}

}
