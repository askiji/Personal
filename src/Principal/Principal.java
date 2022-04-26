package Principal;

import Empleados.Trabajador;
import Empresa.Empresa;

public class Principal {

	public static void main(String[] args) {
		Empresa empresa = new Empresa();
		empresa.init();
		
		int a = 5;
		int b = 6;
		System.out.println(a/b);
		
		while (true) {
			
			empresa.menu();
		}

	}

}
