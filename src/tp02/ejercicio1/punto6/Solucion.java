package tp02.ejercicio1.punto6;

import tp02.ejercicio1.ListaDeEnteros;
import tp02.ejercicio1.ListaDeEnterosEnlazada;

public class Solucion {

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		ListaDeEnteros lista = new Solucion().calcularSucesion(n);

		System.out.println(lista);
	}

	public ListaDeEnteros calcularSucesion(int n) {
		ListaDeEnteros lista;
		if (n == 1)
			lista = new ListaDeEnterosEnlazada();
		else
			lista = (n % 2 == 0) ? calcularSucesion(n / 2) : calcularSucesion(3 * n + 1);
		lista.agregarInicio(n);
		return lista;
	}

}
