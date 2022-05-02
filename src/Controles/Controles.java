package Controles;

import java.util.ArrayList;
import java.util.Scanner;

import Empleados.Puesto;

public class Controles {
	private static Scanner sc = new Scanner(System.in);	
	public static int numRange(int a , int b) {
		try {
			int opcion = Integer.valueOf(sc.nextLine());
			if(opcion>=a && opcion<=b) {
				return opcion;
			}
			else {
				System.out.println("Numero fuera de rango");
				return Controles.numRange(a, b);
			}
		} catch (Exception e) {
			System.out.println("No ha introducido un numero");
			return Controles.numRange(a, b);
		}
	}
	
	public static String string() {
		return sc.nextLine();
	}
	
	public static Puesto puesto() {
		int opcion = Controles.numRange(1, 5);
		if (opcion==1) {
			return Puesto.MOZODEALMACEN;
		}
		if (opcion==2) {
			return Puesto.JEFESECCION;
		}
		if (opcion==3) {
			return Puesto.JEFEPLANTA;
		}
		if (opcion==4) {
			return Puesto.ADMINISTRATIVO;
		}
		if (opcion==5) {
			return Puesto.DIRECTIVO;
		}
		return null;
	}
	
	// un poco over kill para 4 categorias pero si hay que cambiarlo imagino que seria mas facil , mirar como meter las categorias en enum de una forma decente
	public static int arr(ArrayList<Integer> array) {
		int opcion = Controles.numRange(Integer.MIN_VALUE, Integer.MAX_VALUE);
		if(array.contains(opcion)) {
			return opcion;
		}
		else {
			System.out.println("Introduzca una opcion valida");
			for (int i = 0; i < array.size(); i++) {
				System.out.print(array.get(i)+" ");
			}
			return Controles.arr(array);
		}
	}
	
	public static boolean checkSN() {
		try {
			String aux = sc.nextLine();
			if (aux.equalsIgnoreCase("s")) {
				return true;
			}
			if(aux.equalsIgnoreCase("n")) {
				return false;
			}
			else {
				System.out.println("introduzca Si 's' o No 'n'");
				return Controles.checkSN();
			}
		} catch (Exception e) {
			System.out.println("introduzca Si 's' o No 'n'");
			return Controles.checkSN();
		}
	}
}
