package tp03.ejercicio5;

import tp02.ejercicio3.ColaGenerica;
import tp03.ejercicio1.ArbolBinario;

public class ProfundidadDeArbolBinario {
	private ArbolBinario<Integer> arbol;

	public ProfundidadDeArbolBinario(ArbolBinario<Integer> arbol) {
		this.arbol = arbol;
	}

	public int sumaElementosProfundidad(int p) {
		ColaGenerica<ArbolBinario<Integer>> cola = new ColaGenerica<>();
		cola.encolar(arbol);
		cola.encolar(null);

		int sum = 0;
		int nivel = 0;
		while (!cola.esVacia()) {
			ArbolBinario<Integer> actual;
			while (!cola.esVacia() && (actual = cola.desencolar()) != null) {
				// Si estamos en el nivel deseado, no encolamos el proximo nivel
				if (nivel == p)
					sum += actual.getDato();
				else {
					if (actual.tieneHijoIzquierdo())
						cola.encolar(actual.getHijoIzquierdo());
					if (actual.tieneHijoDerecho())
						cola.encolar(actual.getHijoDerecho());
				}
			}
			// Si la cola no esta vacia significa que aun no llegamos al nivel deseado
			if (!cola.esVacia()) {
				nivel++;
				cola.encolar(null);
			}
		}

		return sum;
	}
}
