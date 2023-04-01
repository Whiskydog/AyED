package tp03.ejercicio3;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp03.ejercicio1.ArbolBinario;

public abstract class ContadorArbol {
	private ArbolBinario<Integer> arbol;

	public ContadorArbol(ArbolBinario<Integer> arbol) {
		this.arbol = arbol;
	}

	public ListaGenerica<Integer> numerosPares() {
		ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<>();
		coleccionarPares(arbol, lista);
		return lista;
	}

	protected abstract void coleccionarPares(ArbolBinario<Integer> arbol, ListaGenerica<Integer> lista);
}
