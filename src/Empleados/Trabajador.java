package Empleados;

public class Trabajador implements Cobros{
	private String nombre;
	private String apellido;
	private String dni;
	private int antiguedad;
	private int categoria=1;
	private Puesto puesto;
	
	
	public double indemnizacion() {
		double a=1;
		return a;
	}

	public double sueldoneto() {
		double a=1;
		int aniosTrabajados = antiguedad/365;
		double bruto=puesto.sBruto();
		
//		to do
		for (int i = 0; i < aniosTrabajados; i++) {
			bruto = (bruto+(puesto.primaCategoria()*categoria))*(puesto.aumento()+1);
			
		}
		
		a =2;
		
		return a;
	}
	
	@Override
	public String toString() {
		return "Trabajador [nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", antiguedad=" + antiguedad
				+ ", puesto=" + puesto + "]";
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

}
