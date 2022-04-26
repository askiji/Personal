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
			return Puesto.Mozo;
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
}
