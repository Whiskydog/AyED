package tp02.ejercicio1.punto5;

import java.util.List;

import tp02.ejercicio1.ListaDeEnteros;
import tp02.ejercicio1.ListaDeEnterosEnlazada;

public class Solucion {

	public static void main(String[] args) {
		ListaDeEnteros lista = new ListaDeEnterosEnlazada();
		List.of(1, 2, 3, 4, 5).forEach(i -> lista.agregarFinal(i));
		
		lista.comenzar();
		new Solucion().printRec(lista);
	}
	
	public void printRec(ListaDeEnteros lista) {
		int i = lista.proximo();
		if (!lista.fin())
			printRec(lista);
		System.out.println(i);
	}

}
