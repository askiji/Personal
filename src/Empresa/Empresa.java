package Empresa;

import java.util.ArrayList;
import java.util.List;

import Controles.Controles;
import Empleados.Puesto;
import Empleados.Trabajador;

public class Empresa {
	private Controles con = new Controles();
	private ArrayList<Trabajador> plantilla = new ArrayList<>();
	
	public void init() {
		Trabajador t1 = new Trabajador("01", "001", "0001", 1000, Puesto.Mozo);
		Trabajador t2 = new Trabajador("02", "002", "0002", 1002, Puesto.ADMINISTRATIVO);
		Trabajador t3 = new Trabajador("03", "003", "0003", 1003, Puesto.DIRECTIVO);
		Trabajador t4 = new Trabajador("04", "004", "0004", 1004, Puesto.JEFEPLANTA);
		Trabajador t5 = new Trabajador("05", "005", "0005", 1005, Puesto.JEFESECCION);
		plantilla.add(t1);
		plantilla.add(t2);
		plantilla.add(t3);
		plantilla.add(t4);
		plantilla.add(t5);
		
	}
	
	public void menu() {
		
		System.out.println("1.- Introducir Trabajador");
		System.out.println("2.- Eliminar trabajador");
		System.out.println("3.- Listado de trabajadores");
		System.out.println("4.- Listado de trabajadores por puesto");
		System.out.println("5.- Avance temporal");
		System.out.println("6.- Mostar matriz de trabajadores");
		
		int opcion = Controles.numRange(1, 6);
		switch (opcion) {
		case 1:
			introducirTrabajador();
			break;
		case 2:
			eliminarTrabajador();
			break;
		case 3:
			listado();
			break;
		default:
			break;
		}
		
	}
	
	private void listado() {
		
	}
	
	private void listarTrabajdor() {
		for (int i = 0; i < plantilla.size(); i++) {
			
			System.out.println(i+ ".- "+plantilla.get(i));
		}
	}
	
	private void eliminarTrabajador() {
		listarTrabajdor();
		System.out.println("Que trabajador desea eliminar");
		int opcion = Controles.numRange(0, plantilla.size());
		plantilla.remove(opcion);
		
	}

	private void introducirTrabajador() {
		System.out.println("Introduzca el nombre de trabajador");
		String nombre = Controles.string();
		System.out.println("Introduzca el apellido");
		String apellido = Controles.string();
		System.out.println("Introduzca el DNI");
		String dni = Controles.string();
		System.out.println("Introduzca el puesto Mozo(1) , Jefe seccion(2) , Jefe planta (3), Administrativo (4), Directivo (5)");
		Puesto puesto = Controles.puesto();
		int antiguedad = Controles.numRange(0, Integer.MAX_VALUE);
		int categoria = 1;
		if (puesto.equals(Puesto.JEFEPLANTA)) {
			ArrayList<Integer> aux = new ArrayList<>(List.of(1,2,3));
			categoria = Controles.arr(aux);
		}
		if (puesto.equals(Puesto.JEFESECCION)) {
			ArrayList<Integer> aux = new ArrayList<>(List.of(1,2,3,4));
			categoria = Controles.arr(aux);
		}
		Trabajador t1 = new Trabajador(nombre, apellido, dni, antiguedad, puesto);
		t1.setCategoria(categoria);
		plantilla.add(t1);
	}

}
