package Empresa;

import java.util.ArrayList;
import java.util.List;

import Controles.Controles;
import Empleados.Puesto;
import Empleados.Trabajador;

public class Empresa {
	
	private ArrayList<Trabajador> plantilla = new ArrayList<>();
	
	public void init() {
		Trabajador t1 = new Trabajador("01", "001", "0001", 1000, Puesto.MOZODEALMACEN);
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
			listarTrabajdor();
			mostrar();
			break;
		case 4:
			mostrarPuesto();
			break;
		case 5:
			avanzar();
			break;
		case 6:
			matriz();
			break;
		default:
			break;
		}
	}
	
	private ArrayList<Double> cuadrante(Puesto puesto){
		double max=0;
		double min=Double.MAX_VALUE;
		double avrg=0;
		int aux=0;
		for (Trabajador trabajador : plantilla) {
			if(trabajador.getPuesto().equals(puesto)) {
				if(max<trabajador.getAntiguedad()) {
					max=trabajador.getAntiguedad();
				}
				if(min>trabajador.getAntiguedad()) {
					min=trabajador.getAntiguedad();
				}
				avrg+=trabajador.getAntiguedad();
				aux++;
			}
		}
		ArrayList<Double> arr= new ArrayList<>();
		if(aux!=0) {
			arr.add(min);
			arr.add(max);
			arr.add(avrg/aux);
		}
		else {
			arr.add(0.0);
			arr.add(0.0);
			arr.add(0.0);
		}
		return arr;
	}
	
	private void matriz() {
		for (Puesto puesto : Puesto.values()) {
			ArrayList<Double> arr= cuadrante(puesto);
			System.out.print(puesto + " \t");
			System.out.print(arr.get(0) + " min dias \t");
			System.out.print(arr.get(1) + " max dias \t");
			System.out.println(arr.get(2) + " media de dias \t");
		}
		System.out.println();
	}
	private void avanzar() {
		System.out.println("Cuantos dias desea abanzar");
		int dias = Controles.numRange(0, Integer.MAX_VALUE);
		for (Trabajador trabajador : plantilla) {
			trabajador.setAntiguedad(trabajador.getAntiguedad()+dias);
		}
	}
	
	private void mostrarPuesto() {
		System.out.println("Introduzca el puesto Mozo(1) , Jefe seccion(2) , Jefe planta (3), Administrativo (4), Directivo (5)");
		Puesto puesto = Controles.puesto();
		for (int i = 0; i < plantilla.size(); i++) {
			if(plantilla.get(i).getPuesto().equals(puesto)){
				System.out.print(plantilla.get(i));
				System.out.println(", sueldo neto = " + plantilla.get(i).sueldoneto());
			}
		}
	}
	
	private void mostrar() {
		System.out.println("Que trabajador desea mostrar");
		int opcion = Controles.numRange(0, plantilla.size());
		System.out.print("El sueldo bruto es :");
		System.out.println(plantilla.get(opcion).sueldoneto());
		System.out.print("La indenizacion es: ");
		System.out.println(plantilla.get(opcion).indemnizacion());
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
		System.out.println("Introdizca antiguedad");
		int antiguedad = Controles.numRange(0, Integer.MAX_VALUE);
		int categoria = 1;
		boolean directivo= false;
		if (puesto.equals(Puesto.JEFEPLANTA)) {
			System.out.println("Introduzca categoria");
			ArrayList<Integer> aux = new ArrayList<>(List.of(1,2,3));
			categoria = Controles.arr(aux);
		}
		if (puesto.equals(Puesto.JEFESECCION)) {
			System.out.println("Introduzca categoria");
			ArrayList<Integer> aux = new ArrayList<>(List.of(1,2,3,4));
			categoria = Controles.arr(aux);
		}
		if(puesto.equals(Puesto.DIRECTIVO)) {
			System.out.println("Es miembro del consejo s , no ");
			directivo = Controles.checkSN();
		}
		Trabajador t1 = new Trabajador(nombre, apellido, dni, antiguedad, puesto);
		if(directivo) {
			t1.setConsejo();
		}
		t1.setCategoria(categoria);
		plantilla.add(t1);
	}

}
